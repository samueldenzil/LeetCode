// https://leetcode.com/problems/container-with-most-water/
package All_Problems;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int area = 0;

        while (left <= right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int tempArea = h * w;
            area = Math.max(area, tempArea);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return area;
    }
}
