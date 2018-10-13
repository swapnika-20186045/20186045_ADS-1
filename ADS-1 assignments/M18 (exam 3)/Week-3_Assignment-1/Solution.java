import java.util.Scanner;
public final class Solution {
	private Solution() {
		//empty constructor.
	}
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
		while(n > 0) {
			int hrs = 6;
			while(hrs > 0) {
				String[] tokens = scan.nextLine().split(",");
				System.out.println(tokens[1]);
				hrs--;
			}
			n--;
		}
	}
}