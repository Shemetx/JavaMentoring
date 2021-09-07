package main.java.com.epam.homework.service.impl;

import main.java.com.epam.homework.annotation.Cacheable;
import main.java.com.epam.homework.criteria.Criteria;
import main.java.com.epam.homework.criteria.PlainCriteria;
import main.java.com.epam.homework.domain.Plain;
import main.java.com.epam.homework.service.CriteriaService;
import main.java.com.epam.homework.util.InputService;

@Cacheable
public class PlainCriteriaServiceImpl implements CriteriaService<Plain> {

    private final static PlainCriteriaServiceImpl INSTANCE = new PlainCriteriaServiceImpl();

    public static PlainCriteriaServiceImpl getInstance() {
        return INSTANCE;
    }

    @Override
    public Criteria<Plain> createCriteria() {
        Integer carrying = null;
        Integer peopleCapacity = null;
        String name = null;
        Float maxSpeed = null;
        Integer numberOfEngines = null;
        int choose = Integer.MAX_VALUE;
        while (choose != 0) {
            printAvailableOptions();
            System.out.println("Choose criteria: ");
            choose = InputService.enterInteger();
            switch (choose) {
                case 1:
                    System.out.println("Enter carrying: ");
                    carrying = InputService.enterInteger();
                    break;
                case 2:
                    System.out.println("Enter peopleCapacity: ");
                    peopleCapacity = InputService.enterInteger();
                    break;
                case 3:
                    System.out.println("Enter name: ");
                    name = InputService.enterString();
                    break;
                case 4:
                    System.out.println("Enter max speed: ");
                    maxSpeed = InputService.enterFloat();
                    break;
                case 5:
                    System.out.println("Enter number of engines: ");
                    numberOfEngines = InputService.enterInteger();
                    break;
                default:
                    break;
            }
        }
        Integer finalCarrying = carrying;
        Integer finalPeopleCapacity = peopleCapacity;
        String finalName = name;
        Float finalMaxSpeed = maxSpeed;
        Integer finalNumberOfEngines = numberOfEngines;
        return new PlainCriteria.PlainBuilder() {{
            carrying(finalCarrying);
            peopleCapacity(finalPeopleCapacity);
            name(finalName);
            maxSpeed(finalMaxSpeed);
            numberOfEngines(finalNumberOfEngines);
        }}.build();
    }

    @Override
    public void printAvailableOptions() {
        System.out.println("Choose which criteria you want: ");
        System.out.println("1 - Carrying");
        System.out.println("2 - People capacity");
        System.out.println("3 - Name");
        System.out.println("4 - Max speed");
        System.out.println("5 - Number of Engines");
        System.out.println("0 - Stop to choose");
    }
}
