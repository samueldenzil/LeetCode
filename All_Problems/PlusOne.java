// https://practice.geeksforgeeks.org/problems/plus-one/1
package All_Problems;

import java.util.ArrayList;

public class PlusOne {

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(4);

        System.out.println(increment(arr, arr.size()));
    }

    static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
        // code here
        int carry = 1;

        for (int i = N - 1; i >= 0; i--) {
            int newDigit = arr.get(i) + carry;
            arr.set(i, newDigit % 10);
            carry = newDigit / 10;
        }

        if (carry > 0) arr.add(0, carry);

        return arr;
    }
}
