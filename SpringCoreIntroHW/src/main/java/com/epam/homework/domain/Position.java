package com.epam.homework.domain;

import javax.validation.constraints.*;
import java.util.List;

public class Position {


    @NotNull(message = "Position title is compulsory")
    @Pattern(regexp = "[a-z-A-Z]*", message = "Position title has invalid characters")
    private String positionTitle;

    @NotNull(message = "Salary is compulsory")
    private Salary salary;

    @NotNull(message = "Number of available positions is compulsory")
    @Min(value = 0,message = "Minimal number of positions is 0")
    @Max(value = 256,message = "Maximum number of positions is 256")
    private Integer numOfAvailable;

    private List<Employee> employee;

    public Position() {
    }

    public Position(String positionTitle, Salary salary, Integer numOfAvailable, List<Employee> employee) {
        this.positionTitle = positionTitle;
        this.salary = salary;
        this.numOfAvailable = numOfAvailable;
        this.employee = employee;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Integer getNumOfAvailable() {
        return numOfAvailable;
    }

    public void setNumOfAvailable(Integer numOfAvailable) {
        this.numOfAvailable = numOfAvailable;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Position{" +
                "positionTitle='" + positionTitle + '\'' +
                ", salary=" + salary.getSalary()+
                ", numOfAvailable=" + numOfAvailable +
                ", employee=" + employee +
                '}';
    }
}
