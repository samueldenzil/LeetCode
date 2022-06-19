// https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
package All_Problems;

public class MaximumPointsYouCanObtainFromCards {

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;
        System.out.println(maxScore(cardPoints, k));
    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;

        int totalSum = 0;
        for (int cardPoint : cardPoints) {
            totalSum += cardPoint;
        }

        int curr = 0;
        for (int i = 0; i < n - k; i++) {
            curr += cardPoints[i];
        }

        int min = curr;
        for (int i = n - k; i < n; i++) {
            curr -= cardPoints[i - (n - k)];
            curr += cardPoints[i];
            min = Math.min(min, curr);
        }

        return totalSum - min;
    }
}
