// https://practice.geeksforgeeks.org/problems/maximum-money2855/1/
// Amazon
package All_Problems;

public class MaximumMoney {

	public static void main(String[] args) {
		int n = 5;
		int k = 10;
		System.out.println(maximizeMoney(n, k));
	}
	
	static int maximizeMoney(int N , int K) {
		// code here
		int ans = 0;
		
		if ((N & 1) == 0) {
		    ans = (N / 2) * K;
		} else {
		    ans = ((N + 1) / 2) * K;
		}
		return ans;
	}
}
