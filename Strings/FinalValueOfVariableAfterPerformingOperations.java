// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/
package Strings;

public class FinalValueOfVariableAfterPerformingOperations {

    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperations(operations));
    }

    public static int finalValueAfterOperations(String[] operations) {
        int x = 0;

        for (String operation : operations) {
            if (operation.equals("++X") || operation.equals("X++")) {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }
}
