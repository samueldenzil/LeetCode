package All_Problems;
class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            int n = accounts[i].length;
            for (int j = 0; j < n; j++) {
                arr[i] += accounts[i][j];
            }
        }

        int max = arr[0];
        for (int i = 1; i < m; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
