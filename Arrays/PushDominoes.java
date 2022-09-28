// https://leetcode.com/problems/push-dominoes/
package Arrays;

public class PushDominoes {

    public static void main(String[] args) {
        String dominoes = "RR.L";
        System.out.println(pushDominoes(dominoes));
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();

        int[] left = new int[n];
        int i = n - 1;
        while (i >= 0) {
            int index = i;
            while (i >= 0 && dominoes.charAt(i) != 'L') {
                left[i] = -1;
                i--;
                index = i;
            }
            while (i >= 0 && dominoes.charAt(i) != 'R') {
                if (dominoes.charAt(i) == 'L') {
                    index = i;
                }
                left[i] = index;
                i--;
            }
        }

        int[] right = new int[n];
        i = 0;
        while (i < n) {
            int index = i;
            while (i < n && dominoes.charAt(i) != 'R') {
                right[i] = -1;
                i++;
                index = i;
            }
            while (i < n && dominoes.charAt(i) != 'L') {
                if (dominoes.charAt(i) == 'R') {
                    index = i;
                }
                right[i] = index;
                i++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (i = 0; i < n; i++) {
            if (dominoes.charAt(i) == '.') {
                int nearestLeft = left[i];
                int nearestRight = right[i];

                int leftDist = nearestLeft == -1 ? Integer.MAX_VALUE : Math.abs(nearestLeft - i);
                int rightDist = nearestRight == -1 ? Integer.MAX_VALUE : Math.abs(nearestRight - i);

                if (leftDist < rightDist) {
                    sb.append('L');
                } else if (leftDist > rightDist) {
                    sb.append('R');
                } else {
                    sb.append('.');
                }
            } else {
                sb.append(dominoes.charAt(i));
            }
        }

        return sb.toString();
    }
}
