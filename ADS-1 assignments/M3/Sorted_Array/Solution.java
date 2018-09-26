import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
class Sortedarray {
	public static boolean containsKey(ArrayList<Integer> array, int key) {
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) == key) {
				return true;
			}
		}
		return false;
	}
	public static boolean containsKey(int array[], int key) {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == key) {
				return true;
			}
		}
		return false;
	}
	public static ArrayList<Integer> Sortedarray(int[] array1, int[] array2) {
		ArrayList<Integer> result = new ArrayList<>();
		// int array1[];
		// int array2[];
		if (array1.length > array2.length) {
			for (int i = 0; i < array1.length; i++) {
				if (containsKey(array2, array1[i])) {
					if (!containsKey(result, array1[i])) {
						result.add(array1[i]);
					}
				}
			}
		} for (int i = 0; i < array2.length; i++) {
			if (containsKey(array1, array2[i])) {
				if (!containsKey(result, array2[i])) {
					result.add(array2[i]);
				}
			}
		}
		Collections.sort(result);
		return result;
	}
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int array1[] = new int[n1];
		int array2[] = new int[n2];
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = 0; i < n1; i++) {
			array1[i] = input.nextInt();
		}
		for (int i = 0; i < n2; i++) {
			array2[i] = input.nextInt();
		}
		System.out.println(Sortedarray(array1, array2));
	}
}

