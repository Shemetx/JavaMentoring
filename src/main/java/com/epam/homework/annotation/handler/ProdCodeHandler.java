package main.java.com.epam.homework.annotation.handler;

import main.java.com.epam.homework.annotation.Cacheable;
import main.java.com.epam.homework.annotation.ProdCode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@Cacheable
public class ProdCodeHandler {

    public void inspectService(Class<?> clazz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, InstantiationException {
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ProdCode.class)) {
                Object serviceObj = clazz.getDeclaredConstructor().newInstance();
                method.invoke(serviceObj);
            }
        }
    }
}
