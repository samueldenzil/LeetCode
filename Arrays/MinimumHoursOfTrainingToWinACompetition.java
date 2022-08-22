// https://leetcode.com/problems/minimum-hours-of-training-to-win-a-competition/
package Arrays;

public class MinimumHoursOfTrainingToWinACompetition {

    public static void main(String[] args) {
        int initialEnergy = 5, initialExperience = 3;
        int[] energy = {1, 4, 3, 2};
        int[] experience = {2, 6, 3, 1};
        System.out.println(minNumberOfHours(initialEnergy, initialExperience, energy, experience));
    }

    public static int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int ans = 0;

        int start = 0;
        int end = 10000;
        int en = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (minEnergy(initialEnergy + mid, energy)) {
                en = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans += en;

        start = 0;
        end = 10000;
        int exp = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (minExperience(initialExperience + mid, experience)) {
                exp = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        ans += exp;

        return ans;
    }

    private static boolean minEnergy(int en, int[] energy) {
        int n = energy.length;
        for (int i = 0; i < n; i++) {
            if (en <= energy[i]) {
                return false;
            }
            en -= energy[i];
        }
        return true;
    }

    private static boolean minExperience(int exp, int[] experience) {
        int n = experience.length;
        for (int i = 0; i < n; i++) {
            if (exp <= experience[i]) {
                return false;
            }
            exp += experience[i];
        }
        return true;
    }
}
