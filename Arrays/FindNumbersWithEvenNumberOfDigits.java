package Arrays;

// Improved version of the code
class FindNumbersWithEvenNumberOfDigits {
    public int findNumbers(int[] nums) {
        int evenDigitCount = 0;
        for (int element : nums) {
            if (getDigit(element) % 2 == 0) {
                evenDigitCount++;
            }
        }
        return evenDigitCount;
    }

    public int getDigit(int num) {
        return (int)(Math.log10(num) + 1);
    }
}

/* You can even try this
num = 1234;
String numStr = num + "";
System.out.println(numStr.length()); */

/* class Solution {
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
} */

