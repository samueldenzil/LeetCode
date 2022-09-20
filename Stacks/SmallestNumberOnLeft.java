// https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1
package Stacks;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

public class SmallestNumberOnLeft {

    public static void main(String[] args) {
        int[] a = {1, 5, 0, 3, 4, 5};
        System.out.println(leftSmaller(a.length, a));
    }

    public static List<Integer> leftSmaller(int n, int[] a) {
        //code here
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        stack.push(-1);

        for (int i = 0; i < n; i++) {
            while (stack.peek() != -1 && stack.peek() >= a[i]) {
                stack.pop();
            }
            list.add(stack.peek());
            stack.push(a[i]);
        }

        return list;
    }
}
