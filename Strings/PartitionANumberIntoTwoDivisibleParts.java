// https://practice.geeksforgeeks.org/problems/partition-a-number-into-two-divisible-parts3605/1
package Strings;

public class PartitionANumberIntoTwoDivisibleParts {

    public static void main(String[] args) {
        String S = "1200";
        int a = 4, b = 3;
        System.out.println(stringPartition(S, a, b));
    }

    public static String stringPartition(String S, int a, int b){
        // code here
        for (int i = 1; i < S.length(); i++) {
            String s1 = S.substring(0, i);
            String s2 = S.substring(i);

            if (Integer.parseInt(s1) % a == 0 && Integer.parseInt(s2) % b == 0) {
                return s1 + " " + s2;
            }
        }

        return "-1";
    }
}
