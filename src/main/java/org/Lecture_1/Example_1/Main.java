package org.Lecture_1.Example_1;

import java.util.ArrayList;
import java.util.List;

// Допустимые делители для числа

public class Main {
    public static void main(String[] args) {
        List<Integer> availableDivider = findAvailableDivider(11);
        for (Integer integer : availableDivider) {
            System.out.println(integer);
        }

    }
    public static List<Integer> findAvailableDivider(int number){
        int counter = 0; // переменная для счетчика операций
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            counter++;
            if (number % i == 0) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }

    // Алгоритм допустимые простые числа на отрезке от 0 до n

    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0; // переменная для счетчика операций
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < max; i++) {
            boolean simple = true; // проверяет являться ли i простым числом
            for (int j = 2; j < i; j++) {
                counter++;
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }
}
