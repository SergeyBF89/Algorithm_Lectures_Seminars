package org.Seminar_4;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
//        Pair[] array = new Pair[10];
//        Pair pair1 = new Pair("B", 5);
//        Pair pair2 = new Pair("F", 0);
//        Pair pair3 = new Pair("D", 9);
//        Pair pair4 = new Pair("J", 4);
//
//        array[pair1.key.hashCode() % array.length] = pair1;
//        array[pair2.key.hashCode() % array.length] = pair2;
//        array[pair3.key.hashCode() % array.length] = pair3;
//        array[pair4.key.hashCode() % array.length] = pair4;
//
//        for (int i = 0; i < array.length; i++) {
//            if (array[i] != null) {
//                System.out.print("[" + array[i].key + ";" + array[i].value + "] ");
//            } else {
//                System.out.print("- ");
//            }
//        }
//        System.out.println();
//        if (array["J".hashCode() % array.length].value > 5) {
//            System.out.println("Bigger than 5");
//        } else {
//            System.out.println("Smaller than 5");
//        }
//        HashTable<Integer, Integer> table = new HashTable<>();
//        for (int i = 0; i < 100; i++) {
//            table.add(new Random().nextInt(200), new Random().nextInt(50));
//        }
//        table.print();

        BinaryTree<Integer> tree = new BinaryTree<>();
        for (int i = 0; i < 10; i++) {
            int random = new Random().nextInt(20);
            tree.add(random);
            System.out.print(random + " ");
        }
        tree.print();
    }
}
//class Pair{
//    String key;
//    int value;
//
//    public Pair(String key, int value) {
//        this.key = key;
//        this.value = value;
//    }
//}
