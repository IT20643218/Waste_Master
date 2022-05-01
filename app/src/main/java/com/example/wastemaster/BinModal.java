package com.example.wastemaster;

public class BinModal {

    private int id;
    private String city,lord_type,cleaning_period,location;
    private long started, finished;

    //Empty constructor
    public BinModal(){

    }

    //constructor with parameters and id
    public BinModal(int id, String city, String lord_type,String location,String cleaning_period, long started, long finished) {
        this.id = id;
        this.city = city;
        this.lord_type = lord_type;
        this.location = location;
        this.cleaning_period = cleaning_period;
        this.started = started;
        this.finished = finished;
    }

    //constructor with parameters
    public BinModal(String city, String lord_type,String location,String cleaning_period, long started, long finished) {
        this.city = city;
        this.lord_type = lord_type;
        this.location = location;
        this.cleaning_period = cleaning_period;
        this.started = started;
        this.finished = finished;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLord_type() {
        return lord_type;
    }

    public void setLord_type(String lord_type) {
        this.lord_type = lord_type;
    }

    public String getCleaning_period() {
        return cleaning_period;
    }
    public void setCleaning_period (String cleaning_period) {
        this.cleaning_period=cleaning_period;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String Location) {
        this.location = location;
    }

    public long getStarted() {
        return started;
    }

    public void setStarted(long started) {
        this.started = started;
    }


    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}



