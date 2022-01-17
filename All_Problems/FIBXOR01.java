package All_Problems;


import java.util.Scanner;

public class FIBXOR01 {

	/*
	1010110	-> 86	0
	1001101	-> 77	1
	0011011	-> 22	2
	1010110	-> 86	3
	1001101	-> 77	4
	0011011	-> 22	2
	n = 15 => ans = 86

	1011101	-> 93	0
	0100011	-> 35	1
	1111110	-> 126	2
	1011101	-> 93	3
	0100011	-> 35	4
	1111110	-> 126	2
	n = 86 => ans = 126

	0111110 -> 62
	0011011	-> 27
	0100101	-> 37
	0111110 -> 62
	0011011	-> 27
	0100101	-> 37
	n = 90 => ans = 62
	*/

	static int a = 0;
	static int b = 0;

	public static int fibonacci(int n) {
		if (n == 0) {
			return a;
		}
		if (n == 1) {
			return b;
		}
		return fibonacci(n - 1) + fibonacci(n - 2);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t != 0) {
			a = sc.nextInt();
			b = sc.nextInt();
			int n = sc.nextInt();
			System.out.println(fibonacci(n % 3));
			t--;
		}
		sc.close();
	}
}