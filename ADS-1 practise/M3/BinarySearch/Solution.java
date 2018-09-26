/**
 * Binary Search.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for binary search.
 */
class BinarySearch {
    /**
     * binary search method.
     *
     * @param      array  The array
     * @param      key      integer
     *
     * @return result
     */
    public int binarySearch(final int[] array, final int key) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

/**
 * class for Solution.
 */
public final class Solution {
    private Solution() {
        //not used
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        BinarySearch bs = new BinarySearch();
        System.out.println(bs.binarySearch(array, key));
    }
}