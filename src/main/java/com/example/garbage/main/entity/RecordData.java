package com.example.garbage.main.entity;

import java.util.Date;

public class RecordData {

    private Integer weight;

    private Date date;


    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Record{" +
                "weight=" + weight +
                ", date=" + date +
                '}';
    }
}
