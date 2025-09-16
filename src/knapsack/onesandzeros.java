package knapsack;

public class onesandzeros {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] t = new int[m+1][n+1];

        for(String str : strs){
            int zero = 0; int one = 0;

            for(char c : str.toCharArray()){
                if(c == '0'){
                    zero++;
                }
                else {
                    one++;
                }
        }
            for (int i = m; i >= zero; i--) {
                for (int j = n; j >= one; j--) {
                    t[i][j] = Math.max(
                            t[i][j],
                            t[i - zero][j - one] + 1
                    );
                }
            }
        }
        return t[m][n];
    }
}
