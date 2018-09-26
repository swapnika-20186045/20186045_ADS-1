import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
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
        Scanner input = new Scanner(System.in);
        // Sortedarray s = new Sortedarray();
        int n1 = Integer.parseInt(input.nextLine());
        int n2 = Integer.parseInt(input.nextLine());
        String[] array1temp = input.nextLine().split(",");
        String[] array2temp = input.nextLine().split(",");
        ArrayList<Integer> array = new ArrayList<>();
        int[] array1 = new int[n1];
        int[] array2 = new int[n2];
        // for (int i = 0; i < n1; i++) {
        //  array1[i] = Integer.parseInt(array1temp[i]);
        // }
        // for (int i = 0; i < n2; i++) {
        //  array2[i] = Integer.parseInt(array2temp[i]);
        // }
        // int[] array = new int[n1 + n2];
        for (int i = 0; i < n1; i++) {
            array.add(Integer.parseInt(array1temp[i]));
        }
        for (int i = 0; i < n2; i++) {
            array.add(Integer.parseInt(array2temp[i]));
        }
        // System.out.println(s.sortedArray(array1, array2));
        Collections.sort(array);
        System.out.println(array.toString().
            substring(1, array.toString().length() - 1).replace(" ", ""));
    }
}

