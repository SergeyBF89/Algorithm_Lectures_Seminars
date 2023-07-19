package org.Seminar_2.Task_3;

import java.util.Random;

// Быстрая сортировка
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        randomizeArray(array);
        print(array);
        quickSort(array);
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

    public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftBorder + rightBorder) / 2]; // выбираем середину массива для якоря
        while (leftMarker <= rightMarker) {
            while (array[leftMarker] < pivot) {
                leftMarker++;
            }
            while (array[rightMarker] > pivot) {
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        }
        //рекурсивный запуск алгоритма сортировки
        if (leftMarker < rightBorder) {
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < leftMarker) {
            quickSort(array, leftBorder, rightMarker);
        }
    }
}
