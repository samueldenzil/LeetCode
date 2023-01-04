// https://leetcode.com/problems/delete-columns-to-make-sorted/
package All_Problems;

public class DeleteColumnsToMakeSorted {

    public static void main(String[] args) {
        String[] strs = {"cba", "daf", "ghi"};
        System.out.println(minDeletionSize(strs));
    }

    public static int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int removeCount = 0;

        for (int j = 0; j < m; j++) {
            int max = 0;
            for (int i = 0; i < n; i++) {
                char ch = strs[i].charAt(j);
                if (ch - 'a' < max) {
                    removeCount++;
                    break;
                } else {
                    max = ch - 'a';
                }
            }
        }

        return removeCount;
    }
}
