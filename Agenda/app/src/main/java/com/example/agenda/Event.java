package com.example.agenda;
import android.os.Build;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
public class Event implements Serializable {
    private String date;
    private String description;

    public Event(String date, String description) {
        this.date = date;
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public LocalDate getLocalDate(){
        DateTimeFormatter formatter = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return LocalDate.parse(date, formatter);
        }
        return null;
    }
    public String getDescription() {
        return description;
    }

    public String toString(){ return getDate() +"\n" +getDescription(); }

}
