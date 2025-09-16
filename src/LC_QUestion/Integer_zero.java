package LC_QUestion;

public class Integer_zero {
    public int makeTheIntegerZero(int num1, int num2) {
        int count = 0;
        for(int i = 0; i <= 60; i++){
            int sub = (int) Math.pow(2,i) + num2;

            if(num1 - sub < num1){
                count += 1;
                num1 = num1-sub;
            }
            if(num1 == 0){
                return count;
            }
        }
        return -1;
    }
}
