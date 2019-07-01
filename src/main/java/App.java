import searchalgorithms.BinarySearch;
import sortalgorithms.InsertionSort;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {

        BinarySearch bs = new BinarySearch();
        int[] values = {1, 3, 5, 6, 7, 8, 9, 10, 33, 42, 74};
        int index = bs.searchRecursive(values, 0, values.length - 1, 1);
        System.out.println("The index is : " + index);

        InsertionSort is = new InsertionSort();
        int[] arrayToBeSorted = new int[]{5, 2, 5, 98, 3, 0};
        is.insertionSort(arrayToBeSorted);
        System.out.println(Arrays.toString(arrayToBeSorted));

        System.out.println(buddyStrings("aaaaaaabc", "aaaaaaacb"));
    }

    public static boolean buddyStrings(String A, String B) {
        if(A.isEmpty() || B.isEmpty())
            return false;

        StringBuilder sb = new StringBuilder(A);
        for(int i = 0; i < sb.toString().length()-1; i++){
            char tempChar = sb.charAt(i + 1);
            sb.setCharAt(i+1, sb.charAt(i));
            sb.setCharAt(i, tempChar);
            if(sb.toString().equals(B)){
                return true;
            } else {
                tempChar = sb.charAt(i);
                sb.setCharAt(i, sb.charAt(i+1));
                sb.setCharAt(i+1, tempChar);
            }
        }
        return false;
    }
}
