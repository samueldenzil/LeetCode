// https://leetcode.com/problems/baseball-game/
package All_Problems;

import java.util.Stack;

public class BaseballGame {

    public static void main(String[] args) {
        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }

    public static int calPoints(String[] ops) {
        Stack<Integer> records = new Stack<>();

        for (int i = 0; i < ops.length; i++) {
            if (ops[i].equals("+")) {
                // Record a new score that is the sum of the previous two scores
                int last = records.pop();
                int newScore = records.peek() + last;
                records.push(last);
                records.push(newScore);
            } else if (ops[i].equals("D")) {
                // Record a new score that is double the previous score
                int newScore = records.peek() * 2;
                records.push(newScore);
            } else if (ops[i].equals("C")) {
                // Invalidate the previous score, removing it from the record
                records.pop();
            } else {
                // Record a new score
                int num = Integer.parseInt(ops[i]);
                records.push(num);
            }
        }

        int score = 0;
        while (!records.isEmpty()) {
            score += records.pop();
        }

        return score;
    }
}
