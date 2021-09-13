package com.epam.homework.service.impl;

import com.epam.homework.context.CompanyContext;
import com.epam.homework.domain.Position;
import com.epam.homework.exception.EntityAlreadyExists;
import com.epam.homework.exception.EntityNotFound;
import com.epam.homework.service.PositionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PositionServiceImpl implements PositionService {

    private final List<Position> positionList;
    private static final Logger logger = LogManager.getLogger(PositionServiceImpl.class);

    @Autowired
    public PositionServiceImpl(CompanyContext context) {
        this.positionList = context.getCompanyStructure();
    }

    @Override
    public Position create(Position position) {
        Optional<Position> optionalPosition = getByTitle(position.getPositionTitle());
        if (!optionalPosition.isPresent()) {
            positionList.add(position);
            logger.info(position + " was added");
        } else {
            String exception = "Position with title: " + position.getPositionTitle()
                    + " already exists";
            logger.info(exception);
            throw new EntityAlreadyExists(exception);
        }
        return position;
    }

    @Override
    public Optional<Position> getByTitle(String title) throws EntityNotFound {
        return positionList
                .stream()
                .filter(p -> p.getPositionTitle().equals(title))
                .findFirst();
    }

    @Override
    public List<Position> getAll() {
        return positionList;
    }

    @Override
    public Position update(Position position) {
        Optional<Position> optionalPosition = getByTitle(position.getPositionTitle());
        Position toUpdate;
        if (optionalPosition.isPresent()) {
            toUpdate = position;
        } else {
            String exception = "Position with title: "
                    + position.getPositionTitle() + " was not found";
            logger.info(exception);
            throw new EntityNotFound(exception);
        }
        return toUpdate;
    }

    @Override
    public void delete(Position position) {
        Optional<Position> optionalPosition = getByTitle(position.getPositionTitle());
        if (optionalPosition.isPresent()) {
            positionList.remove(optionalPosition.get());
        } else {
            String exception = "Position with title: "
                    + position.getPositionTitle() + " was not found";
            logger.info(exception);
            throw new EntityNotFound(exception);
        }
    }

}
