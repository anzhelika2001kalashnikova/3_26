package com.company;

import java.util.Iterator;

public class LinkedListStack<T> {

    private final LinkedList<T> linkedList = new LinkedList<>();

    public void push(T data) {
        linkedList.addFirst(data);
    }

    public T pop() {
        return linkedList.removeFirst();
    }

    public boolean isEmpty() {
        return linkedList.isEmpty();
    }

    public void duplicationStack() {
        linkedList.doubleElement();
    }

    @Override
    public String toString() {
        return linkedList.getListToString();
    }
}

class LinkedList<T> {

    private static class Node<T> {

        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data.toString();
        }
    }

    private Node<T> first = null;

    public void addFirst(T data) {
        Node<T> newFirst = new Node<>(data);
        newFirst.next = first;
        first = newFirst;
    }

    public T removeFirst() {
        Node<T> oldFirst = first;
        first = first.next;
        return oldFirst.data;
    }

    public void doubleElement() {
        Node<T> current = first;
        while (current != null) {
            current.next = new Node<T>(current.data, current.next);
            current = current.next.next;
        }
    }

    public String getListToString() {
        String result = "";
        Iterator<T> itr = iterator();
        while (itr.hasNext()) {
            result += itr.next().toString() + " ";
        }
        return result;
    }


    public boolean isEmpty() {
        return first == null;
    }

    private class MyLinkedIteration implements Iterator<T> {
        private Node<T> current;

        public MyLinkedIteration(Node<T> head) {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            T result = current.data;
            current = current.next;
            return result;
        }
    }

    public Iterator<T> iterator() {
        Node<T> tail = first;
        return new MyLinkedIteration(tail);
    }

}

