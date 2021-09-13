package com.epam.homework.context;

import com.epam.homework.domain.Employee;
import com.epam.homework.domain.Position;
import com.epam.homework.domain.Salary;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class CompanyContext {

    private final List<Position> companyStructure = new ArrayList<>();

    private CompanyContext() {
        init();
    }

    public List<Position> getCompanyStructure() {
        return companyStructure;
    }

    private void init() {
        companyStructure.add(new Position("Developer",new Salary(new BigDecimal(250)),4,new ArrayList<Employee>() {{
            add( new Employee("Jim ","Halpert"));
            add(new Employee("Pam ", "Beesly"));
            add( new Employee("Dwight ","Schrute"));
        }}));
        companyStructure.add(new Position("Product Manager",new Salary(new BigDecimal(300)),1,new ArrayList<Employee>() {{
            add(new Employee("Erin ", "Hannon"));
        }}));
        companyStructure.add(new Position("Team Lead",new Salary(new BigDecimal(400)),1,new ArrayList<Employee>() {{
            add(new Employee("Michael ","Scott"));
        }}));
        companyStructure.add(new Position("Assistant",new Salary(new BigDecimal(200)),2,new ArrayList<Employee>() {{
            add(new Employee("Kevin ", "Malone"));
            add(new Employee("Toby ", "Flenderson"));
        }}));
        companyStructure.add(new Position("Architecture",new Salary(new BigDecimal(320)),2,new ArrayList<Employee>(){{
            add(new Employee("Robert ", "California"));
        }} ));
        companyStructure.add(new Position("Tester",new Salary(new BigDecimal(150)),3,new ArrayList<Employee>() {{
            add(new Employee("Kelly ", "Kapoor"));
        }}));


    }
}
