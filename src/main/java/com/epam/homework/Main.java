package com.epam.homework;

import com.epam.homework.context.CompanyContext;
import com.epam.homework.exception.EntityNotFound;
import com.epam.homework.service.PositionService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) throws EntityNotFound {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Beans.xml");
        CompanyContext context = (CompanyContext) applicationContext.getBean("companyContext");
        PositionService positionService = (PositionService) applicationContext.getBean("positionService");
        context.init();

        positionService.getAll().forEach(System.out::println);


    }
}
