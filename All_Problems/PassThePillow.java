// https://leetcode.com/problems/pass-the-pillow/
package All_Problems;

public class PassThePillow {

    public static void main(String[] args) {
        int n = 4, time = 5;
        System.out.println(passThePillow(n, time));
    }

    public static int passThePillow(int n, int time) {
        n--;    // n = number of passes in one dir
        int quo = time / n;
        int rem = time % n;

        if (quo % 2 == 0) { // left to right
            return rem + 1;
        } else {    // right to left
            return n - rem + 1;
        }
    }
}
