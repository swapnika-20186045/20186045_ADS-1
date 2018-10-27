/**
 * Student Data.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for student data.
 */
class StudentData implements Comparable<StudentData> {
    /**
     * declaration of variable.
     */
    private String name;
    /**
     * declaration of variable.
     */
    private double total;
    /**
     * declaration of variable.
     */
    private int rollno;
    /**
     * Constructs the object.
     *
     * @param      namee   The namee
     * @param      totall  The totall
     * @param      rollnoo The rollnoo
     */
    StudentData(final String namee, final String totall, final String rollnoo) {
        this.name  = namee;
        this.total = Double.parseDouble(totall);
        this.rollno = Integer.parseInt(rollnoo);
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
    /**
     * Gets the roll no.
     *
     * @return     The roll no.
     */
    public int getRollNo() {
        return rollno;
    }
    /**
     * compare To.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final StudentData that) {
        if (this.total > that.total) {
            return 1;
        }
        if (this.total < that.total) {
            return -1;
        }
        if (this.name.compareTo(that.name) > 0) {
            return 1;
        }
        if (this.name.compareTo(that.name) < 0) {
            return -1;
        }
        if (this.rollno > that.rollno) {
            return 1;
        }
        if (this.rollno < that.rollno) {
            return -1;
        }
        return 0;
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
        RedBlackBST<StudentData, Integer> student = new RedBlackBST<>();
        StudentData s = null;
        while (input > 0) {
            String[] num = scan.nextLine().split(",");
            s = new StudentData(num[1], num[2], num[0]);
            student.put(s, Integer.parseInt(num[0]));
            input--;
        }
        int testcases = Integer.parseInt(scan.nextLine());
        while (testcases > 0) {
            String[] tokens = scan.nextLine().split(" ");
            if (tokens[0].equals("BE")) {
                //int key = Integer.parseInt(tokens[1]);
                double less = Double.parseDouble(tokens[1]);
                double greater = Double.parseDouble(tokens[2]);
                for (StudentData each : student.keys()) {
                    if (each.getTotal() >= less && each.getTotal() <= greater) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("LE")) {
                double value = Double.parseDouble(tokens[1]);
                for (StudentData each : student.keys()) {
                    if (each.getTotal() <= value) {
                        System.out.println(each.getName());
                    }
                }
            } else if (tokens[0].equals("GE")) {
                double value = Double.parseDouble(tokens[1]);
                for (StudentData each : student.keys()) {
                    if (each.getTotal() >= value) {
                        System.out.println(each.getName());
                    }
                }
            }
            testcases--;
        }
    }
}
