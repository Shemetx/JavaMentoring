package com.epam.homework.service;

import com.epam.homework.Main;
import com.epam.homework.domain.Position;
import com.epam.homework.domain.Salary;
import com.epam.homework.exception.EntityAlreadyExists;
import com.epam.homework.exception.EntityNotFound;
import javafx.geometry.Pos;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Main.class, loader = AnnotationConfigContextLoader.class)
public class PositionServiceImplTest {

    @Autowired
    private PositionService positionService;

    private final Position TEST_POSITION = new Position("Test", new Salary(new BigDecimal(250)), 1, new ArrayList<>());


    @Test
    @Order(1)
    public void createPositiveTest() {
        Position created = positionService.create(TEST_POSITION);
        assertEquals(TEST_POSITION, created);
    }

    @Test
    @Order(2)
    public void createNegativeTest() {
        Assertions.assertThrows(EntityAlreadyExists.class, () -> positionService.create(TEST_POSITION));
    }

    @Test
    @Order(3)
    public void getByTitlePositiveTest() {
        Optional<Position> byTitle = positionService.getByTitle(TEST_POSITION.getPositionTitle());
        assertEquals(TEST_POSITION.getPositionTitle(), byTitle.get().getPositionTitle());
    }

    @Order(4)
    @Test
    public void getByTitleNegativeTest() {
        positionService.delete(TEST_POSITION);
        Optional<Position> byTitle = positionService.getByTitle(TEST_POSITION.getPositionTitle());
        assertFalse(byTitle.isPresent());
    }

    @Order(5)
    @Test
    public void deleteNegativeTest() {
        Assertions.assertThrows(EntityNotFound.class,
                () -> positionService.delete(TEST_POSITION));
    }

    @Order(6)
    @Test
    public void updatePositiveTest() {
        positionService.create(TEST_POSITION);
        Position toUpdate =  new Position("Test", new Salary(new BigDecimal(300)), 1, new ArrayList<>());
        Position update = positionService.update(toUpdate);
        assertEquals(BigDecimal.valueOf(300),update.getSalary().getSalary());
    }
}
