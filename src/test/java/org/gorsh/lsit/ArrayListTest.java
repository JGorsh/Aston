package org.gorsh.lsit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    ArrayList<Integer> testNumbersList = new ArrayList<>();
    ArrayList<String> testStringList = new ArrayList<>();


    @Test
    void add() {
        for (int i = 0; i < 10; i++) {
            testNumbersList.add(i);
        }

        testNumbersList.add(11);

        assertEquals(11, testNumbersList.size());
    }

    @Test
    void get() {
        testNumbersList.add(42);

        assertEquals(42, testNumbersList.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> testNumbersList.get(10));
    }

    @Test
    void remove() {
        testNumbersList.add(42);
        testNumbersList.add(0);

        testNumbersList.remove(0);

        assertEquals(1, testNumbersList.size());
        assertEquals(0, testNumbersList.get(0));

        assertThrows(IndexOutOfBoundsException.class, () -> testNumbersList.remove(10));
    }

    @Test
    void testNumbersSort() {
        for (int i = 10; i >= 0; i--) {
            testNumbersList.add(i);
        }

        assertEquals(11, testNumbersList.size());

        ArrayList.sort(testNumbersList);

        for (int i = 0; i <= 10; i++) {
            assertEquals(i, testNumbersList.get(i));
        }
    }

    @Test
    void testStringSort() {
        testStringList.add("e");
        testStringList.add("d");
        testStringList.add("c");
        testStringList.add("a");
        testStringList.add("b");

        ArrayList.sort(testStringList);

        assertEquals("a", testStringList.get(0));
        assertEquals("e", testStringList.get(4));
    }
}