package All_Problems;

public class FirstUppercaseLetterInAString {

    public static void main(String[] args) {
        String str = "geeksforgeeKs";
         char ans = findUpper(str, str.length());
         if (ans == 0) {
             System.out.println("No upper case letters");
         }
         System.out.println(ans);
    }

    public static char findUpper(String str, int n) {
        if (str.charAt(n) == '\0')
            return 0;

        if ((int)str.charAt(n - 1) >= 65 && (int)str.charAt(n - 1) <= 90) {
            return str.charAt(n - 1);
        } else {
            return findUpper(str, n - 1);
        }
    }
}
