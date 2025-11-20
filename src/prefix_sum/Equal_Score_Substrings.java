package prefix_sum;

public class Equal_Score_Substrings {
    public boolean scoreBalance(String s) {
        int totalvalue = 0;
        for(char ch : s.toCharArray()){
            totalvalue += (ch - 'a') + 1;
        }
        if(totalvalue % 2 != 0){
            return false;
        }
        else{
            int current = 0;
            for(char ch : s.toCharArray()){
                current += (ch - 'a') + 1;
                if(current * 2 == totalvalue){
                    return true;
                }
            }
        }
        return false;
    }
}
