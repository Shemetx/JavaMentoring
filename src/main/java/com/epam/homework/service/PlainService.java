package main.java.com.epam.homework.service;

import main.java.com.epam.homework.criteria.Criteria;
import main.java.com.epam.homework.domain.Plain;
import main.java.com.epam.homework.exception.NotFoundException;

public interface PlainService {
    Plain findByCriteria(Criteria<? extends Plain> criteria) throws NotFoundException;
}
