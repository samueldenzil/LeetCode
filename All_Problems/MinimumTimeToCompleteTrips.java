// https://leetcode.com/problems/minimum-time-to-complete-trips

package All_Problems;

public class MinimumTimeToCompleteTrips {

	public static void main(String[] args) {
		int[] time = {1, 2, 3};
		int totalTrips = 5;
		System.out.println(minimumTime(time, totalTrips));
	}

	public static long minimumTime(int[] time, int totalTrips) {
		long ans = 0;

		long start = 1;
		// max-time of bus according to constraints * max-totalTrip according to constraints
		long end = 100_000_000_000_000L; // 10^7 * 10^7 => 10^14

		while (start <= end) {
			long mid = start + ((end - start) >> 1);
			// OR long mid = start + (end - start) / 2;

			if (tripsTake(time, mid) >= totalTrips) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		return ans;
	}

	private static long tripsTake(int[] time, long sec) {
		long tripCount = 0;
		for (int item : time) {
			tripCount += sec / item;
		}
		return tripCount;
	}
}