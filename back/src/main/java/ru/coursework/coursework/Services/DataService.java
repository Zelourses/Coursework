package ru.coursework.coursework.Services;

import org.springframework.stereotype.Service;
import ru.coursework.coursework.DTO.response.DataResponse;
import ru.coursework.coursework.Entity.Complaint;
import ru.coursework.coursework.Entity.Farmer;
import ru.coursework.coursework.Handlers.Complaint.ComplaintContainer;
import ru.coursework.coursework.Handlers.Complaint.ComplaintGenerator;
import ru.coursework.coursework.Handlers.Constants;
import ru.coursework.coursework.Repositories.ComplaintsRepository;
import ru.coursework.coursework.Repositories.FarmerRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DataService {

    final DateService dateService;
    final FarmerRepository farmerRepository;
    final ComplaintsRepository complaintsRepository;
    final ComplaintGenerator complaintGenerator;

    static List<Farmer> farmers =new ArrayList<>();
    static ComplaintContainer[] complaints = new ComplaintContainer[Constants.AMOUNT_OF_COMPLAINTS];
    static List<Complaint> tmp_complaints = new ArrayList<>();
    static List<Integer> farmers_id = new ArrayList<>();

    public DataService(DateService dateService,
                       FarmerRepository farmerRepository,
                       ComplaintsRepository complaintsRepository,
                       ComplaintGenerator complaintGenerator) {
        this.dateService = dateService;
        this.farmerRepository = farmerRepository;
        this.complaintsRepository = complaintsRepository;
        this.complaintGenerator = complaintGenerator;
    }

    public DataResponse nextDay(){
        dateService.nextDay();
        return generateData();
    }

    public DataResponse getData(){
        if (Arrays.stream(complaints).anyMatch(Objects::isNull)) {
            return  generateData();
        }
        return new DataResponse().setDate(dateService.getDate()).setComplaints(complaints);
    }

    private DataResponse generateData(){
        int amountOfFarmers=(int) farmerRepository.count();
        for (int i=0;i<Constants.AMOUNT_OF_COMPLAINTS;i++){
            // It will choose farmer from id 1 to max id
            farmers_id.add(ThreadLocalRandom.current().nextInt(1,amountOfFarmers+1));
        }
        farmers = farmerRepository.findAllById(farmers_id);
        int farmersSize=farmers.size();
        for (int i=0;i< Constants.AMOUNT_OF_COMPLAINTS;i++){
            farmers.get(i%farmersSize).addCounter_denunciation(1);
            int square = ThreadLocalRandom.current().nextInt(1,64);
            complaints[i] = complaintGenerator.generateComplaint(farmers.get(i%farmersSize),square,dateService.getDate());
            tmp_complaints.add(new Complaint(farmers.get(i%farmersSize),square,complaints[i].getComplaint()));

        }
        complaintsRepository.saveAll(tmp_complaints);
        farmerRepository.saveAll(farmers);
        return new DataResponse().setDate(dateService.getDate()).setComplaints(complaints);
    }

}
