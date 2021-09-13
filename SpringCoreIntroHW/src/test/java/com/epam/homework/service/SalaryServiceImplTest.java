package com.epam.homework.service;

import com.epam.homework.Main;
import com.epam.homework.domain.Salary;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Main.class,loader = AnnotationConfigContextLoader.class)
public class SalaryServiceImplTest {


    @Autowired
    private SalaryService salaryService;

    @Test
    public void getByCurrencyTest() {
        Salary salary = new Salary(BigDecimal.valueOf(100));
        BigDecimal byCurrency = salaryService.getByCurrency(salary);
        assertNotEquals(BigDecimal.valueOf(100),byCurrency);

    }

}
