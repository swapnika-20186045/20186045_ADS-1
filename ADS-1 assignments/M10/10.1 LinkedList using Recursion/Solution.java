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
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
         LinkedList l = new LinkedList();
        while (scan.hasNext()) {
            String[] input = scan.nextLine().split(" ");
            switch (input[0]) {
                case "insertAt":
                try {
                    l.insertAt(Integer.parseInt(input[1]), input[2]);
                    System.out.println(l);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "reverse":
                try {
                    l.reverse();
                    System.out.println(l);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
                default:
                break;
            }
        }
    }
}
