package ru.coursework.coursework.DTO.response;

import ru.coursework.coursework.Entity.Complaint;
import ru.coursework.coursework.Entity.Soldier;
import ru.coursework.coursework.Handlers.Complaint.ComplaintContainer;
import ru.coursework.coursework.Handlers.Constants;

import java.util.Arrays;
import java.util.Objects;

public class DataResponse {
  private String date;
  private ComplaintContainer[] complaints = new ComplaintContainer[Constants.AMOUNT_OF_COMPLAINTS];

  public String getDate() {
    return date;
  }

  public DataResponse setDate(String date) {
    this.date = date;
    return this;
  }

  public ComplaintContainer[] getComplaints() {
    return complaints;
  }

  public DataResponse setComplaints(ComplaintContainer[] complaints) {
    this.complaints = complaints;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    DataResponse that = (DataResponse) o;
    return Objects.equals(date, that.date) && Arrays.equals(complaints, that.complaints);
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(date);
    result = 31 * result + Arrays.hashCode(complaints);
    return result;
  }

  @Override
  public String toString() {
    return "DataResponse{" +
            "date='" + date + '\'' +
            ", complaints=" + Arrays.toString(complaints) +
            '}';
  }
}
