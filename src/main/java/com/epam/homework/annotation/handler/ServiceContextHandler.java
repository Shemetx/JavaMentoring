package main.java.com.epam.homework.annotation.handler;

import main.java.com.epam.homework.annotation.Cacheable;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ServiceContextHandler {

    private static Map<String, Object> serviceMap = new HashMap<>();

    public static Object getClassByName(String name) {
        return serviceMap.get(name);
    }

    public static void loadService(String className) {
        Class<?> clazz = null;
        try {
            clazz = Class.forName(className);
            if (clazz.isAnnotationPresent(Cacheable.class)) {
                Object serviceObj = clazz.getDeclaredConstructor().newInstance();
                serviceMap.put(clazz.getSimpleName(), serviceObj);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException |
                InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

}
