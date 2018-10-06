/**
 * Student reservations.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for reservation.
 */
class Studentinfo implements Comparable<Studentinfo> {
    private String studentname;
    private String dob;
    private int sub1;
    private int sub2;
    private int sub3;
    private int total;
    private String reservation;

    Studentinfo(final String studentnamee, final String dobb,
        final int sub1s, final int sub2s, final int sub3s,
        final int totals, final String reservationn) {
        this.studentname = studentnamee;
        this.dob = dobb;
        this.sub1 = sub1s;
        this.sub2 = sub2s;
        this.sub3 = sub3s;
        this.total = totals;
        this.reservation = reservationn;
    }
    public String[] sepdob() {
        String[] sepdob = dob.split("-");
        return sepdob;
    }

    public String getStudentName() {
        return studentname;
    }
    // public String getDob() {
    //     return dob;
    // }
    public int getSub1() {
        return sub1;
    }
    public int getSub2() {
        return sub2;
    }
    public int getSub3() {
        return sub3;
    }
    public int getTotal() {
        return total;
    }
    public String getReservation() {
        return reservation;
    }

    public int compareTo(final Studentinfo that) {
        if (this.getTotal() > that.getTotal()) {
            return 1;
        }
        if (this.getTotal() < that.getTotal()) {
            return -1;
        }
        if (this.getSub3() > that.getSub3()) {
            return 1;
        }
        if (this.getSub3() < that.getSub3()) {
            return -1;
        }
        if (this.getSub2() > that.getSub2()) {
            return 1;
        }
        if (this.getSub2() < that.getSub2()) {
            return -1;
        }
        if (Integer.parseInt(this.sepdob()[2]) > Integer.parseInt(that.sepdob()[2])) {
            return 1;
        }
        if (Integer.parseInt(this.sepdob()[2]) < Integer.parseInt(that.sepdob()[2])) {
            return -1;
        }
        if (Integer.parseInt(this.sepdob()[1]) > Integer.parseInt(that.sepdob()[1])) {
            return 1;
        }
        if (Integer.parseInt(this.sepdob()[1]) < Integer.parseInt(that.sepdob()[1])) {
            return -1;
        }
        if (Integer.parseInt(this.sepdob()[0]) > Integer.parseInt(that.sepdob()[0])) {
            return 1;
        }
        if (Integer.parseInt(this.sepdob()[0]) < Integer.parseInt(that.sepdob()[0])) {
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
        //empty constructor
    }
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int qualifiedstudents = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int unreserved = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        while (scan.hasNext()) {
            String[] tokens = scan.nextLine().split(",");
            // System.out.println(Arrays.toString(tokens));
        }
    }
}