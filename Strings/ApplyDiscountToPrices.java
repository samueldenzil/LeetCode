// https://leetcode.com/problems/apply-discount-to-prices/
package Strings;

public class ApplyDiscountToPrices {

    public static void main(String[] args) {
        String sentence = "there are $1 $2 and 5$ candies in the shop";
        int discount = 50;
        System.out.println(discountPrices(sentence, discount));
    }

    public static String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            boolean flag = true;
            if (word.charAt(0) == '$') {
                for (int j = 1; j < word.length(); j++) {
                    char c = word.charAt(j);
                    if (c - '0' >= 0 && c - '9' <= 9) {
                        continue;
                    } else {
                        flag = false;
                        break;
                    }
                }
                if (!flag) continue;

                if (word.length() > 1) {
                    long price = Long.parseLong(word.substring(1));
                    double discountPrice = price - ((price * discount) / 100.0);
                    words[i] = "$" + String.format("%.2f", discountPrice);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(word);
            sb.append(" ");
        }
        sb.replace(sb.length() - 1, sb.length(), "");

        return sb.toString();
    }
}
