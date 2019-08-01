package datastructures.practiceimplementations.interfaces;

public interface DynamicArray<T> extends Iterable<T>{

    void add(T element);

    void set(int index, T element);

    T removeAt(int removeIndex);

    void clear();

    int size();

    boolean remove(Object obj);

    boolean isEmpty();

    T get(int index);

    int indexOf(Object obj);

    boolean contains(Object obj);

}
