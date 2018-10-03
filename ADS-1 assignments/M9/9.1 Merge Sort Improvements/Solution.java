/**
 * Merge sort improvements.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for merge.
 */
class Merge {
    /**
     * declaration for value seven.
     */
    private static final int SEVEN = 7;
    /**
     * Constructs the object.
     */
    Merge() {
        //empty Constructor.
    }
    /**
     * To merge two arrays.
     *
     * @param      array  The array
     * @param      aux    The auxiliary
     * @param      low     The lower value
     * @param      mid    The middle value
     * @param      high     The higher value
     */
    public void merge(final Comparable[] array, final Comparable[] aux,
                      final int low, final int mid, final int high) {
        assert isSorted(array, low, mid);
        assert isSorted(array, mid + 1, high);
        int i = low;
        int j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                aux[k] = array[j++];
            } else if (j > high) {
                aux[k] = array[i++];
            } else if (less(array[j], array[i])) {
                aux[k] = array[j++];
            } else {
                aux[k] = array[i++];
            }
        }
        assert isSorted(aux, low, high);
    }
    /**
     * Sort.
     *
     * @param      array  The array
     * @param      aux    The auxiliary array
     * @param      low     The lowwer value
     * @param      high     The higher value
     */
    public void sort(final Comparable[] array, final Comparable[] aux,
                     final int low, final int high) {
        if (high <= low + SEVEN) {
            insertionSort(aux, low, high);
            System.out.println("Insertion sort method invoked...");
            return;
        }
        int mid = low + (high - low) / 2;
        sort(aux, array, low, mid);
        sort(aux, array, mid + 1, high);
        if (!less(array[mid + 1], array[mid])) {
            for (int i = low; i <= high; i++) {
                aux[i] = array[i];
            }
            System.out.println(
                "Array is already sorted. So, skipped the call to merge...");
            return;
        }
        merge(array, aux, low, mid, high);
    }
    /**
     * Rearranges the array in ascending order, using the natural order.
     *
     * @param      a     {Comparable array}.
     */
    public void sort(final Comparable[] a) {
        Comparable[] aux = a.clone();
        sort(aux, a, 0, a.length - 1);
        assert isSorted(a);
    }
    /**
     * insertion sort.
     * sort from a[low] to a[high].
     * @param      a     {Comparable array}.
     * @param      low    The lowwer value
     * @param      high    The higher value
     */
    public void insertionSort(final Comparable[] a,
                              final int low, final int high) {
        for (int i = low; i <= high; i++) {
            for (int j = i; j > low && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
        }
    }
    /**
     * {Method to exchange two elements in the array}.
     *
     * @param      a     {Array of object}
     * @param      i     {Integer i}
     * @param      j     {Integer j}
     */
    public void exch(final Object[] a,
                     final int i, final int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    /**
     * {Method to check whighch one is smaller of the two}.
     *
     * @param      a     {Comparable}.
     * @param      b     {Comparable}.
     *
     * @return     {Boolean value}.
     */
    public boolean less(final Comparable a, final Comparable b) {
        return a.compareTo(b) < 0;
    }
    /**
     * Method to determine if the array is sorted (or) not.
     *
     * @param      a     {Comparable array}
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }
    /**
     * Method to determine if the array is sorted (or) not.
     *
     * @param      a     {Comparable array}
     * @param      low    The lowwer
     * @param      high    The higher
     *
     * @return     True if sorted, False otherwise.
     */
    public boolean isSorted(final Comparable[] a,
                            final int low, final int high) {
        for (int i = low + 1; i <= high; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
    /**
     * {Method to print the values of the object array}.
     *
     * @param      a     {Name of object array}
     *
     * @return     {String}
     */
    public String show(final Comparable[] a) {
        String str = "[";
        int i;
        for (i = 0; i < a.length - 1; i++) {
            str += a[i] + ", ";
        }
        str += a[i] + "]";
        return str;
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
        //Unused Constructor.
    }
    /**
     * {Client Program}.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Merge m = new Merge();
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            m.sort(tokens);
            System.out.println(m.show(tokens));
            System.out.println();
        }
    }
}
