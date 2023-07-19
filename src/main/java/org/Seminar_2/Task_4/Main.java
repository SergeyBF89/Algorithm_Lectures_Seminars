package org.Seminar_2.Task_4;

import java.util.Random;

// Бинарный поиск
public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        randomizeArray(array);
        print(array);
        quickSort(array);
        print(array);
        System.out.println(binarySearch(array, 5));
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

    public static int binarySearch(int[] array, int key) {
        return binarySearch(array, key, 0, array.length - 1);
    }

    public static int binarySearch(int[] array, int key, int left, int right) {
        if(left > right) {
            return -1;
        }
        int midpoint = (left + right) / 2;
        if (array[midpoint] < key) {
            return binarySearch(array, key, midpoint + 1, right);
        } else if (array[midpoint] > key) {
            return binarySearch(array, key, left, midpoint - 1);
        }else {
            return midpoint;
        }
    }

   public static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
   }

   public static void quickSort(int[] array, int leftBorder, int rightBorder) {
        int leftMarket = leftBorder;
        int rightMarket = rightBorder;
        int pivot = array[(leftBorder + rightBorder) / 2];
        while (leftMarket <= rightMarket) {
            while (array[leftMarket] < pivot) {
                leftMarket++;
            }
            while (array[rightMarket] > pivot) {
                rightMarket--;
            }
            if (leftMarket <= rightMarket) {
                if (leftMarket < rightMarket) {
                    int temp = array[leftMarket];
                    array[leftMarket] = array[rightMarket];
                    array[rightMarket] = temp;
                }
                leftMarket++;
                rightMarket--;
            }
        }
        if (leftMarket < rightBorder) {
            quickSort(array, leftMarket, rightBorder);
        }
        if (leftBorder < leftMarket) {
            quickSort(array, leftBorder, rightMarket);
        }
    }
}
