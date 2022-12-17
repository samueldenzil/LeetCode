// https://leetcode.com/problems/implement-queue-using-stacks/
package All_Problems;

import java.util.Stack;

public class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.add(stack2.pop());
        }
        stack1.add(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.add(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
