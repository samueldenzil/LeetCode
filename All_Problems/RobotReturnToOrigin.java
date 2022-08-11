// https://leetcode.com/problems/robot-return-to-origin/
package All_Problems;

public class RobotReturnToOrigin {

    public static void main(String[] args) {
        String moves = "UD";
        System.out.println(judgeCircle(moves));
    }

    public static boolean judgeCircle(String moves) {
        int v = 0;
        int h = 0;

        for (int i = 0; i < moves.length(); i++) {
            char c = moves.charAt(i);
            if (c == 'R') {
                h++;
            } else if (c == 'L') {
                h--;
            } else if (c == 'U') {
                v--;
            } else {
                v++;
            }
        }

        return v == 0 && h == 0;
    }
}
