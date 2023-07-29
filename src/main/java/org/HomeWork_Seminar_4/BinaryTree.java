package org.HomeWork_Seminar_4;

public class BinaryTree<T extends Comparable<T>> {
    private Node root; // корень дерева
    private class Node {
        private T value;
        private Color color;
        private Node left;
        private Node right;

        Node() {
            color = Color.red; // нода всегда добавляется красным цветом
        }
    }
    enum Color {red, black}

    public boolean add(T value) {
        if (root == null) {
            Node node = new Node();
            node.value = value; // задаем значение которое передаем
            root = node; // записываем в корень ноду
            root.color = Color.black; // цвет ноды корня всегда черный
            return true;
        }
        return addNode(root, value);
    }

    private boolean addNode(Node node, T value) {
        // Проверка на одинаковое значение
        if (root.value == value) {
            return false;
        }
        // Обрабатываем левую ноду
        if (node.value.compareTo(value) > 0) {
            if (node.left != null) {
                boolean result = addNode(node.left, value);
                node.left = rebalanced(node.left);
                return result;
            } else {
                node.left = new Node();
                node.left.value = value;
                return true;
            }
            // Обрабатываем правую ноду
        } else {
            if (node.right != null) {
                boolean result = addNode(node.right, value);
                node.right = rebalanced(node.right);
                return result;
            } else {
                node.right = new Node();
                node.right.value = value;
                return true;
            }
        }
    }
    // Метод ребалансировки
    private Node rebalanced(Node node) {
        Node result = node;
        boolean needRebalanced;
        do {
            needRebalanced = false;
            if (result.right != null && result.right.color == Color.red
                    && (result.left == null || result.left.color == Color.black)) {
                needRebalanced = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.red
                    && result.left.left != null && result.left.left.color == Color.red) {
                needRebalanced = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.red
                    && result.right != null && result.right.color == Color.red) {
                needRebalanced = true;
                colorSwap(result);
            }
        } while (needRebalanced);
        return result;
    }

    // Метод замены цвета ноды(если оба наследника красные)
    private void colorSwap(Node node) {
        node.right.color = Color.black;
        node.left.color = Color.black;
        node.color = Color.red;
    }

    // Метод левого замены ноды
    private Node leftSwap(Node node) {
        Node left = node.left;
        Node between = left.right;
        left.right = node;
        node.left = between;
        left.color = node.color;
        node.color = Color.red;
        return left;
    }

    // Метод правого замены ноды
    private Node rightSwap(Node node) {
        Node right = node.right;
        Node between = node.left;
        right.left = node;
        node.right = between;
        right.color = node.color;
        node.color = Color.red;
        return right;
    }

    // Метод сравнения значений нод
    public boolean contain(T value) {
        Node currentNode = root;
        while (currentNode != null) {
            if (currentNode.value.equals(value)) {
                return true;
            }
            if (currentNode.value.compareTo(value) > 0) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }
}

