package Leetcode_daily;

public class transform_binary_string {
//    int n;
//    String s1;
//    String s2;
//    Integer[][][] dp;
//    public int minOperations(String s1, String s2) {
//        char initialCurrent = s1.charAt(0);
//        this.n = s1.length();
//        char nextCurrent = (n > 1) ? s1.charAt(1) : '0';
//        this.s1 = s1;
//        this.s2 = s2;
//        this.dp = new Integer[n][2][2];
//        return solve(0,initialCurrent,nextCurrent);
//    }
//    public int solve(int i,char currentBit,char nextBit){
//        if(i >= n) return 0;
//
//        if(dp[i][currentBit-'0'][nextBit-'0'] != null){
//            return dp[i][currentBit-'0'][nextBit-'0'];
//        }
//
//        char futureBit = (i + 2 < n) ? s1.charAt(i + 2) : '0';
//        int cost = (int) 1e9;
//
//        if(currentBit == s2.charAt(i)){
//            cost = solve(i+1,nextBit,futureBit);
//        }
//        else if(currentBit == '0' && s2.charAt(i) == '1'){
//            cost = 1 + solve(i+1,nextBit,futureBit);
//        }
//        else if(currentBit == '1' && s2.charAt(i) == '0'){
//            if(nextBit == '1'){
//                cost =  1 + solve(i+1,'0',futureBit);
//            }
//            else{
//                cost =  1 + solve(i,currentBit,'1');
//            }
//        }
//        dp[i][currentBit-'0'][nextBit-'0'] = cost;
//        return cost;
//    }

    public int minOperations(String s1, String s2) {
        if(s1.equals(s2)) return 0;
        int n = s1.length();
        char[] s = s1.toCharArray();
        char[] t = s2.toCharArray();
        int ops = 0;
        for(int i = 0; i < n; i++){
            if(s[i] == '0' && t[i] == '1'){
                ops++;
                s[i] = '1';
            }
        }

        int i = 0;
        while(i < n){
            int j = i;
            if(s[i] == t[i]){
                i += 1;
                continue;
            }

            while(j < n && t[j] == '0'){
                j++;
            }

            int k = i;
            while (k < j){
                if(s[k] == '0'){
                    k++;
                    continue;
                }

                int jend = k;
                while(jend < j && s[jend] == '1'){
                    jend += 1;
                }

                ops += (jend-k)/2;

                if(((jend-k) & 1) != 0){
                    ops += 2;
                }

                k = jend;
            }
            i = j;
        }

        return ops;
    }
}
