package com.epam.homework.task4;

public class Cat implements Animal{

    @Override
    public void play() {
        System.out.println("Play with mouse");
    }

    @Override
    public void voice() {
        System.out.println("Meow");
    }
}
