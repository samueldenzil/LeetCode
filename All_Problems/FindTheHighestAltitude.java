// https://leetcode.com/problems/find-the-highest-altitude/
package All_Problems;

class FindTheHighestAltitude {

    public static void main(String[] args) {
        int[] gain = {-5, 1, 5, 0, -7};
        System.out.println(largestAltitude(gain));
    }

    public static int largestAltitude(int[] gain) {
        int maxAltitude = 0;
        int currAltitude = 0;

        for (int it : gain) {
            currAltitude += it;
            maxAltitude = Math.max(maxAltitude, currAltitude);
        }

        return maxAltitude;
    }
}
