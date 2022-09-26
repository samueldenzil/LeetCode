// https://leetcode.com/problems/design-circular-queue/
package Design;

class MyCircularQueue {

    int[] queue;
    int front, rear, length;

    public MyCircularQueue(int k) {
        queue = new int[k];
        front = 0;
        rear = -1;
        length = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        rear = (rear + 1) % queue.length;
        queue[rear] = value;
        length++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        queue[front] = 0;
        front = (front + 1) % queue.length;
        length--;
        return true;
    }

    public int Front() {
        return !isEmpty() ? queue[front] : -1;
    }

    public int Rear() {
        return !isEmpty() ? queue[rear] : -1;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public boolean isFull() {
        return length == queue.length;
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
        System.out.println(myCircularQueue.isFull());
        System.out.println(myCircularQueue.deQueue());
        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.Rear());
    }
}