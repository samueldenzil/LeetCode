package All_Problems;
// https://www.geeksforgeeks.org/window-sliding-technique/
// https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1/
// OYO Rooms Interview Question

public class MaxSumSubarrayOfSizeK {

	public static void main(String[] args) {
		int[] arr = {1, 4, 2, 10, 2, 3, 1, 0, 20};
		int k = 4;
		System.out.println(maximumSum(arr, k));
		// System.out.println(maximumSumBruteForce(arr, k));
	}

	public static int maximumSum(int[] arr, int k) {
		if (arr.length < k) {
			System.out.println("Invalid");
			return -1;
		}

		// compute sum of first window of size k
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += arr[i];
		}

		// compute sum of remaining window by
		// removing the first element of previous
		// window and add the last element of
		// current window
		int windowSum = sum;
		for (int i = k; i < arr.length; i++) {
			windowSum = windowSum + (arr[i] - arr[i - k]);
			sum = Math.max(sum, windowSum);
		}

		return sum;
	}

	// we are able to get the answer but the time complexity is O(n^2) - by using Sliding Window method we can
	// reduce the time complexity to O(n)
	public static int maximumSumBruteForce(int[] arr, int k) {
		int sum = 0;
		for (int i = 0; i < arr.length - k + 1; i++) {
			int currentSum = 0;
			for (int j = 0; j < k; j++) {
				currentSum = currentSum + arr[i + j];
			}
			sum = Math.max(sum, currentSum);
		}
		return sum;
	}
}
