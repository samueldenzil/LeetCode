// https://leetcode.com/problems/count-artifacts-that-can-be-extracted/
package Arrays;

public class CountArtifactsThatCanBeExtracted {

    public static void main(String[] args) {
        int n = 2;
        int[][] artifacts = {{0, 0, 0, 0}, {0, 1, 1, 1}};
        int[][] dig = {{0, 0}, {0, 1}};
        System.out.println(digArtifacts(n, artifacts, dig));
    }

    public static int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        int found = 0;
        boolean[][] uncovered = new boolean[n][n];

        for (int[] arr : dig) {
            uncovered[arr[0]][arr[1]] = true;
        }

        for (int[] artifact : artifacts) {
            boolean canBeDig = true;
            for (int i = artifact[0]; i <= artifact[2]; i++) {
                for (int j = artifact[1]; j <= artifact[3]; j++) {
                    if (!uncovered[i][j]) {
                        canBeDig = false;
                        break;
                    }
                }
            }
            if (canBeDig) found++;
        }

        return found;
    }
}
