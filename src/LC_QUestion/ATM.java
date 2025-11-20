package LC_QUestion;

public class ATM {
    private long[] atm;
    public ATM() {
        atm = new long[5];
    }

    public void deposit(int[] banknotesCount) {
        for(int i = 0; i < 5; i++){
            atm[i] += banknotesCount[i];
        }
    }

    public int[] withdraw(int amount) {
        int[] result = new int[5];
        long[] values = {20,50,100,200,500};

        for(int i = 4; i >= 0; i--){
            long use = Math.min(atm[i],(amount / values[i]));
            result[i] = (int) use;
            amount -= use * values[i];
        }

        if(amount == 0){
            for(int i = 0; i < 5; i++){
                atm[i] -= result[i];
            }
            return result;
        }

        return new int[]{-1};
    }
}
