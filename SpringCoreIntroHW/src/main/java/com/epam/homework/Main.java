package com.epam.homework;

import com.epam.homework.exception.EntityNotFound;
import com.epam.homework.service.PositionService;
import com.epam.homework.service.impl.PositionServiceImpl;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {

    public static void main(String[] args) throws EntityNotFound {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        PositionService positionService = applicationContext.getBean(PositionServiceImpl.class);
        positionService.getAll().forEach(System.out::println);
    }
}
