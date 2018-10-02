/**
 * Insertion sort.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for tournament.
 */
class Tournament implements Comparable<Tournament> {
    /**
     * declaration of teamname.
     */
    private String teamname;
    /**
     * declaration of wins.
     */
    private int wins;
    /**
     * declaration of losses.
     */
    private int losses;
    /**
     * declaration of draws.
     */
    private int draws;
    /**
     * Constructs the object.
     *
     * @param      teamnamee    The teamname
     * @param      winss    The wins
     * @param      lossess  The losses
     * @param      drawss   The draws
     */
    Tournament(final String teamnamee, final int winss,
                      final int lossess, final int drawss) {
        this.teamname = teamnamee;
        this.wins = winss;
        this.losses = lossess;
        this.draws = drawss;
    }
    /**
     * Gets the teamname.
     *
     * @return     The teamname.
     */
    public String getTeamName() {
        return teamname;
    }
    /**
     * Gets the wins.
     *
     * @return     The wins.
     */
    public int getWins() {
        return wins;
    }
    /**
     * Gets the losses.
     *
     * @return     The losses.
     */
    public int getLosses() {
        return losses;
    }
    /**
     * Gets the draws.
     *
     * @return     The draws.
     */
    public int getDraws() {
        return draws;
    }
    /**
     * compares the wins, losses and draws.
     *
     *order of time complexity is constant.
     *
     * @param      object  The object
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Tournament that) {
        // Tournament that = (Tournament) object;
        if (this.getWins() > that.getWins()) {
            return 1;
        } else if (this.getWins() < that.getWins()) {
            return -1;
        }
        if (this.getLosses() > that.getLosses()) {
            return -1;
        } else if (this.getLosses() < that.getLosses()) {
            return 1;
        }
        if (this.getDraws() > that.getDraws()) {
            return 1;
        } else if (this.getDraws() < that.getDraws()) {
            return -1;
        }
        return 0;
    }
}
/**
 * Class for insertion.
 */
class Insertion {
    /**
    *@variable TEN
    **/
    private static final int TEN = 10;
    /**
     * declaration of array of tournaments.
     */
    private Tournament[] tournaments;
    /**
     * declaration of size.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Insertion() {
        tournaments = new Tournament[TEN];
        size = 0;
    }
    /**
     * Adds a tournament.
     *
     * @param      t     { parameter_description }
     */
    public void addTournament(final Tournament t) {
        tournaments[size++] = t;
    }
    /**
     * sort the teams.
     * order of time complexity is N^2.
     */
    public void sort() {
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (tournaments[j].compareTo(tournaments[j - 1]) == 1) {
                    exchange(tournaments, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }
    /**
     * swaps the teams in sorting order.
     *
     * @param      arr     { parameter_description }
     * @param      i     { parameter_description }
     * @param      j     { parameter_description }
     */
    public void exchange(final Tournament[] arr, final int i, final int j) {
        Tournament temp = tournaments[i];
        tournaments[i] = tournaments[j];
        tournaments[j] = temp;
    }
    /**
     * Returns a string representation of the object.
     *
     *order of time complexity is N.
     * @return     String representation of the object.
     */
    public String toString() {
        String str = "";
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            str += tournaments[i].getTeamName() + ",";
        }
        str += tournaments[i].getTeamName();
        return str;
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
    /**
     * Client program.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        Insertion list = new Insertion();
        while (scan.hasNext()) {
            String[] s = scan.nextLine().split(",");
            list.addTournament(new Tournament(s[0],
                Integer.parseInt(s[1]), Integer.parseInt(s[2]),
                Integer.parseInt(s[2 + 1])));
        }
        list.sort();
        System.out.println(list);
    }
}
