package ru.coursework.coursework.Services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;

@Service
public class DateService {
    private LocalDate date = LocalDate.of(1920, Month.APRIL,14);
    public synchronized String getDate(){
        return date.toString();
    }
    public synchronized void nextDay(){
        date = date.plusDays(1);
    }
}
