// https://leetcode.com/problems/maximum-69-number/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class Maximum69Number {

    public static void main(String[] args) {
        int num = 9669;
        System.out.println(maximum69Number(num));
    }

    public static int maximum69Number (int num) {
        List<Integer> list = new ArrayList<>();
        while (num > 0) {
            int remainder = num % 10;
            list.add(remainder);
            num /= 10;
        }
        boolean flag = true;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == 6 && flag) {
                list.set(i, 9);
                flag = false;
            }
            num *= 10;
            num += list.get(i);
        }
        return num;
    }
}
