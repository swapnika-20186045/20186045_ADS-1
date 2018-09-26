import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
class Sortedarray {
	public boolean containsKey(ArrayList<Integer> array, int key) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == key) {
				return true;
			}
		}
		return false;
	}
	public boolean containsKey(int array[], int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return true;
			}
		}
		return false;
	}
	public ArrayList<Integer> sortedArray(int[] array1, int[] array2) {
		ArrayList<Integer> result = new ArrayList<>();
		// int array1[];
		// int array2[];
		// System.out.println(Arrays.toString(array1));
		// System.out.println(Arrays.toString(array2));
		if (array1.length > array2.length) {
			for (int i = 0; i < array1.length; i++) {
				if (containsKey(array2, array1[i])) {
					if (!containsKey(result, array1[i])) {
						result.add(array1[i]);
					}
				}
			}
		} else {
			for (int i = 0; i < array2.length; i++) {
				System.out.println("38" + array2[i]);
				if (containsKey(array1, array2[i])) {
					System.out.println("40" + array2[i]);
					if (!containsKey(result, array2[i])) {
						System.out.println("42" + array2[i]);
						result.add(array2[i]);
					}
				}
			}
		}
		Collections.sort(result);
		return result;
	}
}
class Solution {
	Solution() {
		//not used
	}
	public static void main(final String[] args) {
		Scanner input = new Scanner(System.in);
		// Sortedarray s = new Sortedarray();
		int n1 = Integer.parseInt(input.nextLine());
		int n2 = Integer.parseInt(input.nextLine());
		String[] array1temp = input.nextLine().split(",");
		String[] array2temp = input.nextLine().split(",");
		// ArrayList<Integer> array = new ArrayList<>();
		int[] array1 = new int[n1];
		int[] array2 = new int[n2];
		// for (int i = 0; i < n1; i++) {
		// 	array1[i] = Integer.parseInt(array1temp[i]);
		// }
		// for (int i = 0; i < n2; i++) {
		// 	array2[i] = Integer.parseInt(array2temp[i]);
		// }
		int[] array = new int[n1 + n2];
		for (int i = 0; i < n1; i++) {
			array[i] = Integer.parseInt(array1temp[i]);
		}
		for (int i = n1; i < n1+n2; i++) {
			array[i] = Integer.parseInt(array2temp[i-n1]);
		}
		// System.out.println(s.sortedArray(array1, array2));
		System.out.println(Arrays.toString(array));
	}
}

