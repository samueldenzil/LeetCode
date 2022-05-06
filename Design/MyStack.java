// https://leetcode.com/problems/implement-stack-using-queues/
package Design;

import java.util.Queue;
import java.util.LinkedList;

public class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue1.add(x);
    }

    public int pop() {
        int size = queue1.size();
        int popped = 0;
        // copying the contents of queue1 to queue2
        while (!queue1.isEmpty()) {
            popped = queue1.poll();
            queue2.add(popped);
        }

        int i = 1;
        // copying back the contents from queue2 to queue1 except the last element except the last item
        while (i < size && !queue2.isEmpty()) {
            queue1.add(queue2.poll());
            i++;
        }
        queue2.poll();

        return popped;
    }

    public int top() {
        int size = queue1.size();
        int top = 0;
        // copying the contents of queue1 to queue2
        while (!queue1.isEmpty()) {
            top = queue1.poll();
            queue2.add(top);
        }

        // copying back the contents from queue2 to queue1 except the last element
        while (!queue2.isEmpty()) {
            queue1.add(queue2.poll());
        }

        return top;
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top());
        System.out.println(myStack.pop());
        System.out.println(myStack.empty());
    }
}