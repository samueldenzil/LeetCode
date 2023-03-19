// https://leetcode.com/problems/design-browser-history/
package LinkedList;

class BrowserHistory {

    static class Node {
        String url;
        Node prev;
        Node next;

        Node(String url) {
            this.url = url;
            prev = null;
            next = null;
        }
    }

    private Node ptr;

    public BrowserHistory(String homepage) {
        ptr = new Node(homepage);
    }

    public void visit(String url) {
        ptr.next = new Node(url);
        ptr.next.prev = ptr;
        ptr = ptr.next;
    }

    public String back(int steps) {
        while (ptr.prev != null && steps-- > 0) {
            ptr = ptr.prev;
        }
        return ptr.url;
    }

    public String forward(int steps) {
        while (ptr.next != null && steps-- > 0) {
            ptr = ptr.next;
        }
        return ptr.url;
    }

    public static void main(String[] args) {
        BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
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