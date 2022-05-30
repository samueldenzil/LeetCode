package All_Problems;

public class RearrangeCharactersToMakeTargetString {

    public static void main(String[] args) {
        String s = "ilovecodingonleetcode", target = "code";
        System.out.println(rearrangeCharacters(s, target));
    }

    public static int rearrangeCharacters(String s, String target) {
        int[] sLetters = new int[26];
        int[] targetLetters = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            sLetters[c - 'a']++;
        }

        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            targetLetters[c - 'a']++;
        }

        int copies = 100;

        for (int i = 0; i < 26; i++) {
            if (targetLetters[i] == 0)
                continue;
            copies = Math.min(copies, sLetters[i] / targetLetters[i]);
        }

        return copies;
    }
}
