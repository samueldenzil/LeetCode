//package Sorting;
//
//import java.util.Arrays;
//
//public class KthSmallestElement {
//
//    public static void main(String[] args) {
//        int[] arr = {7, 10, 4, 20, 15};
//        int k = 4;
//        System.out.println(kthSmallest(arr, 0, arr.length, k));
//    }
//
//    public static int kthSmallest(int[] arr, int l, int r, int k) {
//        Arrays.sort(arr);
//
//    }
//
//    /* public static int kthSmallest(int[] arr, int l, int r, int k) {
//        //Your code here
//        for (int i = 0; i < arr.length; i++) {
//            boolean flag = false;
//            for (int j = 0; j < arr.length - i - 1; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                    flag = true;
//                }
//            }
//
//            if (!flag) break;
//        }
//
//        return arr[k - 1];
//    } */
//}
