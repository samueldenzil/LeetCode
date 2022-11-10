// https://leetcode.com/problems/online-stock-span/
package All_Problems;

import java.util.Stack;

public class StockSpanner {

    Stack<int[]> stack; // <stock price, span number>

    public StockSpanner() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int ans = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {  // maintaining stack sorted in ascending order
            int prevSpan = stack.pop()[1];
            ans += prevSpan;
        }
        stack.add(new int[]{price, ans});
        return ans;
    }

    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // return 1
        System.out.println(stockSpanner.next(80));  // return 1
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(70));  // return 2
        System.out.println(stockSpanner.next(60));  // return 1
        System.out.println(stockSpanner.next(75));  // return 4, because the last 4 prices (including today's price of 75) were less than or equal to today's price.
        System.out.println(stockSpanner.next(85));  // return 6
    }
}
