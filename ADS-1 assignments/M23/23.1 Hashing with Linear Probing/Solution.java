import java.util.Scanner;
/**
 * class for Solution.
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
		LinearProbingHashST<String, Integer> obj
		    = new LinearProbingHashST<String, Integer>();
		int n = Integer.parseInt(scan.nextLine());
		while (n > 0) {
			String[] tokens = scan.nextLine().split(" ");
			switch (tokens[0]) {
			case "put" :
				obj.put(tokens[1], Integer.parseInt(tokens[2]));
				break;
			case "get" :
				System.out.println(obj.get(tokens[1]));
				break;
			case "display" :
				try {
				System.out.println(obj.display());
				} catch(Exception ex) {
					System.out.println("{}");
				}
				break;
			case "delete" :
				obj.delete(tokens[1]);
				break;
			default:
				break;
			}
			n--;
		}
	}
}
