package com.epam.homework.service.impl;

import com.epam.homework.domain.Salary;
import com.epam.homework.service.SalaryService;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Random;

@Component
public class SalaryServiceImpl implements SalaryService {


    @Override
    public BigDecimal getByCurrency(Salary salary) {
        BigDecimal toConvert = salary.getSalary();
        Random random = new Random();
        float min = 2.3f;
        float max = 2.5f;

        return toConvert.multiply(BigDecimal.valueOf((min + random.nextDouble() * (max - min))));
    }

}

