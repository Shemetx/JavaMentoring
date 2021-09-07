package main.java.com.epam.homework.domain;

import java.util.Objects;

public class AirTransport {

    private Integer carrying;
    private Integer peopleCapacity;
    private String name;
    private Float maxSpeed;

    public AirTransport() {
    }

    public AirTransport(Integer carrying, Integer peopleCapacity, String name, Float maxSpeed) {
        this.carrying = carrying;
        this.peopleCapacity = peopleCapacity;
        this.name = name;
        this.maxSpeed = maxSpeed;
    }

    public Integer getCarrying() {
        return carrying;
    }

    public void setCarrying(Integer carrying) {
        this.carrying = carrying;
    }

    public Integer getPeopleCapacity() {
        return peopleCapacity;
    }

    public void setPeopleCapacity(Integer peopleCapacity) {
        this.peopleCapacity = peopleCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Float maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "AirTransport{" +
                "carrying=" + carrying +
                ", peopleCapacity=" + peopleCapacity +
                ", name='" + name + '\'' +
                ", maxSpeed=" + maxSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirTransport that = (AirTransport) o;
        return Objects.equals(carrying, that.carrying) && Objects.equals(peopleCapacity, that.peopleCapacity) && Objects.equals(name, that.name) && Objects.equals(maxSpeed, that.maxSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carrying, peopleCapacity, name, maxSpeed);
    }
}
