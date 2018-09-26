/**
 *Sorted array.
 *@author Swapnika Vakacharla.
 */
import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
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
        for (int i = 0; i < n1; i++) {
         array1[i] = Integer.parseInt(array1temp[i]);
        }
        for (int i = 0; i < n2; i++) {
         array2[i] = Integer.parseInt(array2temp[i]);
        }
        // int[] array = new int[n1 + n2];
        // for (int i = 0; i < n1; i++) {
        //     array.add(Integer.parseInt(array1temp[i]));
        // }
        // for (int i = 0; i < n2; i++) {
        //     array.add(Integer.parseInt(array2temp[i]));
        // }
        int i = 0;
        int j = 0;
        while (i < array1.length || j < array2.length) {
            if (i < array1.length && j < array2.length
                && array1[i] < array2[j]) {
                array.add(array1[i]);
                // System.out.println(array1[i]+" 51 "+ i +" "+j);
                i++;
            } else if (i < array1.length && j < array2.length
                && array1[i] >= array2[j]) {
                array.add(array2[j]);
                // System.out.println(array2[j]+" 55 "+ i +" "+j);
                j++;
            } else if (i >= array1.length) {
                while (j < array2.length) {
                    array.add(array2[j]);
                    // System.out.println(array2[j]+" 60 "+ i +" "+j);
                    j++; 
                }
            } else if (j >= array2.length) {
                while (i < array1.length) {
                    array.add(array1[i]);
                    // System.out.println(array1[i]+" 66 "+ i +" "+j);
                    i++;
                }
            }
        }
        // System.out.println(s.sortedArray(array1, array2));
        // Collections.sort(array);
        System.out.println(array.toString().
            substring(1, array.toString().length() - 1).replace(" ", ""));
    }
}

