package main.java.com.epam.homework.criteria;

import main.java.com.epam.homework.domain.AirTransport;

public abstract class Criteria<T extends AirTransport> {
    private Integer carrying;
    private Integer peopleCapacity;
    private String name;
    private Float maxSpeed;

    public Criteria(Integer carrying, Integer peopleCapacity, String name, Float maxSpeed) {
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

    public static abstract class Builder {
        Integer carrying;
        Integer peopleCapacity;
        String name;
        Float maxSpeed;

        public Builder() {
        }

        public void carrying(Integer carrying) {
            this.carrying = carrying;
        }

        public void peopleCapacity(Integer peopleCapacity) {
            this.peopleCapacity = peopleCapacity;
        }

        public void name(String name) {
            this.name = name;
        }

        public void maxSpeed(Float maxSpeed) {
            this.maxSpeed = maxSpeed;
        }

        public abstract Criteria build();
    }
}
