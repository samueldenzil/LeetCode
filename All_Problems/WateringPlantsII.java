// https://leetcode.com/problems/watering-plants-ii/
package All_Problems;

public class WateringPlantsII {

    public static void main(String[] args) {
        int[] plants = {1, 2, 4, 4, 5};
        int capacityA = 6;
        int capacityB = 5;
        System.out.println(minimumRefill(plants, capacityA, capacityB));
    }

    public static int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int i = 0;
        int j = plants.length - 1;
        int count = 0;
        int aliceCan = capacityA;
        int bobCan = capacityB;

        while (i < j) {
            if (needToRefill(aliceCan, plants[i])) {
                count++;
                aliceCan = capacityA;
            }
            aliceCan -= plants[i];
            i++;

            if (needToRefill(bobCan, plants[j])) {
                count++;
                bobCan = capacityB;
            }
            bobCan -= plants[j];
            j--;
        }

        if (i == j) {
            if (aliceCan >= bobCan) {
                if (needToRefill(aliceCan, plants[i])) {
                    count++;
                }
            } else {
                if (needToRefill(bobCan, plants[i])) {
                    count++;
                }
            }
        }

        return count;
    }

    private static boolean needToRefill(int available, int required) {
        return available < required;
    }
}
