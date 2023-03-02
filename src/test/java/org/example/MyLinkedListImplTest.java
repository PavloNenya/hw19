package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest {
    static MyLinkedListImpl<Integer> myLinkedList = new MyLinkedListImpl<>();
    @BeforeAll
    static void fillList() {
        //Act
        myLinkedList.add(7);
        myLinkedList.add(6);
        myLinkedList.add(5);
        myLinkedList.add(4);
        myLinkedList.add(3);
        myLinkedList.add(2);
        myLinkedList.add(1);

        //Assert
        assertEquals(5, myLinkedList.get(2));
        assertEquals(3, myLinkedList.get(4));
    }

    @Test
    void replaceElement() {
        //Act
        myLinkedList.replace(0, 10);
        myLinkedList.replace(5, 22);
        //Assert
        assertEquals(10, myLinkedList.get(0));
        assertEquals(22, myLinkedList.get(5));
    }

    @Test
    void sortTest() {
        //Act
        myLinkedList.sort(Integer::compareTo);
        //Assert
        assertEquals(1, myLinkedList.get(0));
        assertEquals(2, myLinkedList.get(1));
        assertEquals(3, myLinkedList.get(2));
        assertEquals(4, myLinkedList.get(3));
    }
}