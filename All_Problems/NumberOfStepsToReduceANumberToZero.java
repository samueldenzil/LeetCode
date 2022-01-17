package All_Problems;
// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

class NumberOfStepsToReduceANumberToZero {
    public int numberOfSteps(int num) {
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
    }
}
