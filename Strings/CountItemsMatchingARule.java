package Strings;
// https://leetcode.com/problems/count-items-matching-a-rule/

import java.util.List;

class CountItemsMatchingARule {
    
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int rule = 0;
        if (ruleKey.equals("type")) {
            rule = 0;
        } else if (ruleKey.equals("color")) {
            rule = 1;
        } else {
            rule = 2;
        }

        int count = 0;
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).get(rule).equals(ruleValue)) {
                count++;
            }
        }
        return count;
        
        
        /* 
        * int count = 0;
        int i = 0;

        if (ruleKey.equals("type")) {
            i = 0;
            for (int j = 0; j < items.size(); j++) {
                if (items.get(i).get(j).equals(ruleValue)) {
                    count++;
                }
            }
        }

        if (ruleKey.equals("color")) {
            i = 1;
            for (int j = 0; j < items.size(); j++) {
                if (items.get(i).get(j).equals(ruleValue)) {
                    count++;
                }
            }
        }

        if (ruleKey.equals("name")) {
            i = 2;
            for (int j = 0; j < items.size(); j++) {
                if (items.get(i).get(j).equals(ruleValue)) {
                    count++;
                }
            }
        }

        return count;
         */
    }
}