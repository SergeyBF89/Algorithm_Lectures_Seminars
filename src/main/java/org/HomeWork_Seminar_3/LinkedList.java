package org.HomeWork_Seminar_3;

public class LinkedList {
    private Node head;

    private class Node {
        int value;
        Node next;
        Node prev;
        Node() {}

        public Node(int value, Node next, Node prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
        Node(int value) {
            this.value = value;
        }
    }

    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node newNode = new Node(value);
        currentNode.next = newNode;
        newNode.prev = currentNode;
    }

    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        }else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    public void revert() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }

    public void print() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

}
