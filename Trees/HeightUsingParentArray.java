// https://practice.geeksforgeeks.org/problems/height-using-parent-array4103/1
package Trees;

public class HeightUsingParentArray {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 0, 1, 1, 3, 5};
        System.out.println(findHeight(arr.length, arr));
    }

    static int findHeight(int N, int[] arr){
        // code here
        int height = 1;
        int i = N - 1;

        while (arr[i] != -1) {
            i = arr[i];
            height++;
        }

        return height;
    }
}
