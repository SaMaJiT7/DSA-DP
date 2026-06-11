package Leetcode_daily;

public class waviness_of_number {
    public int totalWaviness(int num1, int num2) {
        int waviness = 0;
        if(num2 < 100){
            return 0;
        }
        if(num1 < 100){
            num1 = 100;
        }
        for(int i = num1; i <= num2; i++){
            String num = String.valueOf(i);
            int n = num.length();
            if(n < 3){
                continue;
            }
            else{
                int peak = 0;
                int vally = 0;
                for(int j = 1; j < n-1; j++){
                    if(num.charAt(j) >  num.charAt(j-1) && num.charAt(j) >  num.charAt(j+1)){
                        peak += 1;
                    }
                    else if(num.charAt(j) < num.charAt(j-1) && num.charAt(j) < num.charAt(j+1)){
                        vally += 1;
                    }
                    else{
                        continue;
                    }
                }
                waviness += (peak+vally);
            }
        }
        return waviness;
    }
}
