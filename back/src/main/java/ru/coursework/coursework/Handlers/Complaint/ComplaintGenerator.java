package ru.coursework.coursework.Handlers.Complaint;

import org.apache.tomcat.util.bcel.Const;
import org.springframework.stereotype.Service;
import ru.coursework.coursework.Entity.Complaint;
import ru.coursework.coursework.Entity.Farmer;
import ru.coursework.coursework.Handlers.Constants;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class ComplaintGenerator {
    private final List<AbstractComplaint> listOfComplaints = new ArrayList<>();
    private final List<AbstractTitle> listOfTitles = new ArrayList<>();

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
            stream.forEach(x->listOfTitles.add(new AbstractTitleImpl(x)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public List<ComplaintContainer> generateComplaint(List<Farmer> farmers, String date, int amount){
        //This implementation may be slow:
        //int[] range = ThreadLocalRandom.current().ints(0,listOfComplaints.size()).distinct().limit(amount).toArray();

        //This implementation will be faster
        List<Integer> range = IntStream.range(0,listOfComplaints.size()).boxed()
                        .collect(Collectors.toCollection(ArrayList::new));
        Collections.shuffle(range);
        List<AbstractComplaint> complaints = range.stream().limit(amount)
                .map(listOfComplaints::get).collect(Collectors.toList());
        List<AbstractTitle> titles = ThreadLocalRandom.current().ints(0,listOfTitles.size())
                        .limit(amount).mapToObj(listOfTitles::get).collect(Collectors.toList());
        int[] squares = ThreadLocalRandom.current().ints(0,Constants.AMOUT_OF_SQUARES+1)
                .limit(amount).toArray();
        int amountOfFarmers = farmers.size();
        return IntStream.range(0,complaints.size())
                .boxed()
                .collect(ArrayList::new,(x,i)-> x.add(new ComplaintContainer(
                        titles.get(i).generateTitle(farmers.get(i%amountOfFarmers).getName()),
                        complaints.get(i).generateComplaint(squares[i],date))),ArrayList::addAll);
    }
}
