package main.java.com.epam.homework;

public class Main {
    public static void main(String[] args) {
        DynamicDoubleArray<Integer> array = new DynamicDoubleArray<>(3);
        array.add(10);
        array.add(10);
        array.add(11);
        System.out.println(array);
        array.add(10);
        array.add(10);
        array.add(10);
        System.out.println(array);
        System.out.println(array.get(3));
        array.remove(3);
        System.out.println(array.get(3));
        System.out.println(array.get(20));

    }
}