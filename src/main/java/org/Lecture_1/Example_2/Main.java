package org.Lecture_1.Example_2;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        AtomicInteger counter = new AtomicInteger(0);
        int fibonacci = fibonacci(10, counter);
        System.out.println("Fibonacci number: " + fibonacci);
        System.out.println("Counter: " + counter.get());

        fibonacci = fibonacci(11, counter);
        System.out.println("Fibonacci number: " + fibonacci);
        System.out.println("Counter: " + counter.get());

        fibonacci = fibonacci(12, counter);
        System.out.println("Fibonacci number: " + fibonacci);
        System.out.println("Counter: " + counter.get());

        fibonacci = fibonacci(13, counter);
        System.out.println("Fibonacci number: " + fibonacci);
        System.out.println("Counter: " + counter.get());
    }

    public static int fibonacci(int position, AtomicInteger counter) {
        counter.incrementAndGet();
        if (position == 1) {
            return 0;
        }
        if (position == 2) {
            return 1;
        }
        return fibonacci(position - 1, counter) + fibonacci(position - 2, counter);
    }
}
