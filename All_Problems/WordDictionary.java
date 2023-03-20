// https://leetcode.com/problems/design-add-and-search-words-data-structure/
package All_Problems;

public class WordDictionary {
    
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                crawler.children[idx] = new TrieNode();
            }
            crawler = crawler.children[idx];
        }
        crawler.isEndOfWord = true;
    }

    public boolean search(String word) {
        return helper(word, 0, root);
    }

    private boolean helper(String word, int i, TrieNode node) {
        // base case
        if (word.length() == i) {
            return node.isEndOfWord;
        }

        if (word.charAt(i) == '.') {
            for (int idx = 0; idx < node.children.length; idx++) {
                if (node.children[idx] != null && helper(word, i + 1, node.children[idx])) {
                    return true;
                }
            }
        } else {
            int idx = word.charAt(i) - 'a';
            return node.children[idx] != null && helper(word, i + 1, node.children[idx]);
        }

        return false;
    }

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
    }
}
