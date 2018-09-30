/**
 * Josephus problem.
 */
import java.util.Scanner;
/**
 * Class for Solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //Empty constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            Queue q = new Queue();
            String str = "";
            for (int i = 0; i < m; i++) {
                q.enqueue(i);
            }

            while (!q.isEmpty()) {
                for (int j = 0; j < n - 1; j++) {
                    q.enqueue(q.dequeue());
                }
                str += q.dequeue() + " ";
            }
            System.out.println(str.substring(0, str.length() - 1));
        }
    }
}
