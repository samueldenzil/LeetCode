// https://leetcode.com/problems/design-browser-history/
package Design;

import java.util.Stack;

public class BrowserHistory_Stack {
    private Stack<String> stack1;
    private Stack<String> stack2;

    public BrowserHistory_Stack(String homepage) {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
        this.stack1.add(homepage);
    }

    public void visit(String url) {
        stack1.add(url);
        while (!stack2.isEmpty()) {
            stack2.pop();
        }
    }

    public String back(int steps) {
        while (stack1.size() > 1 && steps-- > 0) {
            stack2.add(stack1.pop());
        }
        return stack1.peek();
    }

    public String forward(int steps) {
        while (!stack2.isEmpty() && steps-- > 0) {
            stack1.add(stack2.pop());
        }
        return stack1.peek();
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
