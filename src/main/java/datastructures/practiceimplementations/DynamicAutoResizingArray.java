package datastructures.practiceimplementations;

import datastructures.practiceimplementations.interfaces.DynamicArray;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicAutoResizingArray<T> implements DynamicArray<T> {

    private T[] arr; // Data structure to hold elements fo tye T
    private int len; // The actual size of the array
    private int capacity; // The amount of data the array can hold

    public DynamicAutoResizingArray(){
        this(10);
    }
    public DynamicAutoResizingArray(int capacity){
        if(capacity < 0) throw new IllegalArgumentException("Illegal Argument: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }
    @Override
    public void add(T element) {
        // Check to see if the array needs to be resized. A clear operation could have occurred previously
        if(len + 1 > capacity){ Resize(); }
        arr[len++] = element; // Finally add the new element to the array
    }

    private void Resize() {
        if(capacity == 0) {capacity = 1;}
        else {capacity *= 2;}
        T[] newArray = (T[]) new Object[capacity]; // new array to hold elements after resizing
        System.arraycopy(arr, 0, newArray, 0, len);
        arr = newArray;
    }

    @Override
    public void set(int index, T element) {
        validateIndex(index);
        arr[index] = element;
    }

    @Override
    public T removeAt(int removeIndex) {
        validateIndex(removeIndex);
        T data = arr[removeIndex]; // Get the data object at the given index to be removed
        T[] newArray = (T[]) new Object[len - 1]; // new array to with a size less than the actual arr data structure
        for(int i = 0, j = 0; i < len; i++, j++){
            if(i == removeIndex) j--; // Decrement j so values can be inserted in correct index of new Array.
            else newArray[j] = arr[i];
        }
        arr = newArray;
        capacity = --len;
        return data;
    }

    @Override
    public void clear() {
        for(int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    @Override
    public int size() {
        return this.len;
    }

    @Override
    public boolean remove(Object obj) {
        final int index = indexOf(obj);
        if(index < 0) return false;
        removeAt(index);
        return true;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public T get(int index) {
        validateIndex(index);
        return arr[index];
    }

    @Override
    public int indexOf(Object obj) {
        for(int i = 0; i < len; i++){
            if(obj == null) {
                if(arr[i] == null) return i;
            }
            else if(obj.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    private void validateIndex(int removeIndex) {
        if(removeIndex >= len || removeIndex < 0) throw new IndexOutOfBoundsException();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            @Override
            public boolean hasNext() {
                return index < len;
            }

            @Override
            public T next() {
                return arr[index++];
            }
        };
    }

    @Override
    public String toString() {
        if (len == 0) return "[]";

        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < len - 1; i++){
            sb.append(arr[i]).append(", ");
        }
        return sb.append(arr[len-1]).append("]").toString();
    }
}
