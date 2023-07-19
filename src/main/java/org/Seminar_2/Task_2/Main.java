package org.Seminar_2.Task_2;

import java.util.Random;

// Сортировка вставками
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        randomizeArray(array);
        print(array);
        insertionSort(array);
        print(array);
    }

    public static void randomizeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(10);
        }
    }

    public static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    public static void insertionSort(int[] array) {
        for (int right = 1; right < array.length; right++) {
            int value = array[right];
            int i = right - 1;
            while (i >= 0) {
                if (value < array[i]) {
                    array[i + 1] = array[i];
                }else {
                    break;
                }
                i--;
            }
            array[i + 1] = value;
        }
    }
}
