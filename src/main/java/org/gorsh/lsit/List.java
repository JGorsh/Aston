package org.gorsh.lsit;

public interface List <E>{
E get(int index);

void add(E element);

E remove(E element);

void clearAll();

void sort();
}
