/**
 * Dynamic median finding.
 * @author exchangenika Vakacharla.
 */
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for heapsort.
 */
class Heapsort {
	/**
	 * declaration of array.
	 */
	private int[] array;
	/**
	 * declaration of size.
	 */
	private int size;
	/**
	 * Constructs the object.
	 *
	 * @param      n     { parameter_description }
	 */
	Heapsort(int n) {
		array = new int[n];
		size = 0;
	}
	/**
	 * sort function.
	 */
	public void sort() {
		for (int i = (size / 2) - 1; i >= 0; i--) {
			heapify(size, i);
		}
		for (int i = size - 1; i >= 0; i--) {
			exchange(0, i);
			heapify(i, 0);
		}
	}
	/**
	 * insert method.
	 *
	 * @param      item  The item
	 */
	public void insert(int item) {
		array[size++] = item;
		sort();
	}
	/**
	 * exchange function.
	 *
	 * @param      i     { parameter_description }
	 * @param      j     { parameter_description }
	 */
	public void exchange(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	/**
	 * heapify method.
	 *
	 * @param      n     { parameter_description }
	 * @param      i     { parameter_description }
	 */
	public void heapify(int n, int k) {
		int largest = k;
		int l = 2 * k + 1;
		int r = 2 * k + 2;
		if (l < n && array[l] > array[largest]) {
			largest = l;
		}
		if (r < n && array[r] > array[largest]) {
			largest = r;
		}
		if (largest != k) {
			exchange(k, largest);
			heapify(n, largest);
		}
	}
	/**
	 * get item.
	 *
	 * @param      index  The index
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getitem(int index) {
		return array[index];
	}
	/**
	 * get size.
	 *
	 * @return     { description_of_the_return_value }
	 */
	public int getsize() {
		return size;
	}
}
/**
 * Class for solution.
 */
public final class Solution {
	/**
	 * Constructs the object.
	 */
	Solution() {
		//empty constructor.
	}
	/**
	 * Client program.
	 *
	 * @param      args  The arguments
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		Heapsort heap =  new Heapsort(n);
		for (int i = 0; i < n; i++) {
			heap.insert(Integer.parseInt(sc.nextLine()));
			int size = heap.getsize();
			if ((size) % 2 == 0) {
				float median = ((float)heap.getitem((size - 1) / 2) + (float)heap.getitem(size / 2)) / 2;
				System.out.println(median);
			} else {
				float median = (float)heap.getitem((size - 1) / 2);
				System.out.println(median);
			}
		}
	}
}
