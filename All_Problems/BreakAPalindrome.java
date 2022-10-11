// https://leetcode.com/problems/break-a-palindrome/
package All_Problems;

public class BreakAPalindrome {

    public static void main(String[] args) {
        String palindrome = "abccba";
        System.out.println(breakPalindrome(palindrome));
    }

    public static String breakPalindrome(String palindrome) {
        if (palindrome.length() == 1) {
            return "";
        }

        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < palindrome.length()) {
            char c = palindrome.charAt(i);
            int index = c - 'a';
            if (index == 0) {
                sb.append(c);
                i++;
                continue;
            }
            sb.append('a');
            i++;
            break;
        }

        sb.append(palindrome.substring(i));

        if (isPalindrome(sb)) {
            return palindrome.substring(0, palindrome.length() - 1) + "b";
        }
        return sb.toString();
    }

    private static boolean isPalindrome(StringBuilder sb) {
        int i = 0;
        int j = sb.length() - 1;
        while (i < j) {
            if (sb.charAt(i) != sb.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
