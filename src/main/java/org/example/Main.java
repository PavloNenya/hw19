package org.example;

public class Main {
    public static void main(String[] args) {
        MyLinkedListImpl<Integer> myLinkedList = new MyLinkedListImpl<>();
        myLinkedList.add(7);
        myLinkedList.add(6);
        myLinkedList.add(5);
        myLinkedList.add(4);
        myLinkedList.add(3);
        myLinkedList.add(2);
        myLinkedList.add(1);

        myLinkedList.print();
        myLinkedList.remove(2);
        myLinkedList.sort(Integer::compareTo);
        myLinkedList.print();
    }
}