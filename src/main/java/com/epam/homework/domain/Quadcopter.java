package main.java.com.epam.homework.domain;

public class Quadcopter extends AirTransport{
    private Integer controlRange;

    public Quadcopter(Integer carrying, Integer peopleCapacity, String name, Float maxSpeed, Integer controlRange) {
        super(carrying, peopleCapacity, name, maxSpeed);
        this.controlRange = controlRange;
    }

    public Integer getControlRange() {
        return controlRange;
    }

    public void setControlRange(Integer controlRange) {
        this.controlRange = controlRange;
    }
}
