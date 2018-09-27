import java.util.Scanner;
class Stack {

	class Node {
		char item;
		Node next;
	}
	Node head = null;
	public void push(char p) {
		Node lol = head;
		head = new Node();
		head.item = p;
		head.next = lol;
	}
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
class BalancedParanthesis {
	BalancedParanthesis() {
		//not used
	}
	public boolean balance(String str) {
		Stack s = new Stack();
		for (int i = 0; i < str.length(); i++) {
			// if (head == null) {
			// 	return true;
			// }
			// System.out.println(s + " " + str.charAt(i));
			if (str.charAt(i) == '[' || str.charAt(i) == '(' || str.charAt(i) == '{') {
				s.push(str.charAt(i));
			} else {
				char ch = s.pop();
				if ((ch == '(' && str.charAt(i) == ')') || (ch == '[' && str.charAt(i) == ']') || (ch == '{' && str.charAt(i) == '}')) {
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
	public static void main(String[] args) {
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