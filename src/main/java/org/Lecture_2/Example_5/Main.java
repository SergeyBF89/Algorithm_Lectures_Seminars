package org.Lecture_2.Example_5;

// Бинарный поиск O(log n)
public class Main {
    public static void main(String[] args) {
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(binarySearch(array, 5));
    }

    public static int binarySearch(int[] array, int value) {
        return binarySearch(array, value, 0, array.length - 1);
    }
    public static int binarySearch(int[] array, int value, int min, int max) {
        int midPoint;
        if(max < min) {
            return -1;
        }else {
            midPoint = (max - min) / 2 + min;
        }

        if (array[midPoint] < value) {
            return binarySearch(array, value, midPoint + 1, max);
        } else {
            if (array[midPoint] > value) {
                return binarySearch(array, value, min, midPoint - 1);
            } else {
                return midPoint;
            }
        }

    }
}
