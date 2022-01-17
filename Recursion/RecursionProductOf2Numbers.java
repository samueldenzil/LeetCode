package Recursion;

// https://www.geeksforgeeks.org/product-2-numbers-using-recursion/
import java.util.Scanner;

public class RecursionProductOf2Numbers {
    /*
        x = 5, y = 2
        
        2 + 2 + 2 + 2 + 2
        product(5 - 1, 2) + 2
        product(x - 1, y);
    */

    public static int product(int x, int y) {
        if (x == 0) {
            return 0;
        }
        return product(x - 1, y) + y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        int ans = x > y ? product(y, x) : product(x, y);
        System.out.println(ans);
        sc.close();
    }
}