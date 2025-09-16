package MCM_DP;

import java.util.Arrays;

public class parenthsizaion {
    static int[][][] t = new int[1001][1001][2];
    public static void main(String[] args) {
        String s  = "T|F^F&T|F&T";
        for (int i = 0; i < 1001; ++i)
            for (int j = 0; j < 1001; ++j)
                Arrays.fill(t[i][j], -1);
        System.out.println(parenthesization1(s,0,s.length()-1,1));
    }

//    public static int parenthesization1(String s , int i , int j , boolean isTrue){
//        char[] sb = s.toCharArray();
//        if(i > j){
//            return 0;
//        }
//        if(i == j){
//            if(isTrue) return sb[i] == 'T' ? 1 : 0;
//            else return sb[i] == 'F' ? 1 : 0;
//        }
//        int ans = 0;
//        for(int k = i+1; k < j-1 ; k=k+2){
//            int LT = parenthesization1(s,i,k-1,true);
//            int LF = parenthesization1(s,i,k-1,false);
//            int RT = parenthesization1(s,k+1,j,true);
//            int RF = parenthesization1(s,k+1,j,false);
//
//            //now we have to check what the operator and work accordingly
//
//            if(sb[k] == '&'){
//                if(isTrue == false){
//                    ans = ans + LF * RF + LT * RF + LF * RT;
//                }
//                else {
//                    ans = ans + LT * RT;
//                }
//            }
//            if(sb[k] == '|'){
//                if(isTrue){
//                    ans = ans + LT * RT + LT * RF + LF * RT ;
//                }
//                else {
//                    ans += LF * RF;
//                }
//            }
//            if(sb[k] == '^'){
//                if (isTrue){
//                    ans = ans + LT * RF + LF * RT;
//                }
//                else {
//                    ans = ans + LT * RT + LF * RF;
//                }
//            }
//    }
//        return ans;
//    }


    public static int parenthesization1(String s , int i , int j , int isTrue) {
        char[] sb = s.toCharArray();
        if (t[i][j][isTrue] != -1){
            return t[i][j][isTrue];
        }

        if(i>j) {
            return t[i][j][isTrue] = 0;
        }

        if(i == j){
            if(isTrue == 1){
                if(sb[i] == 'T'){
                    return t[i][j][isTrue] = 1;
                }
                else {
                   return t[i][j][isTrue] = 0;
                }
            }
            else if(isTrue == 0) {
                if (sb[i] == 'F'){
                    return t[i][j][isTrue] = 1;
                }
                else {
                    return t[i][j][isTrue] = 0;
                }
            }
        }
        int ans = 0;
        for(int k = i+1; k < j-1 ; k=k+2){
            int LT,LF,RT,RF;
            if(t[i][k-1][1] == -1){
                return t[i][k-1][1];
            }else{
                LT = parenthesization1(s,i,k-1,1);
                t[i][k-1][1] = LT;
            }

            if(t[i][k-1][0] == -1){
                return t[i][k-1][0];
            }else{
                LF = parenthesization1(s,i,k-1,0);
                t[i][k-1][0] = LF;
            }

            if(t[k+1][j][1] == -1){
                return t[k+1][j][1];
            }else{
                RT = parenthesization1(s,k+1,j,1);
                t[i][k-1][1] = RT;
            }

            if(t[k+1][j][0] == -1){
                return t[k+1][j][0];
            }else{
                RF = parenthesization1(s,k+1,j,0);
                t[i][k-1][0] = RF;
            }


            //now we have to check what the operator and work accordingly

            if(sb[k] == '&'){
                if(isTrue == 0){
                    ans = ans + LF * RF + LT * RF + LF * RT;
                }
                else if (isTrue == 1) {
                    ans = ans + LT * RT;
                }
            }
            if(sb[k] == '|'){
                if(isTrue == 1){
                    ans = ans + LT * RT + LT * RF + LF * RT ;
                }
                else if(isTrue == 0) {
                    ans += LF * RF;
                }
            }
            if(sb[k] == '^'){
                if(isTrue == 1){
                    ans = ans + LT * RF + LF * RT;
                }
                else if(isTrue == 0) {
                    ans = ans + LT * RT + LF * RF;
                }
            }
        }
        return t[i][j][isTrue] = ans % 1003;
    }

}
