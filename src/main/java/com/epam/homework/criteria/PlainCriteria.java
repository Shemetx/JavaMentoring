package main.java.com.epam.homework.criteria;

import main.java.com.epam.homework.domain.Plain;

public class PlainCriteria extends Criteria<Plain> {

    private Integer numberOfEngines;

    public PlainCriteria(Integer carrying, Integer peopleCapacity, String name, Float maxSpeed, Integer numberOfEngines) {
        super(carrying, peopleCapacity, name, maxSpeed);
        this.numberOfEngines = numberOfEngines;
    }

    public Integer getNumberOfEngines() {
        return numberOfEngines;
    }

    public void setNumberOfEngines(Integer numberOfEngines) {
        this.numberOfEngines = numberOfEngines;
    }

    public static class PlainBuilder extends Criteria.Builder {
        private Integer numberOfEngines;

        public void numberOfEngines(Integer numberOfEngines) {
            this.numberOfEngines = numberOfEngines;
        }

        @Override
        public Criteria build() {
            return new PlainCriteria(carrying, peopleCapacity, name, maxSpeed, numberOfEngines);
        }
    }
}
