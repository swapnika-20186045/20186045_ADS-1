/**
 * Balanced Paranthesis.
 * @author Swapnika Vakacharla.
 */
import java.util.Scanner;
/**
 * class for stack.
 */
class Stack {
	/**
	 * Class for node.
	 */
	class Node {
		char item;
		Node next;
	}
	Node head = null;
	/**
	 * push the elements.
	 *
	 * @param      p     { parameter_description }
	 */
	public void push(final char p) {
		Node lol = head;
		head = new Node();
		head.item = p;
		head.next = lol;
	}
	/**
	 * pop the elements.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public char pop() {
		if (head == null) {
			return 'e';
		}
		// if (head.next == null) {
		// 	char r = head.item;
		// 	head = null;
		// 	return r;
		// } else {
		char r = head.item;
		head = head.next;
		return r;
		// }
	}
	/**
	 * Returns a string representation of the object.
	 *
	 * @return     String representation of the object.
	 */
	public String toString() {
		String str = "";
		Node fun = head;
		while (fun != null) {
			str += fun.item;
			fun = fun.next;
		}
		return str;
	}
}
/**
 * Class for balanced paranthesis.
 */
class BalancedParanthesis {
	/**
	 * Constructs the object.
	 */
	BalancedParanthesis() {
		//not used
	}
	/**
	 * check the balance of paranthesis.
	 *
	 * @param      str   The string
	 *
	 * @return     { description_of_the_return_value }
	 */
	public boolean balance(final String str) {
		Stack s = new Stack();
		for (int i = 0; i < str.length(); i++) {
			// if (head == null) {
			// 	return true;
			// }
			// System.out.println(s + " " + str.charAt(i));
			if (str.charAt(i) == '[' || str.charAt(i) == '('
				|| str.charAt(i) == '{') {
				s.push(str.charAt(i));
			} else {
				char ch = s.pop();
				if ((ch == '(' && str.charAt(i) == ')') || (ch == '['
					&& str.charAt(i) == ']') || (ch == '{'
					&& str.charAt(i) == '}')) {
					// ch = s.pop();
					// System.out.println(ch + "39"+ str.charAt(i));
					continue;
				} else {
					return false;
				}
			}
		}
		return s.head == null;
	}
}
public final class Solution {
	Solution() {
		//not used.
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = Integer.parseInt(scan.nextLine());
		String[] strarray = new String[n];
		for (int i = 0; i < n; i++) {
			strarray[i] = scan.nextLine();
		}
		BalancedParanthesis bp = new BalancedParanthesis();
		for (int i = 0; i < n; i++) {
			if (bp.balance(strarray[i])) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
	}
}