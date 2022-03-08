// https://leetcode.com/problems/cells-in-a-range-on-an-excel-sheet/
package All_Problems;

import java.util.List;
import java.util.ArrayList;

public class CellsInARangeOnAnExcelSheet {

    public static void main(String[] args) {
        String s = "K1:L2";
        System.out.println(cellsInRange(s));
    }

    public static List<String> cellsInRange(String s) {
        List<String> ans = new ArrayList<>();

        char col1 = s.charAt(0);
        int row1 = s.charAt(1) - '0';
        char col2 = s.charAt(3);
        int row2 = s.charAt(4) - '0';

        int totalCol = col2 - col1 + 1;
        int totalRow = row2 - row1 + 1;

        for (int i = 0; i < totalCol; i++) {
            for (int j = 0; j < totalRow; j++) {
                StringBuilder sb = new StringBuilder();
                sb.append((char) (col1 + i));
                sb.append(row1 + j);
                ans.add(sb.toString());
            }
        }

        return ans;
    }
}
