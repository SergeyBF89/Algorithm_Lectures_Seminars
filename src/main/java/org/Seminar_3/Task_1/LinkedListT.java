package org.Seminar_3.Task_1;

public class LinkedListT<T extends  Comparable<T>> {
    private Node root;
    private int size;

    public void add(T value) {
        if (root == null) {
            root = new Node(value);
            size = 1;
            return;
        }
        Node currentNode = root;
        while (currentNode.next != null) currentNode = currentNode.next;
        Node newNode = new Node(value);
        currentNode.next = newNode;
        newNode.prev = currentNode;
        size++;
    }

    public boolean remove(T value) {
        if (root == null) return false;
        if (root.value.compareTo(value) == 0) {
            root = root.next;
            root.prev = null;
            size--;
            return true;
        }
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null) currentNode.next.prev = currentNode;
                size--;
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    public void removeAt(int index) {
        if (index == 0) {
            root = root.next;
            size--;
            return;
        }
        Node delNode = getNode(index - 1);
        delNode.next = delNode.next.next;
        if (delNode.next != null) delNode.next.prev = delNode;
    }

    public void removeAll(T value) {
        while (root != null && root.value == value) {
            root = root.next;
            root.prev = null;
            size--;
        }
        if (root == null) return;
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value.compareTo(value) == 0) {
                currentNode.next = currentNode.next.next;
                if (currentNode.next != null)
                    currentNode.next.prev = currentNode;
                size--;
            } else currentNode = currentNode.next;
        }
    }

    public void quickSort() {
        quickSort(0, size - 1);
    }

    public void quickSort2() {
        quickSort2(0, size - 1);
    }

    private void quickSort(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        Node leftNode = getNode(leftMarker);
        Node rightNode = getNode(rightMarker);
        T pivot = this.getValue((leftMarker + rightMarker) / 2);

        while (leftMarker <= rightMarker) {
            while (leftNode.value.compareTo(pivot) < 0) {
                leftNode = leftNode.next;
                leftMarker++;
            }
            while (rightNode.value.compareTo(pivot) > 0) {
                rightNode = rightNode.prev;
                rightMarker--;
            }
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    swap(leftMarker, rightMarker);
                leftNode = leftNode.next;
                rightNode = rightNode.prev;
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftBorder < rightMarker)
            quickSort(leftBorder, rightMarker);
        if (leftMarker < rightBorder)
            quickSort(leftMarker, rightBorder);
    }

    private void quickSort2(int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        T pivot = this.getValue((leftMarker + rightMarker) / 2);

        while (leftMarker <= rightMarker) {
            while (this.getValue(leftMarker).compareTo(pivot) < 0)
                leftMarker++;
            while (this.getValue(rightMarker).compareTo(pivot) > 0)
                rightMarker--;
            if (leftMarker <= rightMarker) {
                if (leftMarker < rightMarker)
                    swap(leftMarker, rightMarker);
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftBorder < rightMarker)
            quickSort(leftBorder, rightMarker);
        if (leftMarker < rightBorder)
            quickSort(leftMarker, rightBorder);
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node currentNode = root;
        for (int i = 0; i < index; i++)
            currentNode = currentNode.next;
        return currentNode;
    }

    public T getValue(int index) {
        return getNode(index).value;
    }

    public void setValue(int index, T value) {
        Node setNode = getNode(index);
        setNode.value = value;
    }

    public void swap(int index1, int index2) {
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size) throw new IndexOutOfBoundsException();
        if (index1 == index2) return;
        Node node1 = null, node2 = null, currentNode = root;
        for (int i = 0; currentNode != null; i++) {
            if (index1 == i) node1 = currentNode;
            if (index2 == i) node2 = currentNode;
            if (node2 != null && node1 != null) break;
            currentNode = currentNode.next;
        }
        T temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    public void print() {
        Node currentNode = root;
        System.out.print("[ ");
        while (currentNode != null) {
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next;
        }
        System.out.println("] size: " + size);
    }

    public int size() {
        return size;
    }

    private class Node {
        T value;
        Node next;
        Node prev;

        Node() {
        }

        Node(T value) {
            this.value = value;
        }
    }
}
