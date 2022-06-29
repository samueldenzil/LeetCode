// https://leetcode.com/problems/unique-email-addresses/
package Strings;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {

    public static void main(String[] args) {
        String[] emails = {"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();

        for (String email : emails) {
            String refactored = refactorEmail(email);
            set.add(refactored);
        }

        return set.size();
    }

    private static String refactorEmail(String email) {
        int n = email.length();
        StringBuilder sb = new StringBuilder();
        boolean isLocalName = true; // to check if we are inside local name or domain name

        for (int i = 0; i < n; i++) {
            char c = email.charAt(i);

            if (c == '.' && isLocalName) {
                continue;   // if we are still inside local name, and we encounter a . ignore it
            } else if (c == '+' && isLocalName) {
                // if we get + ignore all the remaining char in localname
                while (i + 1 < n && email.charAt(i + 1) != '@') {
                    i++;
                }
            } else {
                if (c == '@') {
                    isLocalName = false;
                }
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
