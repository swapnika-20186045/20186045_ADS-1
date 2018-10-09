/**
 * Student reservation system.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for Studentinfo.
 */
class Studentinfo {
    /**
     * name.
     */
    private String name;
    /**
     * dob.
     */
    private String dob;
    /**
     * sub1.
     */
    private int subject1;
    /**
     * sub2.
     */
    private int subject2;
    /**
     * sub3.
     */
    private int subject3;
    /**
     * total.
     */
    private int total;
    /**
     * category.
     */
    private String category;
    /**
     * Constructs the object.
     *
     * @param      n     { parameter_description }
     * @param      d     { parameter_description }
     * @param      s1    The s 1
     * @param      s2    The s 2
     * @param      s3    The s 3
     * @param      t     { parameter_description }
     * @param      rc    The rectangle
     */
    Studentinfo(final String n, final String d, final int s1,
            final int s2, final int s3, final int t, final String rc) {
        this.name = n;
        this.dob = d;
        this.subject1 = s1;
        this.subject2 = s2;
        this.subject3 = s3;
        this.total = t;
        this.category = rc;
    }
    /**
     * get name.
     *
     *Best case: O(1)
     *  worst case: O(1)
     *  Average case: O(1)
     * @return     { description_of_the_return_value }
     */
    public String getname() {
        return this.name;
    }
    /**
     * get dob.
     * time of complexity is O(1)
     *
     * @return     { description_of_the_return_value }
     */
    public String getdob() {
        return this.dob;
    }
    /**
     * get sub1.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    int getsubject1() {
        return this.subject1;
    }
    /**
     * get sub2.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    int getsubject2() {
        return this.subject2;
    }
    /**
     * get sub3.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    int getsubject3() {
        return this.subject3;
    }
    /**
     * total.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    int gettotal() {
        return this.total;
    }
    /**
     * get category.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    String getcategory() {
        return this.category;
    }
    /**
     * get age.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    int getage() {
    int age = 0;
    final int year = 2018, days = 365, month = 30, ten = 10;
    String[] token = this.getdob().split("-");
    age += (year - Integer.parseInt(token[2])) * days;
    age += (ten - Integer.parseInt(token[1])) * month;
    age += Integer.parseInt(token[0]);

    return age;
    }
    /**
     * compare.
     * time of complexity is O(1)
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Studentinfo that) {
        if (this.gettotal() > that.gettotal()) {
            return 1;
        } else if (this.gettotal() < that.gettotal()) {
            return -1;
        } else {
            if (this.getsubject3() > that.getsubject3()) {
                return 1;
            } else if (this.getsubject3() < that.getsubject3()) {
                return -1;
            } else {
                if (this.getsubject2() > that.getsubject2()) {
                    return 1;
                } else if (this.getsubject2() < that.getsubject2()) {
                    return -1;
                } else {
                    if (this.getage() < that.getage()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        }
    }
    /**
     * prints.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    public String print() {
        return this.getname() + "," + this.gettotal() + ","
               + this.getcategory();
    }
}
/**
 * Class for heapsort.
 */
class Heapsort {
    /**
     * array.
     */
    private Studentinfo[] array;
    /**
     * size.
     */
    private int size;
    /**
     * Constructs the object.
     *
     * @param      a     { parameter_description }
     * @param      n     { parameter_description }
     */
    Heapsort(final Studentinfo[] a, final int n) {
        array = a;
        size = n;
    }
    /**
     * sorts.
     * time of complexity is O(N)
     * @return     { description_of_the_return_value }
     */
    public Studentinfo[] sort() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapify(size, i);
        }
        for (int i = size - 1; i >= 0; i--) {
            swap(0, i);
            heapify(i, 0);
        }
        return array;
    }
    /**
     * swaps.
     * time of complexity is O(1)
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void swap(final int i, final int j) {
        Studentinfo temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * heapifies.
     * time of complexity is O(NlogN)
     * @param      n     { parameter_description }
     * @param      i     { parameter_description }
     */
    public void heapify(final int n, final int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        if (l < n && array[l].compareTo(array[largest]) < 0) {
            largest = l;
        }
        if (r < n && array[r].compareTo(array[largest]) < 0) {
            largest = r;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(n, largest);
        }
    }
    /**
     * gets item.
     * time of complexity is O(1)
     * @param      index  The index
     *
     * @return     { description_of_the_return_value }
     */
    public Studentinfo getitem(final int index) {
        return array[index];
    }
    /**
     * get size.
     * time of complexity is O(1)
     * @return     { description_of_the_return_value }
     */
    public int getsize() {
        return size;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    /**
     * Constructs the object.
     */
    private Solution() {
        ///function.
    }
    /**
     * contains.
     *
     * @param      arr   The arr
     * @param      val   The value
     * time of complexity is O(N)
     * @return     { description_of_the_return_value }
     */
    public static boolean contains(final int[] arr, final int val) {
        for (int n : arr) {
            if (val == n) {
                return true;
            }
        }
        return false;
    }

    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int open = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        Studentinfo[] students = new Studentinfo[n];
        for (int i = 0; i < n; i++) {
            String[] input = scan.nextLine().split(",");
            students[i] = new Studentinfo(input[0], input[1],
            Integer.parseInt(input[2]),
                    Integer.parseInt(input[2 + 1]),
                    Integer.parseInt(input[FOUR]),
                    Integer.parseInt(input[FIVE]), input[SIX]);
        }
        Heapsort heap = new Heapsort(students, n);
        students = heap.sort();
        for (int i = 0; i < n; i++) {
            System.out.println(students[i].print());
        }
        System.out.println();
        for (int j = 0; j < open; j++) {
            System.out.println(students[j].print());
        }
        int[] indices = new int[bc + sc + st];
        int i = 0;
        for (int k = open; k < n; k++) {
            if (students[k].getcategory().equals("BC") && bc > 0) {
                indices[i++] = k;
                bc--;
            } else if (students[k].getcategory().
                       equals("SC") && sc > 0) {
                indices[i++] = k;
                sc--;
            } else if (students[k].getcategory().
                       equals("ST") && st > 0) {
                indices[i++] = k;
                st--;
            }
        }
        if (bc > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getcategory().equals("Open") && bc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        bc--;
                    }
                }
            }
        }
        if (sc > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getcategory().equals("Open") && sc > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        sc--;
                    }
                }
            }
        }
        if (st > 0) {
            for (int k = open; k < n; k++) {
                if (students[k].getcategory().equals("Open") && st > 0) {
                    if (!contains(indices, k)) {
                        indices[i++] = k;
                        st--;
                    }
                }
            }
        }
        Arrays.sort(indices);
        for (int k = 0; k < indices.length; k++) {
            System.out.println(students[indices[k]].print());
        }
    }
}
