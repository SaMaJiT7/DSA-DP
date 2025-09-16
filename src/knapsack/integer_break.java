package knapsack;

public class integer_break {
    public int integerBreak(int n) {
        if(n == 1){
            return 0;
        }
        if(n == 2 || n == 3){
            return 1;
        }
    int[] t = new int[n+1];
        t[0] = 1;
        t[1] = 1;

        for(int i = 2; i <= n ; i++){
            for(int j = 1; j < i; j++){
                t[i] = Math.max(t[i], Math.max(j * (i - j), j * t[i - j]));
            }
        }
        return t[n];
    }
}
