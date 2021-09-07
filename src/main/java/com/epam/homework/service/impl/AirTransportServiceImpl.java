package main.java.com.epam.homework.service.impl;

import main.java.com.epam.homework.annotation.Cacheable;
import main.java.com.epam.homework.annotation.ThisCodeSmells;
import main.java.com.epam.homework.context.AirCompanyContext;
import main.java.com.epam.homework.domain.AirTransport;
import main.java.com.epam.homework.service.AirTransportService;

import java.util.List;

@Cacheable
public class AirTransportServiceImpl implements AirTransportService {

    private final static AirTransportServiceImpl INSTANCE = new AirTransportServiceImpl();

    public static AirTransportServiceImpl getInstance() {
        return INSTANCE;
    }

    private AirCompanyContext context = AirCompanyContext.getINSTANCE();
    private List<AirTransport> airTransports = context.retrieveAllAirTransport();

    @ThisCodeSmells(reviewer = "Steve")
    @ThisCodeSmells(reviewer = "John")
    @ThisCodeSmells(reviewer = "Robert")
    @Override
    public Integer calcGeneralPeopleCapacity() {
        return airTransports.stream().mapToInt(AirTransport::getPeopleCapacity).sum();
    }

    @Override
    public Integer calcGeneralCarrying() {
        return airTransports.stream().mapToInt(AirTransport::getCarrying).sum();
    }
}
