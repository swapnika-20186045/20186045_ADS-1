import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for noofpairs.
 */
class Noofpairs {
    /**
     * array declaration.
     */
    int[] array;
    /**
     * size declaration.
     */
    int size;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     * @param      n     { parameter_description }
     */
    Noofpairs(final int[] arr, final int n) {
        this.array = arr;
        this.size = n;
    }
    /**
     * to check pairs.
     *
     * @param      array  The array
     * @param      n      { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public int pairs(final int[] array, final int n) {
        Arrays.sort(array);
        int count = 1;
        int temp = 0;
        for (int i = 1; i < n; i++) {
            if (array[i] == array[i - 1]) {
                count++;
            } else {
                temp = temp + count * (count - 1) / 2;
                count = 1;
            }
        }
        temp = temp + count * (count - 1) / 2;
        return temp;
    }
}
/**
 * Class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    Solution() {
        //not used
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
        for (int i = 0; i < n; i++) {
            array[i] = scan.nextInt();
        }
        Noofpairs num = new Noofpairs(array, n);
        System.out.println(num.pairs(array, n));
    }
}