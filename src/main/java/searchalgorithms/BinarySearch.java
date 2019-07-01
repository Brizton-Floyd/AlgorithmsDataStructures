package searchalgorithms;

public class BinarySearch {

    // Find out if the key value exist in the sorted array arr
    // or not using binary search algorithm
    public int searchIterative(int[] arr, int value) {

        // Search space is arr[left...right]
        int left = 0, right = arr.length - 1;

        while (left <= right) {

            // find the mid value in the search space and compare with the search value
            int mid = (left + right) / 2;

            if (value == arr[mid]) {
                return mid;
            }

            // Discard all elements in the right space if value is less than mid element
            if (value < arr[mid]) {
                right = mid - 1;
            }
            // Discard all elements in left space if value is greater the mid element
            else if (value > arr[mid]) {
                left = mid + 1;
            }
        }

        return -1;
    }

    public int searchRecursive(int[] arr, int left, int right, int value) {

        // Base condition (search space exhausted)
        if (left > right) {
            return -1;
        }

        // find the mid value in the search space and compare with the search value
        int mid = (left + right) / 2;
        if(arr[mid] == value) return mid;

        // Discard all elements in the right space if value is less than mid
        if(value < arr[mid]){
            return searchRecursive(arr, left, mid - 1, value);
        } else {
            // Discard all elements in the left space since value is greater than mid
            return searchRecursive(arr, mid + 1, right, value);
        }
    }
}
