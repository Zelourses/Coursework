package ru.coursework.coursework.Handlers.Complaint;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;
import ru.coursework.coursework.Entity.Farmer;
import ru.coursework.coursework.Handlers.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

@Service
public class ComplaintGenerator {
    static List<AbstractComplaint> listOfComplaints = new ArrayList<>();
    static List<AbstractTitle> listOfTitles = new ArrayList<>();

    //I don't think that it's right to pu it all in constructor
    public ComplaintGenerator(){
        try(Stream<String> stream = Files.lines(Paths.get(Constants.PATH_TO_COMPLAINTS_FILE))){
            stream.forEach(x->{
                String[] data = x.split(Constants.COMPLAINT_SPLITTER);
                listOfComplaints.add(new AbstractComplaintImpl(data[0], data[1].equals("true")));
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        try(Stream<String> stream = Files.lines(Paths.get(Constants.PATH_TO_TITLES_FILE))){
            stream.forEach(x->{
                listOfTitles.add(new AbstractTitleImpl(x));
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ComplaintContainer generateComplaint(Farmer farmer,int square,String date){
        AbstractComplaint complaint = listOfComplaints.get(ThreadLocalRandom.current().nextInt(0,listOfComplaints.size()));
        AbstractTitle title = listOfTitles.get(ThreadLocalRandom.current().nextInt(0,listOfTitles.size()));
        return new ComplaintContainer(title.generateTitle(farmer.getName()),complaint.generateComplaint(square,date));
    }
}
