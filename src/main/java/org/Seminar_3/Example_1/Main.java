package org.Seminar_3.Example_1;

// Node (принцип связанного списка)
public class Main {
    public static void main(String[] args) {
        Node node1 = new Node(5);
        Node node2 = new Node(2);
        Node node3 = new Node(1);
        Node node4 = new Node(8);
        Node node5 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        System.out.print(node1.value + " ");
        System.out.print(node1.next.value + " ");
        System.out.print(node1.next.next.value + " ");
        System.out.print(node1.next.next.next.value + " ");
        System.out.print(node1.next.next.next.next.value + " ");
    }

    static class Node {
        int value;
        Node next;
        Node() {}
        Node(int value) {
            this.value = value;
        }
    }
}
