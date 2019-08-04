package datastructures.practiceimplementations.array;

import java.util.Arrays;

@SuppressWarnings("unchecked")
public class SingleDimensionArray<T> {

    private T[] arr;

    public SingleDimensionArray(int size){
        if (size < 0) throw new IllegalArgumentException("Illegal Argument: " + size);
        arr = (T[]) new Object[size];
    }

    public int size(){
        try {
            return arr.length;
        }
        catch (NullPointerException e){
            System.out.println("The array does not exist");
        }
        return -1;
    }
    public void insert(int location, T element){
        try{
            arr[location] = element;
        }
        catch (NullPointerException | IndexOutOfBoundsException e){
            if(e instanceof IndexOutOfBoundsException){
                System.out.println("Error: Provided index " + location + " does not exist");
            } else {
                System.out.println("The array does not exist");
            }
        }
    }

    public int search(Object obj){
        try{
            for(int i = 0; i < arr.length; i++){
                if(obj.equals(arr[i])) return i;
            }
        }
        catch(NullPointerException e){
            System.out.println("The array does not exist");
        }
        return -1;
    }

    public boolean delete(Object obj){
        final int index = search(obj);
        if(index < 0) throw new UnsupportedOperationException("Object does not exist in array");
        arr[index] = null;
        return true;
    }

    public void deleteArray(){
        arr = null;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder("[");
        for(int i = 0; i < arr.length-1; i++){
            sb.append(arr[i]).append(", ");
        }
        return sb.append(arr[size()-1]).append("]").toString();
    }
}
