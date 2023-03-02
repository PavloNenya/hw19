package org.example;

import java.util.*;

public class MyLinkedListImpl<T> implements MyLinkedList<T> {
    private Node<T> first;
    private Node<T> last;
    private int size = 0;

    @Override
    public void add(T element) {
        Node<T> newNode = new Node<>(element);
        if(first == null) {
            first = last = newNode;
        } else {
            last.next = newNode;
            newNode.previous = last;
            last = newNode;
        }
        size++;
    }

    private Node<T> findNodeByIndex(int index) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> node = first;
        for(int i = 0; i < size; i++) {
            if(i == index)
                break;
            node = node.next;
        }
        return node;
    }

    @Override
    public void remove(int index) {
        if(isEmpty())
            throw new IndexOutOfBoundsException();
        Node<T> deleted = findNodeByIndex(index);
        if(deleted == first) {
            first = first.next;
            first.previous = null;
        } else if(deleted == last) {
            last = findNodeByIndex(index-1);
            last.next = null;
        } else {
            Node<T> previous = findNodeByIndex(index-1);
            previous.next = deleted.next;
            deleted.next.previous = previous;
        }
        size--;
    }
    @Override
    public T replace(int index, T element) {
        if(index < 0 || index >= size)
            throw new IndexOutOfBoundsException();
        Node<T> nodeToReplace = findNodeByIndex(index);
        T elementToReturn = nodeToReplace.element;
        if(index == 0) {
            first.element = element;
        } else if(index == size -1) {
            last.element = element;
        } else {
            nodeToReplace.element = element;
        }
        return elementToReturn;
    }

    @Override
    public void print() {
        Node<T> current = first;
        System.out.print("List: {");
        while(current!=null) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println("}");
    }

    @Override
    public T get(int index) {
        return findNodeByIndex(index).element;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        T[] arr = this.toArray();

        arr = (T[]) Arrays.stream(arr).sorted().toArray();
        Node<T> current = first;
        int index = 0;
        while(current!=null) {
            current.element = arr[index];
            current = current.next;
            index++;
        }
    }

    public T[] toArray() {
        Object[] array = new Object[size];
        Node<T> current = first;
        int index = 0;
        while(current!= null) {
            array[index] = current.element;
            current = current.next;
            index++;
        }
        return  (T[]) array;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int getSize() {
        return size;
    }

    private static class Node<T> {
        T element;
        Node<T> next = null;
        Node<T> previous = null;

        public Node(T element) {
            this.element = element;
        }
    }
}
