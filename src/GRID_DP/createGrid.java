package GRID_DP;

public class createGrid {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        for(int i = 0; i < m; i++){
            StringBuilder s = new StringBuilder();
            for(int j = 0; j < n; j++){
                if(i == m-1){
                    s.append('.');
                }
                else if(j == 0){
                    s.append('.');
                }
                else{
                    s.append('#');
                }
            }
            ans[i] = s.toString();
        }
        return ans;
    }
}
