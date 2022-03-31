// https://leetcode.com/problems/search-a-2d-matrix/
package Arrays;

public class SearchA2DMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        int target = 3;
        System.out.println(searchMatrix(matrix, target));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = n - 1;

        // According to the given properties it becomes very easy to find the row where the target is present
        // So first I am doing a binary search to find the correct row
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][m - 1]) {
                // Then search the target in this row
                // Again applying binary search to find the target in this row
                int[] row = matrix[mid];
                int s = 0;
                int e = m - 1;
                while (s <= e) {
                    int rowMid = s + (e - s) / 2;

                    if (target == row[rowMid]) {
                        return true;
                    } else if (target < row[rowMid]) {
                        e = rowMid - 1;
                    } else {
                        s = rowMid + 1;
                    }
                }
                return false;
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][m - 1]) {
                start = mid + 1;
            }
        }

        return false;
    }
}
