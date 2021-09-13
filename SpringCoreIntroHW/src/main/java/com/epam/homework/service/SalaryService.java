package com.epam.homework.service;

import com.epam.homework.domain.Salary;

import java.math.BigDecimal;

public interface SalaryService {
    BigDecimal getByCurrency(Salary salary);
}
