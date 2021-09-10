package com.epam.homework;

import com.epam.homework.task4.CustomClassLoader;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    private static final List<String> pool = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
//        System.out.println("============TASK 1=================");
//        1. OutOfMemoryError: Java Heap
//        Map m = new HashMap();
//        while (true) {
//            for (int i = 0; i < 100000; i++)
//                if (!m.containsKey(new MapKey(i)))
//                    m.put(new MapKey(i), "Number:" + i);
//        }
//
//        2. - Xmx15m VM option OutOfMemoryError: Java heap
//        BigObject bigObject = new BigObject();
//        BigObject bigObject1 = new BigObject();
//
//        3. - XX:MaxMetaspaceSize = 10 m OutOfMemoryError:Metaspace
//        MetaSpaceLoader metaSpaceLoader = new MetaSpaceLoader();
//        metaSpaceLoader.generateError();
//
//        4. StackOverflow
//        recursionStackOverflow(1);
//
//        5. StackOverflow
//        Chain chain = new Chain();
//        chain.setHandlers(10000);
//        chain.process();
//
//        System.out.println("===================================");
//
        System.out.println("============TASK 4=================");
        CustomClassLoader classLoader = new CustomClassLoader(Main.class.getClassLoader());
        try {
            Class<?> catClass = classLoader.loadClass("com.epam.homework.task4.Cat");
            Class<?> dogClass = classLoader.loadClass("com.epam.homework.task4.Dog");
            Object catObj = catClass.getDeclaredConstructor().newInstance();
            Object dogObj = dogClass.getDeclaredConstructor().newInstance();

            catClass.getMethod("play").invoke(catObj);
            catClass.getMethod("voice").invoke(catObj);

            dogClass.getMethod("play").invoke(dogObj);
            dogClass.getMethod("voice").invoke(dogObj);

        } catch (ClassNotFoundException | NoSuchMethodException |
                InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        System.out.println("===================================");

        System.out.println("================TASK 5===================");

        int iteration = 0;
        while (true) {
            for (int i = 0; i < 100; i++) {
                for (int j = 0; j < 1000; j++) {
                    pool.add("String" + j);
                }
            }

            iteration++;
            System.out.println("Survived iterations: " + iteration);
            Thread.sleep(100);
        }
        //  System.out.println("===================================");
    }

    public static void recursionStackOverflow(int num) {
        if (num == 0) {
            return;
        } else {
            recursionStackOverflow(num++);
        }

    }
}
