package lesson3;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.*;
import java.util.function.UnaryOperator;

/**
 * Created by entony on 13.07.17.
 */
public class MyArrayList<T> implements List<T> {

    private Object[] myArrayList;
    private int size = 0;
    private int capacity = 10;

    private void checkCapacity(int minCapacity){
        if (minCapacity - capacity > 0)
            increaseCapacity();
    }

    private void increaseCapacity(){
        int newCapacity = (capacity * 3) / 2 + 1;
        myArrayList = Arrays.copyOf(myArrayList, newCapacity);
    }

    public MyArrayList() {
        myArrayList = new Object[capacity];
    }

    public MyArrayList(int capacity) throws IllegalArgumentException {
        if (capacity > 0) {
            myArrayList = new Object[capacity];
        } else if (capacity == 0) {
            myArrayList = new Object[this.capacity];
        } else {
            throw new IllegalArgumentException("Illegal size, must be > 0");
        }
    }

    public boolean add(T e) {
        checkCapacity(size + 1);
        myArrayList[size++] = e;
        return true;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIdx = 0;

            public boolean hasNext() {
                return (currentIdx < size) && (myArrayList[currentIdx] != null);
            }

            public T next() {
                if (currentIdx < size)
                    return (T) myArrayList[currentIdx++];
                return null;
            }

            @Ignore
            public void forEachRemaining() throws UnsupportedOperationException {
            }

            @Ignore
            public void remove() throws UnsupportedOperationException {
            }
        };
    }

    //*TODO Realise methods: add, set, toArray,


    public T set(int index, T element) {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public void sort(Comparator<? super T> c) {

    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }


    //*TODO add exceptions


    public boolean contains(Object o) {
        return false;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void replaceAll(UnaryOperator<T> operator) {

    }

    public void add(int index, T element) {

    }

    @Ignore
    public void clear() throws UnsupportedOperationException {
    }

    public T get(int index) {
        return null;
    }

    public T remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Spliterator<T> spliterator() {
        return null;
    }

}
