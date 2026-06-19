package Binary_Lifting;

import java.util.Arrays;

public class TreeAncestor {
    int[][] up;
    int LOG;
    public TreeAncestor(int n, int[] parent) {
        LOG = (int)(Math.ceil(Math.log(n) / Math.log(2))) + 1;
        up = new int[n][LOG];
        for(int[] val : up){
            Arrays.fill(val,-1);
        }
        for(int i = 0; i < n; i++){
            up[i][0] = parent[i];
        }

        for(int j = 1; j < LOG; j++){
            for(int node = 0; node < n; node++){
                if(up[node][j-1] != -1) {
                    up[node][j] = up[up[node][j - 1]][j - 1];
                }
            }
        }
    }

    public int getKthAncestor(int node, int k) {
        for(int j = LOG-1; j >= 0; j--){
            if((k & (1 << j))!= 0){
                node = up[node][j];
                if(node == -1) return -1;
            }
        }
        return node;
    }
}
