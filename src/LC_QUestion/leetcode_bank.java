package LC_QUestion;

public class leetcode_bank {
    public int totalMoney(int n) {
        int sum = 0;
        int count = 0;
        int monday = 1;
        for(int i = 1; i <= n; i++){
            count +=1;
            if(count < 7){
                monday += 1;
            }
            if(count == 7){
                count = 0;
                monday = i/7 + 1;
            }
            sum += monday;
        }
        return sum;
    }
}
