package searchalgorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void testIndexOfNumberIterative() {
        int[] a = new int[]{1, 2, 3, 6, 7, 8, 10, 12, 34, 45, 65};
        int key = 8;
        assertEquals(5, searchIterative(a, key));
    }

    @Test
    public void testIndexOfNumberDoesNotExistIterative() {
        int[] a = new int[]{1, 2, 3, 6, 7, 8, 10, 12, 34, 45, 65};
        int key = 100;
        assertEquals(-1, searchIterative(a, key));
    }

    @Test
    public void testIndexOfNumberRecursively() {
        int[] a = new int[]{1, 2, 3, 6, 7, 8, 10, 12, 34, 45, 65};
        int key = 8;
        assertEquals(5, searchRecursively(a, 0, a.length - 1, key));
    }

    @Test
    public void testIndexOfNumberDoesNotExistRecursively() {
        int[] a = new int[]{1, 2, 3, 6, 7, 8, 10, 12, 34, 45, 65};
        int key = 100;
        assertEquals(-1, searchRecursively(a, 0, a.length - 1, key));
    }

    private int searchRecursively(int[] a, int left, int right, int key) {

        if (left > right) {
            return -1;
        }

        int mid = (left + right) / 2;
        if(a[mid] == key) {
            return mid;
        }
        else if( a[mid] > key){
            return searchRecursively(a, left, mid - 1, key);
        } else {
            return searchRecursively(a, mid + 1, right, key);
        }
    }

    private int searchIterative(int[] a, int key) {
        int left = 0, right = a.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (a[mid] == key) {
                return mid;
            } else if (a[mid] > key) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
