// https://leetcode.com/problems/design-browser-history/
package All_Problems;

import java.util.ArrayList;
import java.util.List;

public class BrowserHistory_Stack {

    List<String> stack;
    int pointerIndex = 0;

    public BrowserHistory_Stack(String homepage) {
        stack = new ArrayList<>();
        stack.add(pointerIndex, homepage);
    }

    public void visit(String url) {
        pointerIndex += 1;
        stack.add(pointerIndex, url);
        int temp = pointerIndex;
        while (temp < stack.size() - 1) {
            stack.remove(temp + 1);
        }
        pointerIndex = stack.size() - 1;
    }

    public String back(int steps) {
        pointerIndex -= steps;
        if (pointerIndex < 0) {
            pointerIndex = 0;
        }
        return stack.get(pointerIndex);
    }

    public String forward(int steps) {
        pointerIndex += steps;
        if (pointerIndex >= stack.size()) {
            pointerIndex = stack.size() - 1;
        }
        return stack.get(pointerIndex);
    }

    public static void main(String[] args) {
        BrowserHistory_Stack browserHistory = new BrowserHistory_Stack("leetcode.com");
        // You are in "leetcode.com". Visit "google.com"
        browserHistory.visit("google.com");
        // You are in "google.com". Visit "facebook.com"
        browserHistory.visit("facebook.com");
        // You are in "facebook.com". Visit "youtube.com"
        browserHistory.visit("youtube.com");
        // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.back(1));
        // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(browserHistory.back(1));
        // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        System.out.println(browserHistory.forward(1));
        // You are in "facebook.com". Visit "linkedin.com"
        browserHistory.visit("linkedin.com");
        // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(browserHistory.forward(2));
        // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(browserHistory.back(2));
        // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
        System.out.println(browserHistory.back(7));
    }
}
