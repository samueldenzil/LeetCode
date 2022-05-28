package Recursion;

// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

class NumberOfStepsToReduceANumberToZero {

    public static void main(String[] args) {
        int num = 14;
        System.out.println(numberOfSteps(num));
    }

    public static int numberOfSteps(int num) {
        // base case
        if (num == 0) {
            return 0;
        }

        return 1 + (num % 2 == 0 ? numberOfSteps(num / 2) : numberOfSteps(num - 1));
    }

    /* public int numberOfSteps(int num) {
        return countSteps(num, 0);
    }
    
    public int countSteps(int num, int count) {
        // base condition
        if (num == 0) {
            return count;
        }
        
        if (num % 2 == 0) {
            return countSteps(num / 2, count + 1);
        } else {
            return countSteps(num - 1, count + 1);
        }
    } */

    /* public static int numberOfSteps(int num) {
        int count = 0;

        while (num > 0) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num--;
            }
            count++;
        }

        return count;
    } */
}
