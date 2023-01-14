// https://leetcode.com/problems/categorize-box-according-to-criteria/
package All_Problems;

public class CategorizeBoxAccordingToCriteria {

    public static void main(String[] args) {
        int length = 1000, width = 35, height = 700, mass = 300;
        System.out.println(categorizeBox(length, width, height, mass));
    }

    public static String categorizeBox(int length, int width, int height, int mass) {
        boolean bulky = isBulky(length, width, height);
        boolean heavy = isHeavy(mass);

        if (bulky && heavy) {
            return "Both";
        } else if (bulky) {
            return "Bulky";
        } else if (heavy) {
            return "Heavy";
        }
        return "Neither";
    }

    private static boolean isBulky(int length, int width, int height) {
        long volume = (long) length * width * height;

        System.out.println(volume);
        if (volume >= 1e9) {
            return true;
        } else {
            return length >= 1e4 || width >= 1e4 || height >= 1e4;
        }
    }

    private static boolean isHeavy(int mass) {
        return mass >= 100;
    }
}
