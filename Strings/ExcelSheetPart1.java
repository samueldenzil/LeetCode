// https://practice.geeksforgeeks.org/problems/excel-sheet5448/1
package Strings;

public class ExcelSheetPart1 {

    public static void main(String[] args) {
        int N = 52;
        System.out.println(excelColumn(N));
    }

    static public String excelColumn(int N){
        //  Your code here
        StringBuilder str = new StringBuilder();
        char[] alphabets = new char[27];
        for (int i = 1; i < alphabets.length; i++) {
            alphabets[i] = (char) ('A' + i - 1);
        }
        alphabets[0] = 'Z';

        while (N > 0) {
            int lastDigit = N % 26;
            str.append(alphabets[lastDigit]);
            if (N % 26 == 0) {
                N = (N / 26) - 1;
            } else {
                N = N / 26;
            }
        }

        return str.reverse().toString();
    }
}
