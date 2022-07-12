// https://practice.geeksforgeeks.org/problems/reaching-the-heights1921/1
package Arrays;

import java.util.Arrays;
import java.util.ArrayList;

public class ReachingTheHeights {

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5};
        System.out.println(reaching_height(arr.length, arr));
    }

    public static ArrayList<Integer> reaching_height(int n, int[] arr) {
        //Complete the function
        Arrays.sort(arr);

        ArrayList<Integer> ans = new ArrayList<>();
        int i = n - 1;
        int j = 0;

        int height = 0;

        while (j <= i) {
            ans.add(arr[i]);
            height += arr[i];
            if (i != j) {
                ans.add(arr[j]);
                height -= arr[j];
            }
            i--;
            j++;
        }

        if (height <= 0) {
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(-1);
            return temp;
        }

        return ans;
    }
}
