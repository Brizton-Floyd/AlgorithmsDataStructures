import datastructures.practiceimplementations.DynamicAutoResizingArray;
import datastructures.practiceimplementations.interfaces.DynamicArray;

public class App {

    public static void main(String[] args) {

        DynamicArray<Integer> integerDynamicArray = new DynamicAutoResizingArray<>();
        integerDynamicArray.add(99);
        integerDynamicArray.add(89);
        integerDynamicArray.add(29);
        integerDynamicArray.add(34);
        integerDynamicArray.set(3, 33);

        System.out.println(integerDynamicArray);

        integerDynamicArray.removeAt(0);
        System.out.println(integerDynamicArray);
        System.out.println(integerDynamicArray.size());
        System.out.println(integerDynamicArray.contains(33));
        System.out.println(integerDynamicArray.contains(55));
        System.out.println(integerDynamicArray.indexOf(33));
        System.out.println(integerDynamicArray.get(0));
        integerDynamicArray.removeAt(1);
        System.out.println(integerDynamicArray);
        System.out.println(integerDynamicArray.size());

        // Print out the values
        for (Integer integer : integerDynamicArray) {
            System.out.println(integer);
        }

    }
}
