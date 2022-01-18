// https://practice.geeksforgeeks.org/problems/doubling-the-value4859/1/
// Flipkart
package Searching;

public class DoublingTheValue {
	
	public static void main(String[] args) {
		int B = 3;
		long arr[] = {1, 2, 3, 4, 8};
		System.out.println(solve(arr.length, arr, B));
	}
	
    static long solve(int n, long A[], long b) {
        // Complete this function
    	for (int i = 0; i < A.length; i++) { 
    		if (A[i] == b) {
    			b *= 2;
    		}
    	}
    	return b;
    }
}
