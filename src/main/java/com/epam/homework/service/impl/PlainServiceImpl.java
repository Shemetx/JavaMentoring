package main.java.com.epam.homework.service.impl;

import main.java.com.epam.homework.annotation.Cacheable;
import main.java.com.epam.homework.annotation.ProdCode;
import main.java.com.epam.homework.context.AirCompanyContext;
import main.java.com.epam.homework.criteria.Criteria;
import main.java.com.epam.homework.criteria.PlainCriteria;
import main.java.com.epam.homework.domain.Plain;
import main.java.com.epam.homework.exception.NotFoundException;
import main.java.com.epam.homework.service.PlainService;

import java.util.List;

@Cacheable
public class PlainServiceImpl implements PlainService {

    private final static PlainService INSTANCE = new PlainServiceImpl();

    public static PlainService getInstance() {
        return INSTANCE;
    }

    private AirCompanyContext context = AirCompanyContext.getINSTANCE();
    private List<Plain> plainList = context.retrieveAirTransportList(Plain.class);

    @Override
    public Plain findByCriteria(Criteria<? extends Plain> criteria) throws NotFoundException {
        PlainCriteria plainCriteria = ((PlainCriteria) criteria);
        return plainList
                .stream()
                .filter(plain -> {
                    Integer carrying = plainCriteria.getCarrying();
                    if (carrying != null) {
                        return plain.getCarrying().equals(carrying);
                    }
                    return true;
                })
                .filter(plain -> {
                    Integer peopleCapacity = plainCriteria.getPeopleCapacity();
                    if (peopleCapacity != null) {
                        return plain.getPeopleCapacity().equals(peopleCapacity);
                    }
                    return true;
                })
                .filter(plain -> {
                    Float maxSpeed = plainCriteria.getMaxSpeed();
                    if (maxSpeed != null) {
                        return plain.getMaxSpeed().equals(maxSpeed);
                    }
                    return true;
                })
                .filter(plain -> {
                    String name = plainCriteria.getName();
                    if (name != null) {
                        return plain.getName().equals(name);
                    }
                    return true;
                })
                .filter(plain -> {
                    Integer numberOfEngines = plainCriteria.getNumberOfEngines();
                    if (numberOfEngines != null) {
                        return plain.getNumberOfEngines().equals(numberOfEngines);
                    }
                    return true;
                })
                .findFirst()
                .orElseThrow(() -> new NotFoundException("Plain not found"));
    }

    @ProdCode
    public void prodCode() {
        System.out.println("PlainServiceImpl -> production code");
    }
}
