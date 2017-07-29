package lesson3;

import java.util.*;

/**
 * Created by entony on 13.07.17.
 */
public class MyArrayList<T> implements List<T>, RandomAccess {

    private Object[] data;
    private int size = 0;
    private int capacity = 10;

    private void checkCapacity(int minCapacity){
        if (minCapacity > capacity)
            increaseCapacity();
    }

    private void increaseCapacity(){
        int newCapacity = (capacity * 3) / 2 + 1;
        data = Arrays.copyOf(data, newCapacity);
    }

    private void checkRange(int index){
        if ((index > size)||(index < 0))
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds [0-" + size + "]");
    }

    private T data(int index){
        return (T) data[index];
    }

    public MyArrayList() {
        data = new Object[capacity];
    }

    public MyArrayList(int capacity) {
        if (capacity > 0) {
            data = new Object[capacity];
        } else if (capacity == 0) {
            data = new Object[this.capacity];
        } else {
            throw new IllegalArgumentException("Illegal size, must be > 0");
        }
    }

    public MyArrayList(Collection<? extends T> c){
        data = c.toArray();
    }

    public boolean add(T e) {
        checkCapacity(size + 1);
        data[size++] = e;
        return true;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            public boolean hasNext() {
                return (currentIndex < size) && (data[currentIndex] != null);
            }

            public T next() {
                if (currentIndex < size)
                    return (T) data[currentIndex++];
                return null;
            }

        };
    }

    public void sort(Comparator<? super T> c){
        Arrays.sort((T[]) data, 0, size, c);
    }

    public T set(int index, T element) {
        checkRange(index);
        T prevElement = data(index);
        data[index] = element;
        return prevElement;
    }

    public T get(int index) {
        checkRange(index);
        return data(index);
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public void clear() {
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void add(int index, T element) {

    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public T remove(int index) {
        return null;
    }


}
