// https://practice.geeksforgeeks.org/problems/binary-number-to-decimal-number3525/1

package Arrays;

public class BinaryNumberToDecimalNumber {

	public static void main(String[] args) {
		String str = "101100";
		System.out.println(binary_to_decimal(str));
	}

	public static int binary_to_decimal(String str) {
		int base = 1;
		int ans = 0;
		for (int i = str.length() - 1; i >= 0; i--) {
			int c = str.charAt(i) - '0';
			if (c == 1) {
				ans += base;
			}
			base *= 2;
		}

		return ans;
	}
}
