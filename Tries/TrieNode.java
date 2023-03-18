package Tries;

public class TrieNode {
    public boolean isEndOfWord;
    public TrieNode[] children;
    
    TrieNode() {
        this.isEndOfWord = false;
        this.children = new TrieNode[26];
    }
}