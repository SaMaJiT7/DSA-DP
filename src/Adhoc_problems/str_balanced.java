package Adhoc_problems;

public class str_balanced {
    public boolean isBalanced(String num) {
        int n = num.length();
        int evensum = 0;
        int oddsum = 0;
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                evensum += num.charAt(i) - '0';
            }
            else{
                oddsum += num.charAt(i) - '0';
            }
        }
        return evensum == oddsum ? true : false;
    }
}
