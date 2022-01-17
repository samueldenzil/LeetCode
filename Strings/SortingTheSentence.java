package Strings;
// https://leetcode.com/problems/sorting-the-sentence/

class SortingTheSentence {
    
    public String sortSentence(String s) {
        String[] strArr = s.split(" ");
        int i = 0;

        // applying cyclic sort
        while (i < strArr.length) {
            int intChar = (int) (strArr[i].charAt(strArr[i].length() - 1) - '0');
            if (i != intChar - 1) {
                String temp = strArr[i];
                strArr[i] = strArr[intChar - 1];
                strArr[intChar - 1] = temp;
            } else {
                i++;
            }
        }

        // removing the last digit from the String
        for (i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].substring(0, strArr[i].length() - 1);
        }

        // joining the array of strings to a String
        return String.join(" ", strArr);
    }
}