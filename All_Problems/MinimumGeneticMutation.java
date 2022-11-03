// https://leetcode.com/problems/minimum-genetic-mutation/
package All_Problems;

import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.LinkedList;

public class MinimumGeneticMutation {

    public static void main(String[] args) {
        String startGene = "AACCGGTT", endGene = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};
        System.out.println(minMutation(startGene, endGene, bank));
    }

    public static int minMutation(String start, String end, String[] bank) {
        char[] validChars = {'A', 'C', 'G', 'T'};

        Set<String> set = new HashSet<>();
        for (String s : bank) {
            set.add(s);
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(start, 0));

        // BFS - similar to word ladder 1
        while (!queue.isEmpty()) {
            String word = queue.peek().word;
            int steps = queue.peek().steps;
            queue.poll();

            if (word.equals(end)) {
                return steps;
            }

            for (int i = 0; i < word.length(); i++) {
                char[] charArr = word.toCharArray();
                for (char c : validChars) {
                    charArr[i] = c;
                    String newWord = new String(charArr);

                    if (set.contains(newWord)) {
                        queue.add(new Pair(newWord, steps + 1));
                        set.remove(newWord);
                    }
                }
            }
        }

        return -1;
    }

    static class Pair {
        String word;
        int steps;

        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
}
