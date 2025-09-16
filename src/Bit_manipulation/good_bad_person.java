package Bit_manipulation;

public class good_bad_person {
    public static void main(String[] args) {
        int[][] statements = {{2,1,2},{1,2,2},{2,0,2}};
        System.out.println(maximumGood(statements));
    }
    public static int maximumGood(int[][] statements) {
        int n = statements.length;
        int ans = 0;

        for(int mask=0; mask < (1<<n);mask++) {
            boolean flag = true;
            for(int i = 0; i<n;i++){
                if((mask & (1<<i)) == 0){
                    continue;
                }
                for(int j = 0; j < n;j++){
                    boolean good = ((mask & (1 << j)) != 0);
                    if((statements[i][j] == 1 && !good) || (statements[i][j] == 0 && good)){
                        flag = false;
                        break;
                    }
                }
                if(!flag) break;
            }
            if(flag == true){
                ans =Math.max(ans,Integer.bitCount(mask));
            }
        }
        return ans;
    }
}
