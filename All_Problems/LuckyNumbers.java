package All_Problems;
// https://practice.geeksforgeeks.org/problems/lucky-numbers2911/1
// Microsoft

public class LuckyNumbers {

    public static void main(String[] args) {
        int n = 100000;
        System.out.println(isLucky(n));
    }

    public static boolean isLucky(int n) {
        return helperFunction(n, 2);
    }

    public static boolean helperFunction(int n, int counter) {
        if (n % counter == 0) {
            // the number n is deleted
            return false;
        }
        if (counter > n) {
            // the counter is greater than n and up till now n is not deleted
            return true;
        }

        int newN = n - n / counter;

        return helperFunction(newN, counter + 1);
    }

    /* Method 1 - which is not a good approach
    public static boolean isLucky(int n) {
        // Your code here
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(i, i + 1);
        }
        return helperFunction(n, arr, 2);
    }

    public static boolean helperFunction(int n, ArrayList<Integer> arr, int counter) {
        if (counter > arr.size()) {
            return arr.contains(n);
        }
        int incrementer = counter - 1;
        for (int i = incrementer; i < arr.size(); i += incrementer) {
            arr.remove(i);
        }

        return helperFunction(n, arr, counter + 1);
    }
    */
}
