package main.java.com.epam.homework;

import java.util.Arrays;

public class DynamicDoubleArray<T> {

    private T[] array;
    private int actualCapacity = -1;

    public DynamicDoubleArray() {
        this.array = (T[]) new Object[5];
    }

    public DynamicDoubleArray(int initialCapacity) {
        if (initialCapacity > 0 && initialCapacity < Integer.MAX_VALUE) {
            this.array =(T[]) new Object[initialCapacity];
        } else {
            throw new IllegalArgumentException("Wrong capacity " + initialCapacity);
        }
    }

    public void add(T element) {
        actualCapacity++;
        if (actualCapacity == array.length) {
            grow();
        }
        array[actualCapacity] = element;
    }
    public T get(int index) {
        if (index > 0 && index < array.length - 1) {
            return array[index];
        }
        throw new ArrayIndexOutOfBoundsException("Index out of array " + index);
    }

    public void remove(int index) {
        if (index > 0 && index < array.length - 1) {
            array[index] = null;
            trim(index);
        } else {
            throw new ArrayIndexOutOfBoundsException("Index out of array " + index);
        }
    }
    public String toString() {
        return Arrays.toString(array);
    }

    private void grow() {
        array = Arrays.copyOf(array, array.length * 2);
    }

    private void trim(int index) {
        for(;index < array.length - 1; index++) {
            array[index] = array[index+1];
        }
    }
}
