package graph;

public class DSU_BY_SIZE {
    static int[] parent = new int[101];
    static int[] size = new int[101];

    public static void main(String[] args) {
        for(int i = 0; i < 101; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }

    public int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y){
        int parent_x = find(x);
        int parent_y = find(y);

        if(parent_x == parent_y) return;

        if(size[parent_x] > size[parent_y]){
            parent[parent_y] = parent_x;
            size[parent_x] += size[parent_y];
        }
        else if(size[parent_y] > size[parent_x]){
            parent[parent_x] = parent_y;
            size[parent_y] += size[parent_x];
        }
        else{
            parent[parent_y] = parent_x;
            size[parent_x] += size[parent_y ];
        }
    }
}
