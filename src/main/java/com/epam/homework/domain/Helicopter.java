package main.java.com.epam.homework.domain;

public class Helicopter extends AirTransport{
    private Integer numberOfScrews;

    public Helicopter(Integer carrying, Integer peopleCapacity, String name, Float maxSpeed, Integer numberOfScrews) {
        super(carrying, peopleCapacity, name, maxSpeed);
        this.numberOfScrews = numberOfScrews;
    }

    public Integer getNumberOfScrews() {
        return numberOfScrews;
    }

    public void setNumberOfScrews(Integer numberOfScrews) {
        this.numberOfScrews = numberOfScrews;
    }

}
