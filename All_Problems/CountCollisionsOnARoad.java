// https://leetcode.com/problems/count-collisions-on-a-road/
package All_Problems;

public class CountCollisionsOnARoad {

	public static void main(String[] args) {
		String directions = "RLRSLL";
		System.out.println(countCollisions(directions));
	}

	public static int countCollisions(String directions) {
		int count = 0;
		char[] d = directions.toCharArray();

		for (int i = 0; i < d.length; i++) {
			if (d[i] == 0) continue;    // if the current car is already collided no need to check for this car

			if (i + 1 < d.length && d[i] == 'R' && d[i + 1] == 'L') {
				// first car is moving towards right and second car is moving towards left
				count += 2;
				d[i] = 0;
				d[i + 1] = 0;
				int temp = i - 1;
				// count the number of collisions will occur from the previous cars, after this current collision
				count += checkPrevCars(temp, d);
			} else if (i - 1 >= 0 && d[i] == 'L' && (d[i - 1] == 0 || d[i - 1] == 'S')) {
				// current car is moving towards left and there is a stationary car or collided car already on the left side
				count += 1;
				d[i] = 0;
				int temp = i - 1;
				// count the number of collisions will occur from the previous cars, after this current collision
				count += checkPrevCars(temp, d);
			} else if (i + 1 < d.length && d[i] == 'R' && (d[i + 1] == 0 || d[i + 1] == 'S')) {
				// current car is moving towards right and there is a stationary car or collied car already on the right side
				count += 1;
				d[i] = 0;
				int temp = i - 1;
				// count the number of collisions will occur from the previous cars, after this current collision
				count += checkPrevCars(temp, d);
			}
		}

		return count;
	}

	public static int checkPrevCars(int temp, char[] d) {
		int tempCount = 0;
		while (temp >= 0 && d[temp] != 0) {
			if (d[temp] == 'S' || d[temp] == 'L') {
				break;
			}
			d[temp] = 0;
			temp--;
			tempCount++;
		}
		return tempCount;
	}
}
