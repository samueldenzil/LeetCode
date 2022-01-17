package Recursion;

// this problem is nothing but Josephus problem
// https://practice.geeksforgeeks.org/problems/josephus-problem/1
// Amazon Walmart Microsoft

import java.util.ArrayList;

class FindTheWinnerOfTheCircularGame {

	public int findTheWinner(int n, int k) {
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			arr.add(i, i + 1);
		}
		return helperFunction(k, arr, 0);
	}

	public int helperFunction(int k, ArrayList<Integer> arr, int currentPerson) {
		int n = arr.size();
		if (n == 1) {
			return arr.get(0);
		}

		arr.remove((currentPerson + k - 1) % n);
		return helperFunction(k, arr, (currentPerson + k - 1) % n);
	}
}
