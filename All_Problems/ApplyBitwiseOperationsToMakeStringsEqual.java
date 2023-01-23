// https://leetcode.com/problems/apply-bitwise-operations-to-make-strings-equal/
package All_Problems;

public class ApplyBitwiseOperationsToMakeStringsEqual {

    public static void main(String[] args) {
        String s = "1010", target = "0110";
        System.out.println(makeStringsEqual(s, target));
    }

    public static boolean makeStringsEqual(String s, String target) {
        /*
            s[i] = s[i] OR s[j]
            s[j] = s[i] XOR s[j]

            s[i]  s[j]  |   s[i]  s[j]
              0     0   |     0     0
              0     1   |     1     1
              1     0   |     1     1   if we have atleast one 1 we can swap the other
              1     1   |     1     0   number
        */

        if (s.equals(target)) {
            return true;
        }

        int n = s.length();
        boolean oneInS = false;
        boolean oneInTarget = false;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                oneInS = true;
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            if (target.charAt(i) == '1') {
                oneInTarget = true;
                break;
            }
        }

        return (oneInS || !oneInTarget) && (!oneInS || oneInTarget);
    }
}
