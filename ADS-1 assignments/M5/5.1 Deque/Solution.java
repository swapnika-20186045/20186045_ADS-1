/**
 * Deque.
 */
import java.util.Scanner;
/**
 * Class for solution.
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
        Scanner sc = new Scanner(System.in);
        Queue q = new Queue();
        int n = Integer.parseInt(sc.nextLine());
        while (sc.hasNext()) {
            String[] input = sc.nextLine().split(" ");
            switch (input[0]) {
                case "pushLeft":
                q.addfront(Integer.parseInt(input[1]));
                System.out.println(q.print());
                break;
                case "pushRight":
                q.addend(Integer.parseInt(input[1]));
                System.out.println(q.print());
                break;
                case "popLeft":
                if (!q.isEmpty()) {
                    q.removefront();
                    System.out.println(q.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
                case "popRight":
                if (!q.isEmpty()) {
                    q.removeend();
                    System.out.println(q.print());
                } else {
                    System.out.println("Deck is empty");
                }
                break;
                case "size":
                System.out.println(q.size());
                break;
                default:
                break;
            }
        }
    }
}
