// https://www.codechef.com/problems/FAIRELCT
package All_Problems;

import java.util.ArrayList;
import java.util.List;

public class FairElections {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(3);
        A.add(2);
        A.add(4);

        List<Integer> B = new ArrayList<>();
        B.add(6);
        B.add(7);
        B.add(8);

        System.out.println(getMinSwaps(A, B));
    }

    public static int getMinSwaps(List<Integer> A, List<Integer> B) {
        int voteCountA = 0;
        for (int i : A) voteCountA += i;
        int voteCountB = 0;
        for (int i : B) voteCountB += i;

        // Sorting John votes in ascending order
        A.sort((a, b) -> a - b);
        // Sorting Jack votes in descending order
        B.sort((a, b) -> b - a);

        int swapCount = 0;

        int i = 0;
        while (voteCountA < voteCountB) {
            int temp = A.get(i);
            A.set(i, B.get(i));
            B.set(i, temp);

            // Updating the new votes
            voteCountA += (A.get(i) - B.get(i));
            voteCountB += (B.get(i) - A.get(i));
            swapCount++;
            i++;
        }

        return (swapCount);
    }
}
