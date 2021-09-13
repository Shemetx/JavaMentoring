package com.epam.homework.domain;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class Salary {

    @NotNull(message = "Salary is compulsory")
    @DecimalMin(value = "0.0",message = "Minimal number of positions is 0")
    @DecimalMax(value = "65536.0",message = "Maximum number of positions is 65536")
    private BigDecimal salary;

    public Salary() {
    }

    public Salary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Salary{" +
                "salary=" + salary +
                '}';
    }
}
