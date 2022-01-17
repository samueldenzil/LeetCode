package Recursion;

// https://practice.geeksforgeeks.org/problems/geek-onacci-number/0/
import java.util.Scanner;

public class GeekonacciNumber {

    static int a = 0;
    static int b = 0;
    static int c = 0;

    public static int geekonacci(int n) {
        if (n == 1) {
            return a;
        }
        if (n == 2) {
            return b;
        }
        if (n == 3) {
            return c;
        }

        return geekonacci(n - 1) + geekonacci(n - 2) + geekonacci(n - 3);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            int n = sc.nextInt();
            System.out.println(geekonacci(n));
            t--;
        }
        sc.close();
    }
}

