package Trie;

import DP_Tree.TreeNode;

public class Trie {

    public static class TrieNode {
        boolean isEndofWord;
        TrieNode[] children = new TrieNode[26];
    }
    public TrieNode getNode(){
        TrieNode newNode = new TrieNode();

        newNode.isEndofWord = false;
        for(int i = 0; i < 26; i++){
            newNode.children[i] = null;
        }
        return newNode;
    }


    TrieNode root;

    public Trie() {
        root = getNode();
    }
    public void insert(String word) {
        TrieNode crawler = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(crawler.children[idx] == null){
                crawler.children[idx] = getNode();
            }
            crawler = crawler.children[idx];
        }

        crawler.isEndofWord = true;
    }

    public boolean search(String word) {
        TrieNode crawler = root;
        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(crawler.children[idx] == null){
                return false;
            }
            crawler = crawler.children[idx];
        }
        return crawler != null && crawler.isEndofWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode crawler = root;
        int i = 0;
        for(char ch : prefix.toCharArray()){
            int idx = ch - 'a';

            if(crawler.children[idx] == null){
                return false;
            }
            crawler = crawler.children[idx];
            i++;
        }

        return i == prefix.length();
    }
}
