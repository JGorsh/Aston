package org.gorsh.lsit;

/**
 * Реализация интерфейса с изменяемым размером массива List.
 * Реализует операции: add(), get(), clearAll(), remove().
 * Каждый ArrayList экземпляр имеет емкость. Емкость — это размер массива, используемого для хранения элементов списка.
 * Он всегда не меньше размера списка. По мере добавления элементов в список ArrayList его емкость автоматически увеличивается.
 * Реализация ArrayList не синхронизирована.
 */
public class ArrayList <T> {

    private static final int DEFAULT_CAP = 10;
    private int size;
    private T[] elements;

    public ArrayList() {
        this.elements = (T[]) new Object[DEFAULT_CAP];
        this.size = 0;
    }

    /**
     * Реализация метода get() - получение элемента по индексу.
     * @param index - индекс нужного элемента.
     */

    public T get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        return elements[index];
    }

    /**
     * Реализация метода add() - добаление элемента.
     * @param element - элемент для добавления.
     */

    public void add(T element) {
        if (size == elements.length) resize();
        elements[size] = element;
        size++;
    }

    /**
     * Реализация метода remove() - удаление элемента по индексу.
     * @param index - индекс нужного элемента.
     */

    public void remove(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();

        for (int i = index; i < (size - 1); i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    /**
     * Реализация метода clearAll() - очистка списка.
     */

    public void clearAll() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    public void set(int index, T element) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
        elements[index] = element;
    }

    public int size() {
        return this.size;
    }

    private void resize() {
        T[] oldElements = elements;

        elements = (T[]) new Object[oldElements.length + oldElements.length / 2];

        for (int i = 0; i < size; i++) {
            elements[i] = oldElements[i];
        }
    }

    public static <T extends Comparable<T>> void sort(ArrayList<T> array) {
        ArrayList<T> left = new ArrayList<>();
        ArrayList<T> right = new ArrayList<>();

        if (array.size() == 1) return;

        int middle = array.size() / 2;

        for (int i = 0; i < middle; i++) {
            left.add(array.get(i));
        }

        for (int i = middle; i < array.size(); i++) {
            right.add(array.get(i));
        }

        sort(left);
        sort(right);

        merge(left, right, array);
    }

    private static <T extends Comparable<T>> void merge(ArrayList<T> left, ArrayList<T> right, ArrayList<T> list) {

        int leftIndex = 0, rightIndex = 0, index = 0;

        while ((leftIndex < left.size()) && (rightIndex < right.size())) {
            if (left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) {
                list.set(index, left.get(leftIndex));
                leftIndex++;
            } else {
                list.set(index, right.get(rightIndex));
                rightIndex++;
            }
            index++;
        }

        while (leftIndex < left.size()) {
            list.set(index, left.get(leftIndex));
            index++;
            leftIndex++;
        }

        while (rightIndex < right.size()) {
            list.set(index, right.get(rightIndex));
            index++;
            rightIndex++;
        }
    }
}
