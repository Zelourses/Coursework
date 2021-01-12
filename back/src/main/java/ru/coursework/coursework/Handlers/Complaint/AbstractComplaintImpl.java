package ru.coursework.coursework.Handlers.Complaint;

public class AbstractComplaintImpl implements AbstractComplaint{
    String message;
    boolean firstIsDate;
    public AbstractComplaintImpl(String message, boolean firstIsDate){
        this.message = message;
        this.firstIsDate=firstIsDate;
    }
    @Override
    public String generateComplaint(Integer square,String date) {
        return String.format(message,firstIsDate?date:square,firstIsDate?square:date);
    }
}
