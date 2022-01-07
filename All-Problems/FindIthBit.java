package Bitwise;

public class FindIthBit {

    public static void main(String[] args) {
        int a = 182;
        int i = 5;
        System.out.println(ithBit(a, i));
    }

    public static int ithBit(int n, int i) {
        int mask =  1 << (i - 1);
        return (n & mask);
    }
}
