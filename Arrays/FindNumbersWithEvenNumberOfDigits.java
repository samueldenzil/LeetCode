class Solution {
    public int findNumbers(int[] nums) {
        int evenDigitCounter = 0;
        for (int element : nums) {
            if (getDigits(element) % 2 == 0) {
                evenDigitCounter++;
            }
        }
        return evenDigitCounter;
    }

    public int getDigits(int num) {
        int count = 0;
        while (num > 0) {
            num /= 10;
            count++;
        }
        return count;
    }
}
