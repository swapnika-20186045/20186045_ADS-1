/**
 * Addition of Large Numbers.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * Class for add large numbers.
 */
final class AddLargeNumbers {
    /**
    *@variable TEN
    **/
    private static final int TEN = 10;
    /**
     * Constructs the object.
     */
    private AddLargeNumbers() {
        //not used.
    }
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
    public static LinkedList addLargeNumbers(final LinkedList list1,
        final LinkedList list2) {
        Stack s1 = new Stack();
        Stack s2 = new Stack();
        int carry = 0;
        String sum = "";
        int num = 0;
        if (list2.size > list1.size) {
            int differ = list2.size - list1.size;
            while (differ > 0) {
                s1.push(0);
                differ--;
            }
        }
        while (!list1.isEmpty()) {
            String temp = list1.pop();
            s1.push(Integer.parseInt(temp));
        }
        while (!list2.isEmpty()) {
            String temp1 = list2.pop();
            s2.push(Integer.parseInt(temp1));
        }
        while (!s1.isEmpty() || !s2.isEmpty()) {
            num = s1.pop() + s2.pop() + carry;
            carry = num / TEN;
            if (s1.size == 0) {
                sum += (num % TEN);
                if (num / TEN != 0) {
                    sum += (num / TEN);
                }
            } else {
                sum += (num % TEN);
            }
        }
        String res = "";
        for (int i = sum.length() - 1; i >= 0; i--) {
            res += sum.charAt(i);
        }
        LinkedList result = numberToDigits(res);
        return result;
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

        case "addLargeNumbers":
            pDigits = AddLargeNumbers.numberToDigits(p);
            qDigits = AddLargeNumbers.numberToDigits(q);
            LinkedList result = AddLargeNumbers.addLargeNumbers(pDigits,
                qDigits);
            System.out.println(AddLargeNumbers.digitsToNumber(result));
            break;
        default :
            break;
        }
    }
}

