package main.java.com.epam.homework.domain;

import main.java.com.epam.homework.annotation.ThisCodeSmells;

public class Blimp extends AirTransport {

    @ThisCodeSmells(reviewer = "Malta")
    @ThisCodeSmells(reviewer = "Hopkins")
    private Float airVolume;

    public Blimp(int carrying, int peopleCapacity, String name, Float maxSpeed, Float airVolume) {
        super(carrying, peopleCapacity, name, maxSpeed);
        this.airVolume = airVolume;
    }

    public Float getAirVolume() {
        return airVolume;
    }

    public void setAirVolume(Float airVolume) {
        this.airVolume = airVolume;
    }
}
