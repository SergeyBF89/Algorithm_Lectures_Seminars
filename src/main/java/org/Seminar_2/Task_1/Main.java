package org.Seminar_2.Task_1;

import java.util.Random;

// Сортировка выбором
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        randomizeArray(array);
        print(array);
        selectionSort(array);
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

    public static void selectionSort(int[] array) {
        for (int left = 0; left < array.length - 1; left++) {
            int minIndexElement = left;
            for (int i = left; i < array.length; i++) {
                if (array[i] < array[minIndexElement]) {
                    minIndexElement = i;
                }
            }
            if(left != minIndexElement) {
                int temp = array[left];
                array[left] = array[minIndexElement];
                array[minIndexElement] = temp;
            }
        }
    }
}
