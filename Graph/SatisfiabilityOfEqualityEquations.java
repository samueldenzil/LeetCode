// https://leetcode.com/problems/satisfiability-of-equality-equations/
package Graph;

public class SatisfiabilityOfEqualityEquations {

    public static void main(String[] args) {
        String[] equations = {"a==b", "b!=a"};
        System.out.println(equationsPossible(equations));
    }

    public static boolean equationsPossible(String[] equations) {
        // If a == b, then a's parent = a and b's parent = a
        // then if b == c, then since b's parent = a, then c's parent = a

        // We build the parent using Union Find

        // When we travel all != cases, if var1, var2 parent are same, but they have != relationship,
        // this is not possible return false
        // else return true

        int[] parent = new int[26];
        for (int i = 0; i < 26; i++) {
            parent[i] = i;  // initially all are their own parent
        }

        // first traverse all == cases to establish parent-child relationship
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int var1 = getParent(equation.charAt(0) - 'a', parent);
                int var2 = getParent(equation.charAt(3) - 'a', parent);

                if (var1 != var2) {
                    parent[var2] = var1;
                }
            }
        }

        // now traverse all != cases to check if any invalid equation exist
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int var1 = getParent(equation.charAt(0) - 'a', parent);
                int var2 = getParent(equation.charAt(3) - 'a', parent);

                if (var1 == var2) {
                    return false;
                }
            }
        }

        return true;
    }

    private static int getParent(int index, int[] parent) {
        if (parent[index] == index) {
            return index;
        }
        return getParent(parent[index], parent);
    }
}
