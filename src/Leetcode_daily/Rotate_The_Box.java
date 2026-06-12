package Leetcode_daily;

public class Rotate_The_Box {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        for(char[] row : boxGrid){
            int j = n-1;
            for(int i = n-1; i >= 0; i--){
                if(row[i] == '.'){
                    continue;
                }
                if(row[i] == '*'){
                    j = i-1;
                }
                else if(row[i] == '#'){
                    if(j != i){   // optional optimization
                        char temp = row[j];
                        row[j] = row[i];
                        row[i] = temp;
                    }
                    j--;
                }
            }
        }
        char[][] ans = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                ans[i][j] = boxGrid[m-1-j][i];
            }
        }

        return ans;
    }
}
