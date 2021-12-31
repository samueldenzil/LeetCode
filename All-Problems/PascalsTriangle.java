// https://leetcode.com/problems/pascals-triangle/

class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        
        List<List<Integer>> dpList = new ArrayList<>();
        
        // base case
        // ans if numRows = 1
        List<Integer> dp1 = new ArrayList<>();
        dp1.add(1);
        dpList.add(dp1);
        
        if (numRows == 1) {
            return dpList;
        }
        
        // ans if numRows = 2
        List<Integer> dp2 = new ArrayList<>();
        dp2.add(1);
        dp2.add(1);
        dpList.add(dp2);
        
        for (int i = 2; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();
            // inserting the first element
            row.add(1);
            
            for (int j = 0; j < i - 1; j++) {
                List<Integer> prevRow = dpList.get(i - 1);
                row.add(prevRow.get(j) + prevRow.get(j + 1));
            }
            
            // inserting the last element
            row.add(1);
            
            dpList.add(row);
        }
        
        return dpList;
    }
}