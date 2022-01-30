// https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1
package Strings;

public class ReverseWordsInAGivenString {

	public static void main(String[] args) {
		String S = "pqr.mno";
		System.out.println(reverseWords(S));

	}

	public static String reverseWords(String S) {
		// code here
		StringBuilder str = new StringBuilder();
		int prev = S.length();

		for (int i = S.length() - 1; i >= 0; i--) {
			if (S.charAt(i) == '.') {
				str.append(S, i + 1, prev);
				str.append('.');
				prev = i;
			}
		}
		str.append(S, 0, prev);
		return str.toString();
	}
}
