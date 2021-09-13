package com.epam.homework.service.impl;

import com.epam.homework.domain.Employee;
import com.epam.homework.domain.Position;
import com.epam.homework.exception.EntityNotFound;
import com.epam.homework.exception.PositionAvailableException;
import com.epam.homework.service.EmployeeService;
import com.epam.homework.service.PositionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private final PositionService positionService;
    private static final Logger logger = LogManager.getLogger(EmployeeServiceImpl.class);

    @Autowired
    public EmployeeServiceImpl(PositionService positionService) {
        this.positionService = positionService;
    }

    @Override
    public Employee hireEmployee(Employee employee, Position position) {
        Optional<Position> byTitle = positionService.getByTitle(position.getPositionTitle());
        try {
            if (byTitle.isPresent()) {
                increaseNumOfAvailablePositions(position);
                Position toHire = byTitle.get();
                toHire.getEmployee().add(employee);
                logger.info("Employee: " + employee.getFirstName() + " " + employee.getSecondName()
                        + " was hired on position: " + position.getPositionTitle());
            } else {
                String exception = "Position with title: "
                        + position.getPositionTitle() + " was not found";
                logger.info(exception);
                throw new EntityNotFound(exception);
            }
        } catch (PositionAvailableException e) {
            logger.info(e.getMessage());
            System.out.println(e.getMessage());
        }

        return employee;
    }

    private void increaseNumOfAvailablePositions(Position position) throws PositionAvailableException {
        Integer numOfAvailable = position.getNumOfAvailable();
        if (numOfAvailable > 0) {
            position.setNumOfAvailable(numOfAvailable + 1);
        } else {
            String exception = "Position with title: " + position.getPositionTitle() +
                    " has no more available positions " + position.getNumOfAvailable();
            logger.info(exception);
            throw new PositionAvailableException(exception);
        }
    }

    @Override
    public Employee fireEmployee(Employee employee, Position position) {
        Optional<Position> byTitle = positionService.getByTitle(position.getPositionTitle());
        if (byTitle.isPresent()) {
            decreaseNumOfAvailablePositions(position);
            Position toHire = byTitle.get();
            toHire.getEmployee().remove(employee);
            logger.info("Employee: " + employee.getFirstName() + " " + employee.getSecondName()
                    + " was fired from position: " + position.getPositionTitle());
        } else {
            String exception = "Position with title: "
                    + position.getPositionTitle() + " was not found";
            logger.info(exception);
            throw new EntityNotFound("Position with title: "
                    + position.getPositionTitle() + " was not found");
        }

        return employee;
    }

    private void decreaseNumOfAvailablePositions(Position position) {
        Integer numOfAvailable = position.getNumOfAvailable();
        position.setNumOfAvailable(numOfAvailable - 1);
    }
}
