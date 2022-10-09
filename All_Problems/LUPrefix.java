// https://leetcode.com/problems/longest-uploaded-prefix/
package All_Problems;

public class LUPrefix {

    public boolean[] prefix;
    public int ptr = 0;

    public LUPrefix(int n) {
        prefix = new boolean[n + 1];
    }

    public void upload(int video) {
        prefix[video] = true;
    }

    public int longest() {
        while (ptr + 1 < prefix.length && prefix[ptr + 1]) {
            ptr++;
        }
        return ptr;
    }

    public static void main(String[] args) {
        LUPrefix server = new LUPrefix(4);   // Initialize a stream of 4 videos.
        server.upload(3);                    // Upload video 3.
        System.out.println(server.longest());                    // Since video 1 has not been uploaded yet, there is no prefix.
        // So, we return 0.
        server.upload(1);                    // Upload video 1.
        System.out.println(server.longest());                    // The prefix [1] is the longest uploaded prefix, so we return 1.
        server.upload(2);                    // Upload video 2.
        System.out.println(server.longest());       // The prefix [1,2,3] is the longest uploaded prefix, so we return 3.
    }
}