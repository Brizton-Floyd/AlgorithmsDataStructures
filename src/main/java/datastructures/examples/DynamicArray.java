package datastructures.examples;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArray<T> implements Iterable<T> {

    private T[] arr;
    private int len = 0; // length the user thinks array is
    private int capacity = 0; // actual capacity

    public DynamicArray(){
        this(16);
    }

    public DynamicArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        this.capacity = capacity;
        arr =  (T[]) new Object[capacity];
    }

    public int size(){
        return this.len;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public void set(int index, T element){
        arr[index] = element;
    }

    public void clear(){
        for(int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    public void add(T element){
        // Check to see if the array needs to be resized
        if(len + 1 > capacity){
            if(capacity == 0) capacity = 1;
            else capacity *= 2; // double the size of the array
            T[] newArray = (T[]) new Object[capacity];
            for(int i = 0; i < len; i++) {
                newArray[i] = arr[i];
            }
            arr = newArray;
        }

        arr[len++] = element;
    }

    public T removeAt(int removeIndex){
        validateIndex(removeIndex);
        T data = arr[removeIndex]; // Select element needing to be removed
        T[] newArray = (T[]) new Object[len -1]; // new array to hold new data after removal
        for(int i = 0, j = 0; i < len; i++, j++){
            if(i == removeIndex) j--; // decrement j back one value since i and j were the same value up until this point
            else newArray[j] = arr[i];
        }

        arr = newArray;
        capacity = --len; // fix capacity value
        return data;
    }

    public boolean remove(Object obj){
        final int index = indexOf(obj);
        if(index == -1) return false;
        removeAt(index);
        return true;
    }

    public int indexOf(Object obj){
        for(int i = 0; i < len; i++){
            if(obj == null){
                if(arr[i] == null) return i;
            }
            else if(obj.equals(arr[i])) return i;
        }
        return -1;
    }

    public boolean contains(Object obj){
        return indexOf(obj) != -1;
    }

    private void validateIndex(final int index){
        if(index >= len || index < 0) throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public T next() {
                return null;
            }
        };
    }

    @Override
    public String toString() {
        if(len == 0) return "[]";

        StringBuilder sb = new StringBuilder(len).append("[");
        for(int i = 0; i < len - 1; i++){
            sb.append(arr[i]).append(", ");
        }
        return sb.append(arr[len - 1]).append("]").toString();
    }
}