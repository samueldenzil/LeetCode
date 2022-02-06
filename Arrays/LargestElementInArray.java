// https://practice.geeksforgeeks.org/problems/largest-element-in-array4009/1/
package Arrays;

class LargestElementInArray {

    public static void main(String[] args) {
        int[] arr = {1, 8, 7, 56, 90};
        System.out.println(largest(arr, arr.length));
    }
    
    public static int largest(int[] arr, int n) {
        int max = 0;
        
        for (int i = 0; i < n; i++) {
            if (max < arr[i])
                max = arr[i];
        }
        
        return max;
    }
}