package org.gorsh.lsit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListTest {

    @Test
    void addAndGet() {
        ArrayList <String> example = new ArrayList<>();
        String str = "One";
        String str1 = "Two";
        String str2 = "Three";

        example.add(str);
        example.add(str1);
        example.add(str2);

        assertTrue(str.equals(example.get(0)));
        assertTrue(str1.equals(example.get(1)));
        assertTrue(str2.equals(example.get(2)));

    }

    @Test
    void remove() {
        ArrayList <String> example = new ArrayList<>();
        ArrayList <String> example1 = new ArrayList<>();

        String str = "One";
        String str1 = "Two";
        String str2 = "Three";

        example.add(str);
        example.add(str1);
        example.add(str2);

        example.add(str);
        example.add(str1);

        example.remove(2);

    }

    @Test
    void clearAll() {

    }

    @Test
    void sort() {
    }
}