// https://leetcode.com/problems/construct-quad-tree/
package Trees;

public class ConstructQuadTree {

    public static void main(String[] args) {
        int[][] grid = {{0, 1}, {1, 0}};
        System.out.println(construct(grid));
    }

    public static Node construct(int[][] grid) {
        int n = grid.length;
        return helper(0, 0, n, grid);
    }

    private static Node helper(int x, int y, int n, int[][] grid) {
        if (isAllSame(x, y, n, grid)) {
            return new Node(grid[x][y] == 1, true);
        }

        Node root = new Node(grid[x][y] == 1, false);
        int half = n / 2;
        root.topLeft = helper(x, y, half, grid);
        root.topRight = helper(x, y + half, half, grid);
        root.bottomLeft = helper(x + half, y, half, grid);
        root.bottomRight = helper(x + half, y + half, half, grid);
        return root;
    }

    private static boolean isAllSame(int x, int y, int n, int[][] grid) {
        int val = grid[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (grid[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    private static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    }
}
