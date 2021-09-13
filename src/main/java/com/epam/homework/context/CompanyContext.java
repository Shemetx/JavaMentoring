package com.epam.homework.context;

import com.epam.homework.domain.Position;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class CompanyContext {

    private final List<Position> companyStructure = new ArrayList<>();

    public List<Position> getCompanyStructure() {
        return companyStructure;
    }

    public void init() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        Position developer = (Position) applicationContext.getBean("developerPos");
        Position productManagerPos = (Position) applicationContext.getBean("productManagerPos");
        Position teamLeadPos = (Position) applicationContext.getBean("teamLeadPos");
        Position assistantPos = (Position) applicationContext.getBean("assistantPos");
        Position architectPos = (Position) applicationContext.getBean("architectPos");
        Position testerPos = (Position) applicationContext.getBean("testerPos");

        companyStructure.add(developer);
        companyStructure.add(productManagerPos);
        companyStructure.add(teamLeadPos);
        companyStructure.add(assistantPos);
        companyStructure.add(architectPos);
        companyStructure.add(testerPos);
    }

}
