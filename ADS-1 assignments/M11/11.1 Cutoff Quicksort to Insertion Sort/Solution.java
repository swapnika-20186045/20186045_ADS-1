/**
 * Quicksort to insertion sort.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for quick sort.
 */
class QuickSort {
    /**
     * Constructs the object.
     */
    QuickSort() {
        //empty Constructor.
    }
    /**
     * insertion sort.
     * Order of time complexity of this method is N^2.
     * @param      a     {Comparable array}
     * @param      lo    The lower
     * @param      hi    The higher
     */
    public void insertionSort(final Comparable[] a, final int lo, final int hi) {
        for (int i = 0; i <= hi; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1]); j--) {
                exchange(a, j, j - 1);
            }
        }
    }
    /**
     * To swap two elements.
     * order of time complexity of this method is N.
     * @param      a     {Comparable array}
     * @param      i     {Integer}
     * @param      j     {Integer}
     */
    public void exchange(final Comparable[] a, final int i, final int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    /**
     * To print all the elements in the array.
     * order of time complexity of this method is N.
     * @param      a     {Comparable array}
     *
     * @return     {String}
     */
    public String print(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
    }
    /**
     * sort.
     * order of time complexity of this method is log(N).
     * @param      a     {Comparable}
     * @param      lo    The lower
     * @param      hi    The higher
     * @param      cutoff   The cutoff
     */
    public void sort(final Comparable[] a, final int lo,
        final int hi, final int cutoff) {
        if (hi <= lo + cutoff - 1) {
            insertionSort(a, lo, hi);
            System.out.println("insertionSort called");
            return;
        }
        int k = partition(a, lo, hi);
        System.out.println(print(a));
        sort(a, lo, k - 1, cutoff);
        sort(a, k + 1, hi, cutoff);
    }
    /**
     * sort.
     * order of time complexity of this method is 1.
     * @param      a       { parameter_description }
     * @param      cutoff  The cutoff
     */
    public void sort(final Comparable[] a, final int cutoff) {
        sort(a, 0, a.length - 1, cutoff);
        System.out.println(print(a));
    }
    /**
     * partition.
     * order of time complexity of this method is N.
     * @param      a     { parameter_description }
     * @param      lo    The lower
     * @param      hi    The higher
     *
     * @return     { description_of_the_return_value }
     */
    public int partition(final Comparable[] a, final int lo, final int hi) {
        int i = lo;
        int j = hi + 1;
        while (true) {
            while (less(a[++i], a[lo])) {
                if (i == hi) {
                    break;
                }
            }
            while (less(a[lo], a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }
        exchange(a, lo, j);
        return j;
    }
    /**
     * To find the less value among two values.
     * order of time complexity of this method is 1.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
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
        //empty constructor.
    }
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        QuickSort qs = new QuickSort();
        for (int i = 0; i < n; i++) {
            int n1 = Integer.parseInt(scan.nextLine());
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("")) {
                System.out.println("[]");
            } else {
                qs.sort(tokens, n1);
            }
        }
    }
}
