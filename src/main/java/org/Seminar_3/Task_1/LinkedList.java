package org.Seminar_3.Task_1;

public class LinkedList {

    private Node head; // голова списка
    private int size; // размер списка

    // Метод добавления в список
    public void add(int value) {
        if (head == null) {
            head = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        Node newNode = new Node(value);
        currentNode.next = newNode;
        newNode.prev = currentNode;
        size++;
    }

    // Метод удаления из списка по значению
    public boolean remove(int value) {
        if (head == null) {
            return false;
        }
        if (head.value == value) {
            head = head.next;
            head.prev = null;
            size--;
            return true;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode;
                }
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    // Метод удаления из списка по index
    public void removeAt(int index) {
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        Node gelNode = getNode(index - 1);
        gelNode.next = gelNode.next.next;
        if (gelNode.next != null) {
            gelNode.next.prev = gelNode;
        }
    }

    // Метод удаления всех элементов по значению
    public void removeAll(int value) {
        while (head != null && head.value == value) {
            head = head.next;
            head.prev = null;
            size--;
        }
        if (head == null) {
            return;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null) {
                    currentNode.next.prev = currentNode;
                }
                size--;
            }else {
                currentNode = currentNode.next;
            }

        }
    }

    // Метод, который забирает какую то ноду (Node) по индексу
    private Node getNode(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    // Метод, который позволит забирать пользователю значение по index
    public int getValue(int index) {
        return getNode(index).value;
    }

    // Метод, который позволит сохранить пользователю значение по index
    public void setValue(int index, int value) {
        Node setNode = getNode(index);
        setNode.value = value;
    }

    // Метод замены элементов на позициях по index
    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index1 == index2) {
            return;
        }
        Node node1 = null, node2 = null, currentNode = head;
        for (int i = 0; currentNode != null; i++) {
            if (index1 == i) {
                node1 = currentNode;
            }
            if (index2 == i) {
                node2 = currentNode;
            }
            if (node2 != null && node1 != null) {
                break;
            }
            currentNode = currentNode.next;
        }
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    // Метод печати списка
    public void print() {
        Node currentNode = head;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("] size: " + size);
    }

    // Метод печати обратной сортировки
    public void printRevers() {
        Node currentNode = getNode(size - 1);
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.prev;
        }
        System.out.println("] size: " + size);
    }


    // Метод для того что бы брать публично size
    public int size() {
        return size;
    }
    private class Node {
        int value;
        Node next;
        Node prev;

        Node() {}

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    // Метод сортировки для пользователя
    public void quickSort() {
        quickSort(0, size - 1);
    }

    // Метод сортировки
    private void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Node leftNode = getNode(leftMarker);
        Node rightNode = getNode(rightMarker);
        int pivot = this.getValue((leftMarker + rightMarker) / 2);
        while (leftMarker <= rightMarker) {
            while (leftNode.value < pivot) {
                leftNode = leftNode.next;
                leftMarker++;
            }
            while (rightNode.value > pivot) {
                rightNode = rightNode.prev;
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker) {
                    swap(leftMarker, rightMarker);
                }
                leftNode = leftNode.next;
                rightNode = rightNode.prev;
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftBorder < rightMarker) {
            quickSort(leftBorder, rightMarker);
        }
        if (leftMarker < rightBorder) {
            quickSort(leftMarker, rightBorder);
        }
    }
}
