package datastructures.practiceimplementations;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DynamicArrayImpl<T> implements Iterable<T>{

    private T[] arr;
    private int len;
    private int capacity;

    public DynamicArrayImpl(){
        this(10);
    }
    public DynamicArrayImpl(int capacity){
        if(capacity < 0 ) throw new IllegalArgumentException("Illegal Argument: " + capacity);
        this.capacity = capacity;
        arr = (T[]) new Object[capacity];
    }

    public void set(int index, T element){
        validateIndex(index);
        arr[index] = element;
    }

    public int size(){
        return this.len;
    }

    public T get(int index){
        return arr[index];
    }
    public void clear(){
        for(int i = 0; i < len; i++) arr[i] = null;
        len = 0;
    }

    public boolean contains(Object obj){
        return indexOf(obj) >= 0;
    }

    public void add(T element){
        // Check to see if the array needs to be resized
        if(len + 1 > capacity){
            if(capacity == 0) capacity = 1;
            else capacity *= 2; // Double the size of the arr array
            T[] newArray = (T[]) new Object[capacity];
            System.arraycopy(arr, 0, newArray, 0, len);
            arr = newArray;
        }
        arr[len++] = element;
    }

    public boolean remove(Object obj){
        final int index = indexOf(obj);
        if(index < 0) return false;
        removeAt(index);
        return true;
    }

    public T removeAt(int removeIndex ){
        validateIndex(removeIndex);
        T data = arr[removeIndex];
        T[] newArray = (T[]) new Object[len - 1];
        for(int i = 0, j = 0; i < len; i++, j++){
            if(i == removeIndex) j--; // decrement the value of j
            else newArray[j] = arr[i];
        }
        arr = newArray;
        capacity = --len;
        return data;
    }

    public int indexOf(Object obj){
        for(int i = 0; i < len; i++){
            if(obj == null){
                if(arr[i] == null) return i;
            }
            else if(obj.equals(arr[i])){
                return i;
            }
        }
        return -1;
    }

    private void validateIndex(int index){
        if(index < 0 || index > capacity) throw new IndexOutOfBoundsException();
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
        if(len == 0) return "[]";

        StringBuilder sb = new StringBuilder(len).append("[");
        for(int i = 0; i < len - 1; i++){
            sb.append(arr[i]).append(", ");
        }
        return sb.append(arr[len - 1]).append("]").toString();
    }
}
