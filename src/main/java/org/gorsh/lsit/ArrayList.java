package org.gorsh.lsit;

public class ArrayList <T> implements List<T>{

    private static final int CAPACITY = 10;
    private int presentSize = 0;
    private Object[] newArray = new Object[CAPACITY];

    @Override
    public T get(int index) {
        return (T) newArray[index];
    }

    @Override
    public void add(T element) {
        if(presentSize == newArray.length-1){
            increaseSize(newArray.length*2);
        }
        newArray[presentSize++] = element;
    }

    @Override
    public void remove(int index) {
        for (int i = index; i<presentSize; i++)
            newArray[i] = newArray[i+1];
        newArray[presentSize] = null;
        presentSize--;
    }

    @Override
    public void clearAll() {
        for (int i = 0; i<presentSize; i++)
        newArray[i] = null;
    }

    @Override
    public void sort() {

    }

    private void increaseSize(int newLength) {
        Object[] nextArray = new Object[newLength];
        System.arraycopy(newArray, 0, nextArray, 0, presentSize);
        newArray = nextArray;
    }
}
