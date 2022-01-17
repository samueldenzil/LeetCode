package All_Problems;
class ProgramToCheckIfAnArrayIsFortedOrNot {
    
    public static boolean isReversed(int[] arr, int n) {
        // base case
        if (n == 0) {
            return true;
        }
        
        if (arr[n] < arr[n - 1]) { return false; }
        
        return isReversed(arr, n - 1);
    }
    
    public static void main(String[] args) {
        int[] arr = {20, 20, 78, 98, 99, 97};
        
        System.out.println(isReversed(arr, arr.length - 1));
        
    }
}
