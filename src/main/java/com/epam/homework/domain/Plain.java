package main.java.com.epam.homework.domain;

public class Plain extends AirTransport {

    private Integer numberOfEngines;

    public Plain(Integer carrying, Integer peopleCapacity, String name, Float maxSpeed, Integer numberOfEngines) {
        super(carrying, peopleCapacity, name, maxSpeed);
        this.numberOfEngines = numberOfEngines;
    }


    public Integer getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(Integer numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    @Override
    public String toString() {
        return " Plain{" +
                "numberOfEngines=" + numberOfEngines +
                ", .carrying=" + super.getCarrying() +
                ", peopleCapacity=" + super.getPeopleCapacity() +
                ", name=" + super.getName() +
                ", maxSpeed=" + super.getMaxSpeed() +
                '}';
    }
}
