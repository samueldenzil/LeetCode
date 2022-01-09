// https://practice.geeksforgeeks.org/problems/wave-array-1587115621/1

public class WaveArray {

	// arr: input array
	// n: size of the array
	//Function to sort the array into a wave-like array.
	public static void convertToWave(int arr[], int n) {

		// Your code here
		for (int i = 0; i < n - 1; i += 2) {
			int temp = arr[i];
			arr[i] = arr[i + 1];
			arr[i + 1] = temp;
		}
	}

}
