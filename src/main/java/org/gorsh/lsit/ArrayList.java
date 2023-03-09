package org.gorsh.lsit;

/**
 * Реализация интерфейса с изменяемым размером массива List.
 * Реализует операции: add(), get(), clearAll(), remove().
 * Каждый ArrayList экземпляр имеет емкость. Емкость — это размер массива, используемого для хранения элементов списка.
 * Он всегда не меньше размера списка. По мере добавления элементов в список ArrayList его емкость автоматически увеличивается.
 * Реализация ArrayList не синхронизирована.
 */
public class ArrayList <T> implements List<T>{

    private static final int CAPACITY = 10;
    private int presentSize = 0;
    private Object[] newArray = new Object[CAPACITY];

    /**
     * Реализация метода get() - получение элемента по индексу.
     * @param index - индекс нужного элемента.
     */
    @Override
    public T get(int index) {
        return (T) newArray[index];
    }

    /**
     * Реализация метода add() - добаление элемента.
     * @param element - элемент для добавления.
     */
    @Override
    public void add(T element) {
        if(presentSize == newArray.length-1){
            increaseSize(newArray.length*2);
        }
        newArray[presentSize++] = element;
    }

    /**
     * Реализация метода remove() - удаление элемента по индексу.
     * @param index - индекс нужного элемента.
     */
    @Override
    public void remove(int index) {
        for (int i = index; i<presentSize; i++)
            newArray[i] = newArray[i+1];
        newArray[presentSize] = null;
        presentSize--;
    }

    /**
     * Реализация метода clearAll() - очистка списка.
     */
    @Override
    public void clearAll() {
        for (int i = 0; i<presentSize; i++)
        newArray[i] = null;
    }

    @Override
    public void sort(T[] array) {

    }

    private void increaseSize(int newLength) {
        Object[] nextArray = new Object[newLength];
        System.arraycopy(newArray, 0, nextArray, 0, presentSize);
        newArray = nextArray;
    }

    public  <T extends Comparable<T>> void quickSort(T[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int middle = low + (high - low) / 2;
        T point = array[middle];

        int i = low, j = high;
        while(i <= j) {
            while (array[i].compareTo(point) < 0) {
                i++;
            }
            while (array[i].compareTo(point) > 0) {
                j--;
            }
            if(i <= j) {
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }
        if(low < j) {
            quickSort(array, low, j);
        }
        if(high > i) {
            quickSort(array, i, high);
        }
    }
}
