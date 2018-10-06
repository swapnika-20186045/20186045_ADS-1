/**
 * Student reservations.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
// import java.util.Arrays;
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
        if (Integer.parseInt(this.sepdob()[2]) > Integer.parseInt(
                    that.sepdob()[2])) {
            return 1;
        }
        if (Integer.parseInt(this.sepdob()[2]) < Integer.parseInt(
                    that.sepdob()[2])) {
            return -1;
        }
        if (Integer.parseInt(this.sepdob()[1]) > Integer.parseInt(
                    that.sepdob()[1])) {
            return 1;
        }
        if (Integer.parseInt(this.sepdob()[1]) < Integer.parseInt(
                    that.sepdob()[1])) {
            return -1;
        }
        if (Integer.parseInt(this.sepdob()[0]) > Integer.parseInt(
                    that.sepdob()[0])) {
            return 1;
        }
        if (Integer.parseInt(this.sepdob()[0]) < Integer.parseInt(
                    that.sepdob()[0])) {
            return -1;
        }
        return 0;
    }
}
class Insertion {
    private Studentinfo[] students;
    private int size;
    Insertion() {
        students = new Studentinfo[100];
        size = 0;
    }
    public boolean less(final Studentinfo a, final Studentinfo b) {
        return a.compareTo(b) < 0;
    }
    public void sort(final Studentinfo[] students) {
        for (int i = 1; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (less(students[j - 1], students[j])) {
                    exchange(students, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
    public void exchange(final Studentinfo[] arr, final int i, final int j) {
        Studentinfo temp = students[i];
        students[i] = students[j];
        students[j] = temp;
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
        int n = Integer.parseInt(scan.nextLine());
        Studentinfo[] students = new Studentinfo[n];
        // int qualifiedstudents = Integer.parseInt(scan.nextLine());
        int vacancies = Integer.parseInt(scan.nextLine());
        int unreserved = Integer.parseInt(scan.nextLine());
        int bc = Integer.parseInt(scan.nextLine());
        int sc = Integer.parseInt(scan.nextLine());
        int st = Integer.parseInt(scan.nextLine());
        // while (scan.hasNext()) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scan.nextLine().split(",");
            // System.out.println(Arrays.toString(tokens));
            Studentinfo sd = new Studentinfo(tokens[0], tokens[1],
                    Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                    Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]), tokens[6]);
            students[i] = sd;
        }
        Insertion ins = new Insertion();
        ins.sort(students);
        System.out.println(students);
        print(students);
        System.out.println();
        Fillmerit(students, vacancies, unreserved, bc, sc, st);
    }
    public static void Fillmerit(Studentinfo[] arr, int vac, int unres, int bcs, int scs, int sts) {
        for (int i = 0; i < arr.length && vac > 0; i++) {
            if (unres > 0) {
                System.out.println(arr[i].getStudentName() + "," + arr[i].getTotal() + "," + arr[i].getReservation());
                unres--;
            } else if (arr[i].getReservation().equals("BC") || arr[i].getReservation().equals("SC") || arr[i].getReservation().equals("ST")) {
                if (arr[i].getReservation().equals("BC") && bcs > 0) {
                    System.out.println(arr[i].getStudentName() + "," + arr[i].getTotal() + "," + arr[i].getReservation());
                    bcs--;
                } else if (arr[i].getReservation().equals("SC") && scs > 0) {
                    System.out.println(arr[i].getStudentName() + "," + arr[i].getTotal() + "," + arr[i].getReservation());
                    scs--;
                } else if (arr[i].getReservation().equals("ST") && sts > 0) {
                    System.out.println(arr[i].getStudentName() + "," + arr[i].getTotal() + "," + arr[i].getReservation());
                    sts--;
                }
            }
        }
        vac--;
    }
    public static void print(final Studentinfo[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].getStudentName() + "," + arr[i].getTotal() + "," + arr[i].getReservation());
        }
    }
}
