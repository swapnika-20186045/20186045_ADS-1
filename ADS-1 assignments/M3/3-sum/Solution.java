/**
 * three sum.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for three sum.
 */
class ThreeSum {
    /**
     * array declaration.
     */
    private int[] array;
    /**
     * Constructs the object.
     *
     * @param      arrayy   The arrayy
     */
    ThreeSum(final int[] arrayy) {
        this.array = arrayy;
    }
    /**
     * to find sum of three elements.
     *
     * @param      array1  The array
     *
     * @return     { description_of_the_return_value }
     */
    public int threeSum(final int[] array1) {
        BinarySearch bs = new BinarySearch();
        Arrays.sort(array1);
        int count = 0;
        for (int i = 0; i < array1.length; i++) {
            for (int j = i + 1; j < array1.length; j++) {
                int result = bs.binarySearch(array1, -(array1[i] + array1[j]));
                if (result > j) {
                    count++;
                }
            }
        }
        return count;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {

    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] array = new int[n];
        ThreeSum sum = new ThreeSum(array);
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        System.out.println(sum.threeSum(array));
    }
}
