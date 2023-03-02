package org.example;

import java.util.Comparator;

public interface MyLinkedList<T> {
    void add(T element);
    void remove(int index);
    T replace(int index, T newElement);
    void print();
    T get(int index);
    void sort(Comparator<? super T> comparator);
    boolean isEmpty();
    int getSize();
}
