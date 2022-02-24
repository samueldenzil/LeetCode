// https://leetcode.com/problems/excel-sheet-column-number/
package All_Problems;

public class ExcelSheetColumnNumber {

    public static void main(String[] args) {
        String columnTitle = "AB";
        System.out.println(titleToNumber(columnTitle));
    }

    public static int titleToNumber(String columnTitle) {
        int columnNumber = 0;

        int power = 0;
        for (int i = columnTitle.length() - 1; i >= 0; i--) {
            char c = columnTitle.charAt(i);

            columnNumber += (c - 'A' + 1) * Math.pow(26, power);
            power++;
        }

        return columnNumber;
    }
}
