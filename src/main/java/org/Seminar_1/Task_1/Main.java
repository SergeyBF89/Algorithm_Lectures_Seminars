package org.Seminar_1.Task_1;

import java.util.Random;

// Подсчет всех чисел от 1 до n
public class Main {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(sum(a));
        System.out.println(sum2(a));

        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(1000);
        }
        bubbleSort(array);
        for (var i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
        bubbleSort2(array);
        for (var i : array) {
            System.out.print(i + " ");
        }
    }

    // линейная сложность алгоритма O(n)
    public static int sum(int n) {
        int result = 0;
        for (int i = 1; i <= n; i++) {
            result += i;
        }
        return result;
    }

    // константная сложность алгоритма O(1)
    public static int sum2(int n) {
        return n * (n + 1) / 2;
    }

    // квадратичная сложность алгоритма O(n^2)
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // квадратичная сложность алгоритма O(n^2-n)
    public static void bubbleSort2(int[] array) {
        int length = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < length; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        length--;
    }
}
