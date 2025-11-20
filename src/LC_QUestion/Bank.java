package LC_QUestion;

public class Bank {
    private long[] bank;
    private int n;
    public Bank(long[] balance) {
        this.bank = balance;
        this.n = bank.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        if(account1 < 1 || account1 > n || account2 < 1 || account2 > n){
            return false;
        }

        if(bank[account1-1] < money){
            return false;
        }

        bank[account1-1] -= money;
        bank[account2-1] += money;

        return true;
    }

    public boolean deposit(int account, long money) {
        if(account > n){
            return false;
        }
        bank[account-1] += money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if(account > n){
            return false;
        }
        if(money > bank[account-1]){
            return false;
        }
        bank[account-1] -= money;
        return true;
    }
}
