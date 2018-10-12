/**
 * Taxi Cab Numbers.
 */
import java.util.Scanner;
/**
 * Class for cube sum.
 */
class CubeSum implements Comparable<CubeSum> {
    /**
     * declaration of variable.
     */
    public final int sum;
    /**
     * declaration of variable.
     */
    public final int i;
    /**
     * declaration of variable.
     */
    public final int j;
    /**
     * Constructs the object.
     *
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    CubeSum(final int i, final int j) {
        this.sum = i * i * i + j * j * j;
        this.i = i;
        this.j = j;
    }
    /**
     * compare to.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final CubeSum that) {
        if (this.sum < that.sum) {
            return -1;
        }
        if (this.sum > that.sum) {
            return +1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return sum + " = " + i + "^3" + " + " + j + "^3";
    }
}
/**
 * class for Solution.
 */
public final class Solution {
    /**
     * declaration of number.
     */
    private static final int SIXHUNDRED = 600;
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
        int n = SIXHUNDRED;
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int num1 = scan.nextInt();
        int count = 0;
        int temp = 1;
        // initialize priority queue
        MinPQ<CubeSum> pq = new MinPQ<CubeSum>();
        for (int i = 0; i <= n; i++) {
            pq.insert(new CubeSum(i, i));
        }
        // find smallest sum, print it out, and update
        while (!pq.isEmpty()) {
            CubeSum s = pq.delMin();
            if (temp == s.sum) {
                count++;
            } else {
                count = 0;
            }
            if (count == num1 - 1) {
                num--;
                if (num == 0) {
                    System.out.println(s.sum);
                    break;
                }
            }
            temp = s.sum;
            if (s.j < n) {
                pq.insert(new CubeSum(s.i, s.j + 1));
            }
        }
    }

}
