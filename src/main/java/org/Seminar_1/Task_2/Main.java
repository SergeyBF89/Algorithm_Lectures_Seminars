package org.Seminar_1.Task_2;

// Поиск чисел Фибоначчи
public class Main {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
        System.out.println(fibonacciRecursion(5));
        System.out.println(fibonacciRecursion2(5, 0, 1));
    }

    // Вариант 1 (цикл) сложность O(n)
    public static int fibonacci(int n) {
        if (n < 0) {
            return -1;
        }
        int left = 0;
        int right = 1;
        if (n == 1) {
            return 0;
        }
        for (int i = 2; i < n; i++) {
            right = left + right;
            left = right - left;
        }
        return right;
    }

    // Вариант 2 (рекурсия обратная)
    public static int fibonacciRecursion(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2 || n == 3) {
            return 1;
        }
        return fibonacciRecursion(n -1) + fibonacciRecursion(n - 2);
    }

    // Вариант 3 (рекурсия прямая) сложность O(n)
    public static int fibonacciRecursion2(int n, int left, int right) {
        if (n < 0) {
            return -1;
        }
        if (n == 1) {
            return 0;
        }
        if (n <= 2) {
            return right;
        }
        return fibonacciRecursion2(n - 1, right, left + right);
    }
}
