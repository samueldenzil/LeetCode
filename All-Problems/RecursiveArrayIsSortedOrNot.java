// https://www.geeksforgeeks.org/program-check-array-sorted-not-iterative-recursive/

public class RecursiveArrayIsSortedOrNot {

	public static boolean isSorted(int[] arr, int n) {
		// if only last element present return true
		if (n == 0) {
			return true;
		}

		// if this condition is true then the array is not sorted
		if (arr[n] < arr[n - 1]) {	
			return false;
		}

		return isSorted(arr, n - 1);
	}

	public static void main(String[] args) {
		int[] arr = {20, 20, 78, 98, 99, 97};
		System.out.println(isSorted(arr, arr.length - 1));
	}
}


