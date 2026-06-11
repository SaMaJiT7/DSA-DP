package Trie_tree;

import java.util.Arrays;

public class Longest_Common_Suffix {
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsContainer.length;
        int n = wordsQuery.length;
        int[] result = new int[n];
        TrieNode root = new TrieNode(0);
        for (int i = 0; i < m; i++) {
            int idx = root.idx;
            if(wordsContainer[idx].length() > wordsContainer[i].length()) {
                root.idx = i;
            }
            insert(wordsContainer,i,root);
        }

        for(int i = 0; i < n; i++){
            result[i] = search(root,wordsQuery[i]);
        }

        return result;
    }

    public static class TrieNode {
        int idx;
        TrieNode[] children;

        TrieNode(int i) {
            this.idx = i;
            this.children = new TrieNode[26];
        }

    }


    public void insert(String[] wordsContainer, int i, TrieNode root) {
        String word = wordsContainer[i];
        int n = word.length();
        for (int index = n-1; index >= 0; index--) {

            int idx = word.charAt(index) - 'a';

            if (root.children[idx] == null) {
                root.children[idx] = new TrieNode(idx);
            }

            root = root.children[idx];

            if(wordsContainer[root.idx].length() > n){
                root.idx = i;
            }
        }
    }

    public int search(TrieNode root, String word){
        int result_idx = root.idx;
        int n = word.length();
        for(int i = n-1; i >= 0; i--){
            int ch_idx = word.charAt(i) - 'a';

            if (root.children[ch_idx] == null) {
                return result_idx;
            }
            root = root.children[ch_idx];

            result_idx = root.idx;
        }

        return result_idx;
    }

}
