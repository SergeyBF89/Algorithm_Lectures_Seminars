package org.Lecture_3;

public class Main {
    Node head; // начало списка
    Node tail; // конец списка

    // Метод добавление элементов в конец списка
    public void add(int value) {
        Node node = new Node();
        node.value = value;
        if (head == null) {
            head = node;
            tail = node;
        }else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    // Метод добавления элементов в середину списка
    public void add(int value, Node node) {
        Node next = node.next; // ссылки на следующий элемент
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;
        if (next == null) {
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.previous = next;
        }
    }

    // Функция удаления элементов из списка
    public void delete(Node node) {
        Node previous = node.previous;
        Node next = node.next;
        if (previous == null) {
            next.previous = null;
            head = next;
        }else {
            if (next == null) {
                previous.next = null;
                tail = previous;
            }else {
                previous.next = next;
                next.previous = previous;
            }
        }

    }

    // Метод, который ищет соответствующий элемент в списке
    public Node find(int value) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.value == value) {
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    // Метод разворота связанного списка
    public void revert1() {
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            Node previous = currentNode.previous;
            currentNode.next = previous;
            currentNode.previous = next;
            if (previous == null) {
                tail = currentNode;
            }
            if (next == null) {
                head = currentNode;
            }
            currentNode = next;
        }
    }

    // Классический клас для списков
    public class Node {
            int value; // значение списка
            Node next; // следующий элемент списка
            Node previous; // предыдущее значение
    }

    // Аналог метода разворота публичный
    public void revert() {
        if (head != null && head.next != null) {
            revert(head.next, head);
        }
    }


    // Метод разворота односвязного списка
    private void revert(Node currentNode, Node previousNode) {
        if (currentNode.next == null) {
            head = currentNode;
        }else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
        previousNode.next = null;
    }

    // Метод реализации стека добавления
    public void push(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head = node;
    }
     // Метод извлечения данных стека
    public Integer pop() {
        Integer result = null;
        if (head != null) {
            result = head.value;
            head = head.next;
        }
        return result;
    }

    // Метод добавления очереди
    public void push1(int value) {
        Node node = new Node();
        node.value = value;
        node.next = head;
        head.previous = node;
        head = node;
    }

    // Метод извлечения из очереди
    public Integer peek() {
        Integer result = null;
        if (tail != null) {
            result = tail.value;
            tail.previous.next = null;
            tail = tail.previous;
        }
        return result;
    }
}
