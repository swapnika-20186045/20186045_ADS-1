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
        BinarySearchST<String,Double> sixhrs = new BinarySearchST<>();
        while (n > 0) {
            String[] tokens = scan.nextLine().split(","); 
            sixhrs.put(tokens[0],Double.parseDouble(tokens[1]));
            System.out.println(sixhrs);
            n--;
        }
    }
}
