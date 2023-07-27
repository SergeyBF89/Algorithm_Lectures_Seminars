package org.Lecture_4;

import java.util.ArrayList;
import java.util.List;

// Дерево
public class Tree {
    Node root;

    public class Node {
        int value;
        List<Node> children;
    }

    // Метод поиска ноды на дереве в глубину
    private Node find(Node node, int value) {
        if (node.value == value) {
            return node;
        } else {
            for (Node child : node.children) {
                Node result = find(child, value);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }

    // Публичный метод в глубину

    public boolean exist(int value) {
        if (root != null) {
            Node node = find(root, value);
            if (node != null) {
                return true;
            }
        }
        return false;
    }

    // Метод поиска ноды на дереве в ширину
    private Node find(int value) {
        List<Node> line = new ArrayList<>();
        line.add(root);
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node : line) {
                if (node.value == value) {
                    return node;
                }
                nextLine.addAll(node.children);
            }
            line = nextLine;
        }
        return null;
    }
}
