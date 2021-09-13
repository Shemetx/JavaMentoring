package com.epam.homework.service;

import com.epam.homework.Main;
import com.epam.homework.domain.Employee;
import com.epam.homework.domain.Position;
import com.epam.homework.domain.Salary;
import com.epam.homework.exception.EntityNotFound;
import com.epam.homework.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest {

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Mock
    private PositionService positionService;

    private final Position TEST_POSITION = new Position("Test", new Salary(new BigDecimal(250)), 1, new ArrayList<>());
    private final Employee TEST_EMPLOYEE = new Employee("Test","Test");

    @Test
    public void hirePositiveTest() {
        when(positionService.getByTitle(TEST_POSITION.getPositionTitle())).thenReturn(Optional.of(TEST_POSITION));
        employeeService.hireEmployee(TEST_EMPLOYEE,TEST_POSITION);
        assertEquals(1,TEST_POSITION.getEmployee().size());
    }

    @Test
    public void hireNegativeTest() {
        when(positionService.getByTitle(TEST_POSITION.getPositionTitle())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFound.class, ()-> {
            employeeService.hireEmployee(TEST_EMPLOYEE,TEST_POSITION);
        });
    }

    @Test
    public void firePositiveTest() {
        TEST_POSITION.getEmployee().add(TEST_EMPLOYEE);
        when(positionService.getByTitle(TEST_POSITION.getPositionTitle())).thenReturn(Optional.of(TEST_POSITION));
        employeeService.fireEmployee(TEST_EMPLOYEE,TEST_POSITION);
        assertEquals(0,TEST_POSITION.getEmployee().size());
    }

    @Test
    public void fireNegativeTest() {
        when(positionService.getByTitle(TEST_POSITION.getPositionTitle())).thenReturn(Optional.empty());
        Assertions.assertThrows(EntityNotFound.class, ()-> {
            employeeService.fireEmployee(TEST_EMPLOYEE,TEST_POSITION);
        });
    }
}
