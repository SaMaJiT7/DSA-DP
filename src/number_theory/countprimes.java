package number_theory;

public class countprimes {
    public static final int N = (int) 1e7;
    static boolean[] prime = new boolean[N];
    public static void main(String[] args) {
        int n = 5;
        int ans = countPrimes(n);
        System.out.println(ans);
    }
    public static int countPrimes(int n) {
        for(int i = 0; i < n; i++){
            prime[i] = true;
        }
        prime[0] = false;
        prime[1] = false;
        // Eliminate even numbers except 2
        for (int i = 4; i < n; i += 2) {
            prime[i] = false;
        }

        for(int i = 3; i*i <= n; i += 2){
            if(prime[i]){
                for(int j = i*i; j < n; j += (i << 1)){
                    prime[j] = false;
                }
            }
        }
        int ans = 0;
        if(n > 2) ans = 1;
        for(int i = 3; i < n; i += 2){
            if(prime[i]){
                ans++;
            }
        }
        return ans;
    }
}
