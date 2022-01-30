// https://practice.geeksforgeeks.org/problems/capacity-to-ship-packages-within-d-days/1
package All_Problems;

public class CapacityToShipPackagesWithinDDays {

	public static void main(String[] args) {
		int[] arr = {9, 8, 10};
		int N = arr.length;
		int D = 3;
		System.out.println(leastWeightCapacity(arr, N, D));
	}

	static int leastWeightCapacity(int[] arr, int N, int D) {
		// code here
		int ans = 0;
		int max = 0;
		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (max < arr[i])
				max = arr[i];

			sum += arr[i];
		}

		int low = max;
		int high = sum;

		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (isDaySatisfied(arr, mid, D)) {
				// this can be an answer, there can be a better ans so go left
				ans = mid;
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}

		return ans;
	}

	static boolean isDaySatisfied(int[] arr, int boatWeight, int D) {
		int days = 0;
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if (sum > boatWeight) {
				sum = arr[i];
				days++;
			}
		}
		days++;

		return days <= D;
	}
}
