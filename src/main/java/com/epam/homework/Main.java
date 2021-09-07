package main.java.com.epam.homework;

import main.java.com.epam.homework.annotation.handler.ProdCodeHandler;
import main.java.com.epam.homework.annotation.handler.ServiceContextHandler;
import main.java.com.epam.homework.annotation.handler.ThisCodeSmellsHandler;
import main.java.com.epam.homework.criteria.Criteria;
import main.java.com.epam.homework.domain.Plain;
import main.java.com.epam.homework.exception.NotFoundException;
import main.java.com.epam.homework.service.AirTransportService;
import main.java.com.epam.homework.service.CriteriaService;
import main.java.com.epam.homework.service.PlainService;
import main.java.com.epam.homework.util.AccessingAllClassesInPackage;
import main.java.com.epam.homework.util.ClassMetaInfoUtil;
import main.java.com.epam.homework.util.ReflectionUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

public class Main {

    public static void main(String[] args) {

        System.out.println("=====================FIRST PART=================================");

        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.service.impl.AirTransportServiceImpl");
        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.service.impl.PlainCriteriaServiceImpl");
        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.service.impl.PlainServiceImpl");
        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.util.AccessingAllClassesInPackage");
        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.annotation.handler.ProdCodeHandler");
        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.annotation.handler.ThisCodeSmellsHandler");
        ServiceContextHandler.loadService("main.java.com.epam" +
                ".homework.annotation.handler.ProdCodeHandler");

        AccessingAllClassesInPackage scan = (AccessingAllClassesInPackage)
                ServiceContextHandler.getClassByName("AccessingAllClassesInPackage");
        ThisCodeSmellsHandler smellsHandler = (ThisCodeSmellsHandler)
                ServiceContextHandler.getClassByName("ThisCodeSmellsHandler");
        ProdCodeHandler prodCodeHandler = (ProdCodeHandler)
                ServiceContextHandler.getClassByName("ProdCodeHandler");

        Set<Class> homework = (Set<Class>) ReflectionUtil.invokeMethod(scan, "findAllClasses");
        for (Class clazz : homework) {
            try {
                prodCodeHandler.inspectService(clazz);
            } catch (InvocationTargetException | IllegalAccessException | NoSuchMethodException | InstantiationException e) {
                e.printStackTrace();
            }
            ClassMetaInfoUtil.getAllMethodsInfo(clazz);
            ClassMetaInfoUtil.getAllFieldsInfo(clazz);
            smellsHandler.inspectCodeOnSmell(clazz);
        }

        System.out.println("=====================SECOND PART=================================");

        AirTransportService service = (AirTransportService)
                ServiceContextHandler.getClassByName("AirTransportServiceImpl");
        Integer integer = (Integer) ReflectionUtil.invokeMethod(service, "calcGeneralCarrying");
        System.out.println(integer);
        Integer integer1 = (Integer) ReflectionUtil.invokeMethod(service, "calcGeneralPeopleCapacity");
        System.out.println(integer1);

        CriteriaService<Plain> criteria = (CriteriaService<Plain>) ServiceContextHandler.getClassByName("PlainCriteriaServiceImpl");
        Criteria<Plain> plainCriteria = (Criteria<Plain>) ReflectionUtil.invokeMethod(criteria, "createCriteria");
        PlainService plainService = (PlainService)
                ServiceContextHandler.getClassByName("PlainServiceImpl");
        try {
            Plain byCriteria = plainService.findByCriteria(plainCriteria);
            System.out.println(byCriteria);
        } catch (NotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

}
