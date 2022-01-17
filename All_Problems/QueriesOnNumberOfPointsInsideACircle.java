package All_Problems;
// https://leetcode.com/problems/queries-on-number-of-points-inside-a-circle/

class QueriesOnNumberOfPointsInsideACircle {
    public int[] countPoints(int[][] points, int[][] queries) {

        int q = queries.length;
        int[] ans = new int[q];

        for (int i = 0; i < q; i++) {

            for (int j = 0; j < points.length; j++) {
                // if the distance is less than the radius then the point is inside the circle, if distance is equal to the circle then the point is on the border
                // if the distance is larger than the radius then the point is outside the circle
                if (getDistance(points[j], queries[i]) <= queries[i][2]) {
                    ans[i] += 1;
                }
            }
        }
        return ans;
    }

    public double getDistance(int[] point, int[] center) {
        int x = point[0];
        int y = point[1];
        int h = center[0];
        int k = center[1];

        return Math.sqrt(Math.pow((x - h), 2) + Math.pow((y - k), 2));
    }
}