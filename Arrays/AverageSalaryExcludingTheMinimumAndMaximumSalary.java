// https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/
package Arrays;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {

    public static void main(String[] args) {
        int[] salary = {4000, 3000, 1000, 2000};
        System.out.println(average(salary));
    }

    public static double average(int[] salary) {
        int minSalary = Integer.MAX_VALUE;
        int maxSalary = Integer.MIN_VALUE;
        int sum = 0;

        for (int it : salary) {
            sum += it;
            minSalary = Math.min(minSalary, it);
            maxSalary = Math.max(maxSalary, it);
        }

        return (double) (sum - minSalary - maxSalary) / (double) (salary.length - 2);
    }
}
