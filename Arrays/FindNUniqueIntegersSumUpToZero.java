class Solution {
    public int[] sumZero(int n) {
        int[] temp = new int[n];
        for (int i = 0; i < n / 2; i++) {
            temp[i] = i + 1;
            temp[n - i - 1] = -(i + 1);
        }
        return temp;
    }
}
