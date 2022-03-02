// https://leetcode.com/problems/minimum-speed-to-arrive-on-time/

package Arrays;

public class MinimumSpeedToArriveOnTime {

	public static void main(String[] args) {
		int[] dist = {1,1,100000};
		double hour = 2.01;
		System.out.println(minSpeedOnTime(dist, hour));
	}

	public static int minSpeedOnTime(int[] dist, double hour) {
		int ans = Integer.MAX_VALUE;

		int start = 1;
		int end = 100_000_000;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			// (getTime(dist, mid) > hour) => it means that, at this speed you will be late for your work so increase the speed
			if (getTime(dist, mid) > hour) {
				start = mid + 1;
			} else {
				// this can be the answer but still check for less speed values
				ans = mid;
				end = mid - 1;
			}
		}
		// if it's impossible to be on time then the ans value will not change
		return ans != Integer.MAX_VALUE ? ans : -1;
	}

	public static double getTime(int[] dist, int speed) {
		double currentTime = 0;

		for (int i = 0; i < dist.length; i++) {
			if (i != dist.length - 1) {
				// train can only depart at an integer hour, so we have to round-off the value
				currentTime += Math.ceil((double) dist[i] / speed);
			} else {
				// for last train, we don't have to wait for any more trains so no need to round-off
				currentTime += (double) dist[i] / speed;
			}
		}

		return currentTime;
	}
}