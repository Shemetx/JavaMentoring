package com.epam.homework.task4;

public class Dog implements Animal{

    @Override
    public void play() {
        System.out.println("Play with ball");
    }

    @Override
    public void voice() {
        System.out.println("Woof");
    }
}
