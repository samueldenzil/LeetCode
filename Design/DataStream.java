// https://leetcode.com/problems/find-consecutive-integers-from-a-data-stream/
package Design;

public class DataStream {
    int count;
    int value;
    int k;

    public DataStream(int value, int k) {
        count = 0;
        this.value = value;
        this.k = k;
    }

    public boolean consec(int num) {
        if (num != value) {
            count = 0;
            return false;
        }

        count++;
        return count >= k;
    }

    public static void main(String[] args) {
        DataStream obj = new DataStream(1, 2);
        System.out.println(obj.consec(1));
        System.out.println(obj.consec(2));
        System.out.println(obj.consec(1));
        System.out.println(obj.consec(1));
        System.out.println(obj.consec(1));
    }
}

/**
 * Your DataStream object will be instantiated and called as such:
 * DataStream obj = new DataStream(value, k);
 * boolean param_1 = obj.consec(num);
 */