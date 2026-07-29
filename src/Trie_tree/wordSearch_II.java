package Trie_tree;

import java.util.ArrayList;
import java.util.List;

public class wordSearch_II {
    int m;
    int n;
    List<String> answer;
    int[] dx = {1,-1,0,0};
    int[] dy = {0,0,1,-1};
    public List<String> findWords(char[][] board, String[] words) {
        this.m = board.length;
        this.n = board[0].length;
        this.answer = new ArrayList<>();
        TrieNode root = getNode();
        for(String word : words){
            insert(root,word);
        }
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
               int ch = board[i][j] - 'a';

                if(root.children[ch] != null){
                    findword(board,i,j,root);
                }
            }
        }
        return answer;
    }

    public void findword(char[][] board,int x,int y,TrieNode root){
        if(x < 0 || x >= m || y < 0 || y >= n) return;
        char curr = board[x][y];
        if(curr == '#' || root.children[curr - 'a'] == null) return;

        root = root.children[curr-'a'];
        if(root.isEndofWord){
            answer.add(root.Word);
            root.isEndofWord = false;
        }

        board[x][y] = '#';
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            findword(board,nx,ny,root);
        }
        board[x][y] = curr;
    }

    public class TrieNode{
        String Word;
        boolean isEndofWord;
        TrieNode[] children = new TrieNode[26];

    }
    public TrieNode getNode(){
        TrieNode newNode = new TrieNode();

        newNode.isEndofWord = false;
        newNode.Word = "";
        for(int i = 0; i < 26; i++){
            newNode.children[i] = null;
        }
        return newNode;
    }


    public void insert(TrieNode root,String word){
        TrieNode crawler = root;

        for(char ch : word.toCharArray()){
            int idx = ch - 'a';

            if(crawler.children[idx] == null){
                crawler.children[idx] = getNode();
            }
            crawler = crawler.children[idx];
        }

        crawler.Word = word;
        crawler.isEndofWord = true;
    }
}
