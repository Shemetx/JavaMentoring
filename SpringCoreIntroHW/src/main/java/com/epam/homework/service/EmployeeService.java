package com.epam.homework.service;

import com.epam.homework.domain.Employee;
import com.epam.homework.domain.Position;

public interface EmployeeService {
    Employee hireEmployee(Employee employee, Position position);
    Employee fireEmployee(Employee employee, Position position);
}
