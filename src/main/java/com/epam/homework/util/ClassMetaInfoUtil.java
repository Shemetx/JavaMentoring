package main.java.com.epam.homework.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ClassMetaInfoUtil {

    public static void getAllMethodsInfo(Class<?> service) {
        Method[] methods = service.getDeclaredMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println( " Method |  " +
                    " Name: " + method.getName() +
             " Parameters: " + Arrays.toString(method.getParameterTypes())
            + " Annotations: " + Arrays.toString(method.getDeclaredAnnotations()));
        }
    }

    public static void getAllFieldsInfo(Class<?> service) {
        Field[] declaredFields = service.getDeclaredFields();
        for (Field field : declaredFields ) {
            field.setAccessible(true);
            System.out.println(" Field |  " +
                    " Name: " + field.getName() +
                    " Type: " + field.getType() +
                    " Annotations: " + Arrays.toString(field.getDeclaredAnnotations()));
        }
    }
}
