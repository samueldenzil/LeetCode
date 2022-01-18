// https://practice.geeksforgeeks.org/problems/gray-code-1611215248/1/
// Microsoft
package Recursion;

import java.util.ArrayList;

public class GrayCode {
	/*
	Note: n-bit Gray Codes can be generated from list of (n-1)-bit Gray codes using following steps. 
			Let the list of (n-1)-bit Gray codes be L1. Create another list L2 which is reverse of L1.
			Modify the list L1 by prefixing a ‘0’ in all codes of L1.
			Modify the list L2 by prefixing a ‘1’ in all codes of L2.
			Concatenate L1 and L2. The concatenated list is required list of n-bit Gray codes
	 */
	
	public static void main(String[] args) {
		int n = 4;
		System.out.println(generateGrayCodeArray(n));
	}
	
	static ArrayList<String> generateGrayCodeArray(int n) {
		ArrayList<String> currentList = generateGrayCode(n);
		return currentList;
	}
	
	static ArrayList<String> generateGrayCode(int n) {
		// Base Case
		if (n <= 0) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("0");
			return temp;
		}
		if (n == 1) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add("0");
			temp.add("1");
			return temp;
		}
		
		// getting the n - 1 bit gray code array
		ArrayList<String> prevGrayCode = generateGrayCode(n - 1);
		ArrayList<String> newGrayCode = new ArrayList<>();
		
		// prefixing 0 to the first half of the array
		for (int i = 0; i < prevGrayCode.size(); i++) {
			newGrayCode.add("0" + prevGrayCode.get(i));
		}
		
		// reversing the n - 1 gray code array and prefixing 1 to it
		for (int i = prevGrayCode.size() - 1; i >= 0; i--) {
			newGrayCode.add("1" + prevGrayCode.get(i));
		}
		
		return newGrayCode;
	}
}
