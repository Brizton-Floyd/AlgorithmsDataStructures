import datastructures.practiceimplementations.array.SingleDimensionArray;

public class App {

    public static void main(String[] args) {

        SingleDimensionArray<Integer> integerSingleDimensionArray = new SingleDimensionArray<>(10);
        integerSingleDimensionArray.insert(0, 99);
        System.out.println(integerSingleDimensionArray);
        integerSingleDimensionArray.insert(0,89);
        integerSingleDimensionArray.delete(100);
        System.out.println(integerSingleDimensionArray);
    }
}
