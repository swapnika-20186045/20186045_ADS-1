/**
 * Addition of Large Numbers.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for add large numbers.
 */
class AddLargeNumbers {
    /**
     * to convert numbers to digits.
     *
     * @param      number  The number
     *
     * @return     { description_of_the_return_value }
     */
    public static LinkedList numberToDigits(final String number) {
        LinkedList l = new LinkedList();
        String[] numarr = number.split("");
        for (int i = 0; i < numarr.length; i++) {
            l.push(numarr[i]);
        }
        return l;
    }
    /**
     * to convert digits to numbers.
     *
     * @param      list  The list
     *
     * @return     { description_of_the_return_value }
     */
    public static String digitsToNumber(final LinkedList list) {
        String str = "";
        while (!list.isEmpty()) {
            str += list.pop();
        }
        return str;
    }
    /**
     * Adds large numbers.
     *
     * @param      list1  The list 1
     * @param      list2  The list 2
     *
     * @return     { description_of_the_return_value }
     */
    // public static LinkedList addLargeNumbers(final LinkedList list1,
    //     final LinkedList list2) {
    //     l = new LinkedList();
    //     // list2 = new LinkedList();
    //     return l;
    // }
}
/**
 * Class for solution.
 */
public final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used.
    }
    /**
     * main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String p = sc.nextLine();
        String q = sc.nextLine();
        switch (input) {
        case "numberToDigits":
            LinkedList pDigits = AddLargeNumbers.numberToDigits(p);
            LinkedList qDigits = AddLargeNumbers.numberToDigits(q);
            System.out.println(AddLargeNumbers.digitsToNumber(pDigits));
            System.out.println(AddLargeNumbers.digitsToNumber(qDigits));
            break;

        // case "addLargeNumbers":
        //     pDigits = AddLargeNumbers.numberToDigits(p);
        //     qDigits = AddLargeNumbers.numberToDigits(q);
        //     LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits,
        //         qDigits);
        //     System.out.println(AddLargeNumbers.digitsToNumber(result));
        //     break;
        default :
            break;
        }
    }

}
