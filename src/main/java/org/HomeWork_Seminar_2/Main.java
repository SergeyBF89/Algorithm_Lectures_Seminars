package org.HomeWork_Seminar_2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] array = new int[10];
        randomizeArray(array);
        print(array);
        heapSort(array);
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

    public static void heapSort(int[] array) {
        int length = array.length;
        for (int i = length / 2 - 1; i >= 0; i--) {
            heapify(array, i, length);
        }
        for (int i = length - 1; i >= 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapify(array, 0, i);
        }
    }

    public static void heapify(int[] array, int index, int sizeHeap) {
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        if (left < sizeHeap && array[left] > array[largest]) {
            largest = left;
        }
        if (right < sizeHeap && array[right] > array[largest]) {
            largest = right;
        }
        if (index != largest) {
            int temp = array[index];
            array[index] = array[largest];
            array[largest] = temp;
            heapify(array, largest, sizeHeap);
        }

    }
}
