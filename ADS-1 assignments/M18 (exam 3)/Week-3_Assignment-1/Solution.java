/**
 * Stock analysis.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * class for Solution.
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
        while (n > 0) {
            int hrs = 6;
            while (hrs > 0) {
                String[] tokens = scan.nextLine().split(",");
                // System.out.println(tokens[1]);
                hrs--;
            }
            // System.out.println();
            n--;
        }
    }
}
