package main.java.com.epam.homework.util;

import main.java.com.epam.homework.annotation.ThisCodeSmells;

import java.util.Scanner;


@ThisCodeSmells(reviewer = "Kingston")
public class InputService {

    public static int enterInteger() {
        Scanner reader = new Scanner(System.in);

        while (!reader.hasNextInt()) {
            System.out.println("Wrong Input!");
            reader.next();
        }
        return reader.nextInt();
    }

    public static String enterString() {
        Scanner reader = new Scanner(System.in);
        return reader.nextLine();
    }

    public static Float enterFloat() {
        Scanner reader = new Scanner(System.in);

        while (!reader.hasNextFloat()) {
            System.out.println("Wrong Input!");
            reader.next();
        }
        return reader.nextFloat();
    }
}
