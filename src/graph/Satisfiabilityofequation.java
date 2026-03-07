package graph;

public class Satisfiabilityofequation {
    int[] parent;
    int[] rank;
    public boolean equationsPossible(String[] equations) {
        this.parent = new int[26];
        this.rank = new int[26];
        for(int i = 0; i < 26; i++){
            parent[i] = i;
            rank[i] = 1;
        }

        for(String s: equations){
            if(s.charAt(1) == '='){
                union(s.charAt(0)-'a',s.charAt(3)-'a');
            }
        }
        for(String s: equations){
            if(s.charAt(1) == '!'){
                int x = find(s.charAt(0)-'a');
                int y = find(s.charAt(3)-'a');
                if(x == y){
                    return false;
                }
            }
        }
        return true;
    }
    public int find(int i){
        if(parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }

    public void union(int x , int y){
        int parent_x = find(x);
        int parent_y = find(y);
        if(parent_x == parent_y) return;
        if(rank[parent_x] > rank[parent_y]){
            parent[parent_y] = parent_x;
        }
        else if(rank[parent_y] > rank[parent_x]){
            parent[parent_x] = parent_y;
        }
        else{
            parent[parent_y] = parent_x;
            rank[parent_x]++;
        }
    }
}
