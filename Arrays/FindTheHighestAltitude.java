class Solution {
    public int largestAltitude(int[] gain) {

        int initialAltitude = 0;
        int finalAltitude = 0;
        int[] temp = new int[gain.length + 1];

        for (int i = 0; i < gain.length; i++) {
            finalAltitude = gain[i] + initialAltitude;
            temp[i + 1] = finalAltitude;
            initialAltitude = finalAltitude;
        }

        int max = temp[0];
        for (int i = 1; i < temp.length; i++) {
            if (max < temp[i]) {
                max = temp[i];
            }
        }
        return max;
    }
}
