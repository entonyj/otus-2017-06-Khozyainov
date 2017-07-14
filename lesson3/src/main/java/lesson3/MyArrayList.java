package lesson3;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.Consumer;

/**
 * Created by entony on 13.07.17.
 */
public class MyArrayList<T> implements List<T>{

    private T[] myArrayList;
    private int size;

    public Iterator<T> iterator(){
        return new Iterator<T>() {

            private int currentIdx = 0;

            public boolean hasNext() {
                return (currentIdx < size) && (myArrayList[currentIdx] != null);
            }

            public T next() {
                return myArrayList[currentIdx++];
            }

            @Ignore
            public void forEachRemaining() throws UnsupportedOperationException {}

            @Ignore
            public void remove() throws UnsupportedOperationException{}
        };
    }

    public boolean add(T t) {
        return false;
    }

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size==0;
    }

    public boolean contains(Object o) {
        return false;
    }

    @Ignore
    public Object[] toArray() throws UnsupportedOperationException{throw new UnsupportedOperationException("toArray");}

    public <T> T[] toArray(T[] a) {
        return null;
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

    @Ignore
    public void clear() throws UnsupportedOperationException{}

    public T get(int index) {
        return null;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {

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

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

}
