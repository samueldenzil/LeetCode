// https://practice.geeksforgeeks.org/problems/check-if-the-number-is-fibonacci4654/1/
// Adobe 
package All_Problems;

import java.util.ArrayList;

public class CheckIfTheNumberIsFibonacci {

	public static void main(String[] args) {
		int n = 34;
		System.out.println(checkFibonacci(n));
	}
	
    static String checkFibonacci(int N){
        // code here
    	ArrayList<Integer> arr = new ArrayList<>();
    	arr.add(0);
    	arr.add(1);
    	
    	for (int i = 2; i <= 100; i++) {
    		arr.add(i, arr.get(i - 1) + arr.get(i - 2));
    	}
    	
    	if (arr.contains(N)) {
    		return "Yes";
    	} else {
    		return "No";
    	}
    }
}
