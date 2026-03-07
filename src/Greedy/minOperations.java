package Greedy;

public class minOperations {
    public int minOperations(String s) {
        int count0 = 0;
        int count1 = 0;
        int n = s.length();
       for(int i = 0; i < n; i++){

           if(s.charAt(i) != (i % 2 == 0 ? '0' : '1')){
               count0++;
           }

           if(s.charAt(i) != (i % 2 == 0 ? '1' : '0')){
               count1++;
           }
       }
       return Math.min(count0,count1);
    }
    public int minOperations2(String s) {
        int count0 = 0;
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                if(s.charAt(i) != '0'){
                    count0++;
                }
            }
            else{
                if(s.charAt(i) != '1'){
                    count0++;
                }
            }
        }
        int count1 = n - count0;
        return Math.min(count0,count1);
    }
}
