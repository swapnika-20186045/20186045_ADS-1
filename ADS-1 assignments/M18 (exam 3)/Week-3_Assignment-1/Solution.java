/**
 * Stock analysis.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for stock.
 */
class Stock implements Comparable<Stock> {
    /**
     * name of the stock.
     */
    private String stockname;
    /**
     * change in stock value.
     */
    private Double change;
    /**
     * Constructs the object.
     *
     * @param      stocknamee  The stocknamee
     * @param      changee     The changee
     */
    Stock(final String stocknamee, final Double changee) {
        this.stockname = stocknamee;
        this.change = changee;
    }
    /**
     * Gets the name of the stock.
     *
     * @return     The name.
     */
    public String getStockName() {
        return this.stockname;
    }
    /**
     * Gets the change in stock value.
     *
     * @return     The change.
     */
    public Double getChange() {
        return this.change;
    }
    /**
     * compares two objects.
     *
     * @param      that  The that
     *
     * @return     { description_of_the_return_value }
     */
    public int compareTo(final Stock that) {
        if (this.change > that.change) {
            return 1;
        }
        if (this.change < that.change) {
            return -1;
        }
        if (this.stockname.compareTo(that.stockname) > 0) {
            return 1;
        }
        if (this.stockname.compareTo(that.stockname) < 0) {
            return -1;
        }
        return 0;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        return this.stockname + " " + this.change;
    }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * declaration of number.
     */
    private static int FIVE = 5;
    /**
     * declaration of number.
     */
    private static int SIX = 6;
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
        for (int i = 0; i < SIX; i++) {
            int count = 0;
            MinPQ<Stock> min = new MinPQ<>();
            MaxPQ<Stock> max = new MaxPQ<>();
            while (count < n) {
                String[] tokens = scan.nextLine().split(",");
                Stock stocks = new Stock(tokens[0],
                    Double.parseDouble(tokens[1]));
                min.insert(stocks);
                max.insert(stocks);
                count++;
            }
            BinarySearchST<String, Double> best = new  BinarySearchST<>();
            BinarySearchST<String, Double> worst = new BinarySearchST<>();
            for (int j = 0; j < FIVE; j++) {
                Stock maxbest = max.delMax();
                System.out.println(maxbest);
                best.put(maxbest.getStockName(), maxbest.getChange());
            }
            System.out.println();
            for (int k = 0; k < FIVE; k++) {
                Stock minworst = min.delMin();
                System.out.println(minworst);
                worst.put(minworst.getStockName(), minworst.getChange());
            }
            System.out.println();
        }
    }
}
