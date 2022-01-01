package RecursionByStriver;

public class SumOfNUsingParameters {

    public static void sumOfN(int i, int sum) {
        if (i < 1) {
            System.out.println(sum);
            return;
        }

        sumOfN(i - 1, sum + i);
    }

    public static void main(String[] args) {
        int n = 10;
        int sum = 0;
        sumOfN(n, sum);
    }
}
