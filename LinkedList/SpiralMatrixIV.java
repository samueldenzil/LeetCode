// https://leetcode.com/problems/spiral-matrix-iv/
package LinkedList;

import java.util.Arrays;

public class SpiralMatrixIV {

    public static void main(String[] args) {
        int m = 3;
        int n = 5;
        int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        ListNode head = generateLinkedList(arr);

        int[][] ans = spiralMatrix(m, n, head);

        for (int[] row : ans) {
            System.out.println(Arrays.toString(row));
        }
    }

    private static ListNode generateLinkedList(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            head.next = new ListNode(arr[i]);
            head = head.next;
        }

        return temp;
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        ListNode temp = head;

        int top = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;

        int count = 0;
        int val = 0;
        int length = m * n;
        int direction = 0;

        // 0 = left -> right
        // 1 = top -> down
        // 2 = right -> left
        // 3 = down -> top

        while (count < length) {
            if (direction == 0) {
                // going from left to right
                for (int i = left; i <= right; i++) {
                    if (temp != null) {
                        val = temp.val;
                        temp = temp.next;
                    } else {
                        val = -1;
                    }
                    ans[top][i] = val;
                    count++;
                }
                // after going from left to right, I want to go one step down
                top += 1;
            } else if (direction == 1) {
                // going from top to down
                for (int i = top; i <= down; i++) {
                    if (temp != null) {
                        val = temp.val;
                        temp = temp.next;
                    } else {
                        val = -1;
                    }
                    ans[i][right] = val;
                    count++;
                }
                // after going from top to down, I want to go one step to the left
                right -= 1;
            } else if (direction == 2) {
                // going from right to left
                for (int i = right; i >= left; i--) {
                    if (temp != null) {
                        val = temp.val;
                        temp = temp.next;
                    } else {
                        val = -1;
                    }
                    ans[down][i] = val;
                    count++;
                }
                // after going from right to left, I want to go one step to the top
                down -= 1;
            } else if (direction == 3) {
                // going from down to top
                for (int i = down; i >= top; i--) {
                    if (temp != null) {
                        val = temp.val;
                        temp = temp.next;
                    } else {
                        val = -1;
                    }
                    ans[i][left] = val;
                    count++;
                }
                // after going from down to top, I want to go one step to the left
                left += 1;
            }

            direction += 1;
            direction %= 4;
        }

        return ans;
    }
}
