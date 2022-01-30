// https://practice.geeksforgeeks.org/problems/maximum-value-in-a-bitonic-array3001/1/
package All_Problems;

public class BitonicPoint {

	public static void main(String[] args) {
		int[] arr = {1, 15, 25, 45, 42, 21, 17, 12, 11};
		int n = arr.length;
		System.out.println(findMaximum(arr, n));
	}

	static int findMaximum(int arr[], int n) {
		// code here
		int start = 0;
		int end = n - 1;

		while (start < end) {
			int mid = start + (end - start) / 2;

			if (arr[mid] > arr[mid + 1]) {
				end = mid;
			} else if (arr[mid] < arr[mid + 1]) {
				start = mid + 1;
			}
		}

		return arr[end];
	}
}