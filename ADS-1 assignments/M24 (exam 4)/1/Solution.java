/**
 * Student Data.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for student data.
 */
class StudentData {
    /**
     * declaration of variable.
     */
    private String name;
    /**
     * declaration of variable.
     */
    private double total;
    /**
     * Constructs the object.
     *
     * @param      namee   The namee
     * @param      totall  The totall
     */
    StudentData(final String namee, final String totall) {
        this.name  = namee;
        this.total = Double.parseDouble(totall);
    }
    /**
     * Gets the name.
     *
     * @return     The name.
     */
    public String getName() {
        return name;
    }
    /**
     * Gets the total.
     *
     * @return     The total.
     */
    public double getTotal() {
        return total;
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
        int input = Integer.parseInt(scan.nextLine());
        SeparateChainingHashST<Integer, StudentData> student = new
        SeparateChainingHashST<>();
        StudentData s = null;
        while (input > 0) {
            String[] num = scan.nextLine().split(",");
            s = new StudentData(num[1], num[2]);
            student.put(Integer.parseInt(num[0]), s);
            input--;
        }
        int testcases = Integer.parseInt(scan.nextLine());
        while (testcases > 0) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[2].equals("1")) {
                int key = Integer.parseInt(tokens[1]);
                if (student.contains(key)) {
                    System.out.println(student.get(key).getName());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            } else if (tokens[2].equals("2")) {
                int key = Integer.parseInt(tokens[1]);
                if (student.contains(key)) {
                    System.out.println(student.get(key).getTotal());
                } else {
                    System.out.println("Student doesn't exists...");
                }
            }
            testcases--;
        }
    }
}

