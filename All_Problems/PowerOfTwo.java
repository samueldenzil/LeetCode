package All_Problems;
// https://leetcode.com/problems/power-of-two/

public class PowerOfTwo {

	/*
	n = 16

	if (16%2 == 0) {return true}
	func(16/2) * 2;
	func(8/2) * 2;
	func(4/2) * 2;
	func(2/2) * 2;
	1
	*/

    public boolean isPowerOfTwo(int n) {        
		if (n == 1) {
			return true;
		}
        if (n % 2 == 0 && n != 0) {
        	return isPowerOfTwo(n / 2);
        }
        else {
        	return false;
        }
    }
}
