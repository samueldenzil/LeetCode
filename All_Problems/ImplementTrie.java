// https://leetcode.com/problems/implement-trie-prefix-tree/
package All_Problems;

public class ImplementTrie {

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // return True
        System.out.println(trie.search("app"));     // return False
        System.out.println(trie.startsWith("app"));      // return True
        trie.insert("app");
        System.out.println(trie.search("app"));     // return True
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode crawler = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }

            crawler = crawler.children[idx];
        }

        return crawler != null && crawler.isEndOfWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (crawler.children[idx] == null) {
                return false;
            }

            crawler = crawler.children[idx];
        }
        return true;
    }
}
