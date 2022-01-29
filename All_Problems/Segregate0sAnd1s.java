package All_Problems;

public class Segregate0sAnd1s {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 0};
        segregate0and1(arr, arr.length);
        for (int e : arr) {
            System.out.print(e + " ");
        }
    }

    static void segregate0and1(int[] arr, int n) {
        // code here
        int zeroCount = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                zeroCount++;
            }
        }

        for (int i = 0; i < zeroCount; i++) {
            arr[i] = 0;
        }
        for (int i = zeroCount; i < n; i++) {
            arr[i] = 1;
        }
    }
}
