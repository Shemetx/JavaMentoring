package main.java.com.epam.homework;

import main.java.com.epam.homework.domain.Person;

import java.util.function.BinaryOperator;
import java.util.function.Function;

@FunctionalInterface
public interface AdditionSkill {
    void addSkillLevel(Person person, Function<Integer, String> defineSkill, BinaryOperator<String> addSkill);

    default void showDefault() {
        System.out.println("Default Method Executed");
    }

    static void showStatic() {
        System.out.println("Static Method Executed");
    }
}
