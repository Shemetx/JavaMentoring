package main.java.com.epam.homework.domain;

public class Glider extends AirTransport {
    private Float wingspan;

    public Glider(int carrying, int peopleCapacity, String name, Float maxSpeed,Float wingspan) {
        super(carrying, peopleCapacity, name, maxSpeed);
        this.wingspan = wingspan;
    }

    public Float getWingspan() {
        return wingspan;
    }

    public void setWingspan(Float wingspan) {
        this.wingspan = wingspan;
    }
}
