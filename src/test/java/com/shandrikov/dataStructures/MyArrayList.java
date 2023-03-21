package com.shandrikov.dataStructures;

public class MyArrayList <T> {
    private T[] list;
    private int size;
    private int DEFAULT_CAPACTITY = 10;
    private int listCapacity;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else {
            list = (T[]) new Object[capacity];
            listCapacity = capacity;
        }
    }

    public MyArrayList() {
        list = (T[]) new Object[DEFAULT_CAPACTITY];
        listCapacity = DEFAULT_CAPACTITY;
    }

    public void add(T item) {
        if (size == listCapacity - 1) {
            resize(listCapacity*2);
        }
        list[size++] = item;
    }

    private void resize(int newLength) {
        T[] newList = (T[]) new Object[newLength];
        for (int i = 0; i < size; i++) {
            newList[i] = list[i];
        }
    }

    public void add(int index, T item) {
        for (int i = size; i > index ; i--) {
            list[i] = list[i - 1];
        }
        list[index] = item;
    }

    public void delete(int index) {
        for (int i = index; i < size ; i++) {
            list[i] = list[i + 1];
        }
        list[size--] = null;
    }

    public void delete(T item) {
        int index = getIndex(item);
        if (index < 0) return;
        delete(index);
    }

    private int getIndex(T item) {
        if (item == null) return -1;
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) return i;
        }
        return -1;
    }

    public T get(int index) {
        return list[index];
    }

    public void set(int index, T item) {
        list[index] = item;
    }

    public void print() {
        for (T item : list) {
            System.out.println(item + " ");
        }
    }


}
