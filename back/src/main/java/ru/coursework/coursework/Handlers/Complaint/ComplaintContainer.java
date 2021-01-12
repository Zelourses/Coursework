package ru.coursework.coursework.Handlers.Complaint;

import java.util.Objects;

public class ComplaintContainer {
    private String title;
    private String complaint;

    public ComplaintContainer(String title,String complaint){
        this.title = title;
        this.complaint = complaint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplaintContainer that = (ComplaintContainer) o;
        return Objects.equals(title, that.title) && Objects.equals(complaint, that.complaint);
    }

    @Override
    public String toString() {
        return "ComplaintContainer{" +
                "title='" + title + '\'' +
                ", complaint=" + complaint +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, complaint);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComplaint() {
        return complaint;
    }

    public void setComplaint(String complaint) {
        this.complaint = complaint;
    }
}
