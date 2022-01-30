// https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1/
package Strings;

public class RemoveDuplicates {

	public static void main(String[] args) {
		String S = "zvvo";
		System.out.println(removeDups(S));
	}

	static String removeDups(String S) {
		// code here
		int[] items = new int[128];
		StringBuilder str = new StringBuilder();

		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (items[c] == 0) {
				str.append(c);
				items[c]++;
			}
		}

		return str.toString();
	}
}