// https://practice.geeksforgeeks.org/problems/josephus-problem/1
// Amazon Walmart Microsoft

import java.util.ArrayList;

public class JosephusProblem {

    public static void main(String[] args) {
        int n = 6;
        int k = 5;
        System.out.println(josephus(n, k));
    }

    public static int josephus(int n, int k) {
        //Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i, i + 1);
        }
        return helperFunction(k, arr, 0);
    }

    public static int helperFunction(int k, ArrayList<Integer> arr, int current) {
        int n = arr.size();
        if (n == 1) {
            return arr.get(0);
        }
        arr.remove((current + k - 1) % n);
        return helperFunction(k, arr, (current + k - 1) % n);
    }
}
