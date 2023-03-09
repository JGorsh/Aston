package org.gorsh.lsit;

public interface List <T>{
T get(int index);

void add(T element);

void remove(int index);

void clearAll();

void sort(T[] array);
}
