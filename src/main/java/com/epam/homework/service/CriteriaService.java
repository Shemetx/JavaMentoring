package main.java.com.epam.homework.service;

import main.java.com.epam.homework.criteria.Criteria;
import main.java.com.epam.homework.domain.AirTransport;

public interface CriteriaService<T extends AirTransport> {
    Criteria<T> createCriteria();
    void printAvailableOptions();
}
