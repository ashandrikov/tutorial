package com.shandrikov.dataStructures;

public class MyLinkedList<T> {
    private Node<T> head;

    public void addFirst(T t) {
        Node<T> firstNode = new Node(t);
        firstNode.next = head;
        head = firstNode;
    }

    public void addLast(T t) {
        if (head == null) {
            head = new Node<>(t);
            return;
        }
        Node<T> current = head;
        while (head.next != null) {
            current = current.next;
        }
        current.next = new Node(t);
        ;
    }

    public int get(T t) {
        if (head == null) return -1;
        if (head.value == t) return 0;

        int result = 0;
        Node<T> current = head;
        while (head.value != t) {
            result++;
            if (current.next.value == t) return result;
            current = current.next;
        }
        return -1;
    }

    public void remove(T t) {
        if (head == null) return;
        if (head.value == t) {
            head = head.next;
            return;
        }

        Node <T> current = head;
        while (current.next != null) {
            if (current.next.value == t) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }


}

class Node<T> {
    final T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
    }
}
