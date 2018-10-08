/**
 * check if min heap.
 * @author Swapnika Vakacharla
 */
import java.util.Scanner;
/**
 * Class for minimum heap.
 *
 * @param      <E>   { parameter_description }
 */
class MinHeap<E extends Comparable<E>> {
    /**
     * private declaration of array.
     */
    private E[] array;
    /**
     * Constructs the object.
     *
     * @param      arr   The arr
     */
    MinHeap(final E[] arr) {
        this.array = arr;
    }
    /**
     * Determines if minimum heap.
     * the time complexity is N.
     * @param      arr1  The arr 1.
     *
     * @return     True if minimum heap, False otherwise.
     */
    public boolean isMinHeap(final E[] arr1) {
        for (int i = 0; i < arr1.length - 1; i++) {
            if (!less(arr1[i], arr1[i + 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * less method.
     * time complexity is 1.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final E i, final E j) {
        return i.compareTo(j) <= 0;
    }

}
/**
 * class for solution.
 */
public class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //empty constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        switch (line) {
            case "String":
            int n = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < n; i++) {
                String[] tokens = scan.nextLine().split(",");
                MinHeap<String> min = new MinHeap<String>(tokens);
                System.out.println(min.isMinHeap(tokens));
            }
            break;
            case "Integer":
            int n1 = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < n1; i++) {
                String str = scan.nextLine();
                String[] tokens = str.split(",");
                Integer[] intarr = new Integer[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    intarr[j] = Integer.parseInt(tokens[j]);
                }
            MinHeap<Integer> min = new MinHeap<Integer>(intarr);
                System.out.println(min.isMinHeap(intarr));
            }
            break;
            case "Float":
            int n2 = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < n2; i++) {
                String string = scan.nextLine();
                if (string.equals("")) {
                    System.out.println("false");
                } else {
                String[] tokens = string.split(",");
                Float[]  floarr = new Float[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    floarr[j] = Float.parseFloat(tokens[j]);
                }
                MinHeap<Float> m = new MinHeap<Float>(floarr);
                System.out.println(m.isMinHeap(floarr));
            }
            }
            break;
            case "Double":
            int n3 = Integer.parseInt(scan.nextLine());
            for (int i = 0; i < n3; i++) {
                String st = scan.nextLine();
                String[] tokens = st.split(",");
                Double[]  douarr = new Double[tokens.length];
                for (int j = 0; j < tokens.length; j++) {
                    douarr[j] = Double.parseDouble(tokens[j]);
                }
                MinHeap<Double> m = new MinHeap<Double>(douarr);
                System.out.println(m.isMinHeap(douarr));
            }
            break;
            default:
            break;
        }
    }
}