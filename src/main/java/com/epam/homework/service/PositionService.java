package com.epam.homework.service;

import com.epam.homework.domain.Position;
import com.epam.homework.exception.EntityNotFound;

import java.util.List;
import java.util.Optional;

public interface PositionService {
    Position create(Position position);
    Optional<Position> getByTitle(String title) throws EntityNotFound;
    List<Position> getAll();
    Position update(Position position);
    void delete(Position position);
}
