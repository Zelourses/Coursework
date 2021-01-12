package ru.coursework.coursework.Handlers.Complaint;

public class AbstractTitleImpl implements AbstractTitle{
    String title;
    AbstractTitleImpl(String title){
        this.title = title;
    }
    @Override
    public String generateTitle(String name) {
        return String.format(title,name);
    }
}
