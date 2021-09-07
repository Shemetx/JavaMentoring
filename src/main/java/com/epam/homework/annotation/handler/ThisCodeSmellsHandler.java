package main.java.com.epam.homework.annotation.handler;

import main.java.com.epam.homework.annotation.Cacheable;
import main.java.com.epam.homework.annotation.ProdCode;
import main.java.com.epam.homework.annotation.ThisCodeSmellsArray;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

@Cacheable
public class ThisCodeSmellsHandler {

    public void inspectCodeOnSmell(Class<?> clazz) {
        inspectMethodsSmell(clazz);
        inspectFieldsSmell(clazz);
        inspectClassSmell(clazz);
    }

    public void inspectMethodsSmell(Class<?> clazz) {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ThisCodeSmellsArray.class)) {
                System.out.println("=====================================");
                ThisCodeSmellsArray declaredAnnotation = method.getDeclaredAnnotation(ThisCodeSmellsArray.class);
                System.out.println("This method smells! Name: " + method.getName());
                System.out.println(declaredAnnotation.value().length + " peoples thinks that your code smells!");
                System.out.println("Smellers: ");
                Arrays.stream(declaredAnnotation.value()).forEach(x -> System.out.println(x.reviewer()));
                System.out.println("=====================================");

            }
        }
    }

    public void inspectFieldsSmell(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(ThisCodeSmellsArray.class)) {
                System.out.println("=====================================");
                ThisCodeSmellsArray declaredAnnotation = field.getDeclaredAnnotation(ThisCodeSmellsArray.class);
                System.out.println("This field smells! Name: " + field.getName());
                System.out.println(declaredAnnotation.value().length + " peoples thinks that your code smells!");
                System.out.println("Smellers: ");
                Arrays.stream(declaredAnnotation.value()).forEach(x -> System.out.println(x.reviewer()));
                System.out.println("=====================================");
            }
        }
    }

    public void inspectClassSmell(Class<?> clazz) {
        if (clazz.isAnnotationPresent(ThisCodeSmellsArray.class)) {
            System.out.println("=====================================");
            ThisCodeSmellsArray declaredAnnotation = clazz.getDeclaredAnnotation(ThisCodeSmellsArray.class);
            System.out.println("This class smells! Name: " + clazz.getName());
            System.out.println(declaredAnnotation.value().length + " peoples thinks that your code smells!");
            System.out.println("Smellers: ");
            Arrays.stream(declaredAnnotation.value()).forEach(x -> System.out.println(x.reviewer()));
            System.out.println("=====================================");
        }
    }

    @ProdCode
    public void prodCode() {
        System.out.println("ThisCodeSmellsHandler -> production code");
    }

}
