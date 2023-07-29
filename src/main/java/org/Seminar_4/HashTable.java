package org.Seminar_4;

public class HashTable<K, V> {
    private static final int DEFAULT_SIZE = 16; // Стандартный размер хеш-таблицы
    private static final double LOAD_FACTOR = 0.75; // Коэффициент заполненности
    private int size = 0; // Количество заполненных элементов
    private Bucket<K, V>[] buckets;

    public HashTable() {
        this(DEFAULT_SIZE);
    }

    public void print() {
        for (Bucket i : buckets) {
            if (i != null) {
                i.print();
                System.out.println();
            } else {
                System.out.println("---");
            }
        }
    }

    public HashTable(int size) {
        buckets = new Bucket[size];
    }

    private int calculateIndex(K key) // Считает хеш значение относительно ключа
    {
        return Math.abs(key.hashCode() % buckets.length);
    }

    public V get(K key) {
        int index = calculateIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null)
            return null;
        return bucket.get(key);
    }

    public boolean add(K key, V value) {
        if (buckets.length * LOAD_FACTOR < size)
            recalculate();
        int index = calculateIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null) {
            bucket = new Bucket<>();
            buckets[index] = bucket;
        }
        boolean added = bucket.add(key, value);
        if (added)
            size++;
        return added;
    }

    public boolean remove(K key) {

        int index = calculateIndex(key);
        Bucket<K, V> bucket = buckets[index];
        if (bucket == null)
            return false;
        boolean removed = bucket.delete(key);
        if (removed)
            size--;
        return removed;
    }

    private void recalculate() {
        Bucket<K, V>[] old = buckets;
        buckets = new Bucket[old.length * 2];
        for (int i = 0; i < old.length; i++) {
            Bucket<K, V> bucket = old[i];
            if (bucket != null) {
                Bucket.Node currentNode = bucket.root;
                while (currentNode != null) {
                    this.add((K) currentNode.entity.key, (V) currentNode.entity.value);
                    currentNode = currentNode.next;
                }
            }
            old[i] = null;
        }
        old = null;
    }

    private class Bucket<K, V> // Односвязный список
    {
        Node root;

        public V get(K key) {
            Node currentNode = root;
            while (currentNode != null)
                if (currentNode.entity.key.equals(key))
                    return currentNode.entity.value;
                else
                    currentNode = currentNode.next;
            return null;
        }

        public boolean add(Entity entity) {
            Node node = new Node();
            node.entity = entity;
            if (root != null) {
                Node currentNode = root;
                while (currentNode != null) {
                    if (currentNode.entity.equals(entity))
                        return false;
                    if (currentNode.next == null) {
                        currentNode.next = node;
                        return true;
                    }
                    currentNode = currentNode.next;
                }
            }
            root = node;
            return true;
        }

        public void print() {
            Node currentNode = root;
            while (currentNode != null) {
                System.out.print("[" + currentNode.entity.key + ":" + currentNode.entity.value + "] ");
                currentNode = currentNode.next;
            }
        }

        public boolean add(K key, V value) {
            Entity entity = new Entity(key, value);
            return this.add(entity);
        }

        public boolean delete(K key) {
            if (root == null)
                return false;
            if (root.entity.key.equals(key)) {
                root = root.next;
                return true;
            } else {
                Node currentNode = root;
                while (currentNode.next != null) {
                    if (currentNode.next.entity.key.equals(key)) {
                        currentNode.next = currentNode.next.next;
                        return true;
                    }
                    currentNode = currentNode.next;
                }
            }
            return false;
        }

        private class Node {
            Node next;
            Entity<K, V> entity;
        }

        private class Entity<K, V> {
            K key;
            V value;

            public Entity() {
            }

            public Entity(K key, V value) {
                this.key = key;
                this.value = value;
            }
        }
    }


}
