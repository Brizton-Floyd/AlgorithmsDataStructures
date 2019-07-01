package sortalgorithms;

public class InsertionSort {

    public void insertionSort(int[] values){

        for(int i = 1; i < values.length; i++){

            int value = values[i];
            int j = i;
            while( j > 0 && values[j - 1] > value){
                values[j] = values[j - 1];
                j--;
            }

            values[j] = value;
        }
    }
}
