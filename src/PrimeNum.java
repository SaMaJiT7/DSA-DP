public class PrimeNum {
    public static void main(String[] args) {
//        int n= 13;
//        for (int r = 1 ; r <= n ; r++) {
//            System.out.println(r + " " +Isprime(r));
//        }
//    public static boolean Isprime(int n){
//        int c = 2;
//        for(int i = 2 ; i <= Math.sqrt(n) ; i++){
//            if(n <= 1){
//                return false;
//            }
//            if (n % i != 0){
//                return true;
//            }
//        }
       // return false;

//        while(c * c <= n) {
//            if(n % c == 0){
//                return false;
//            }
//            c++;
//        }
//       return true;
        int n= 40;
        boolean[] primes = new boolean[n+1];
        sieve(n,primes);
    }
    public static void sieve(int n ,boolean[] primes){
        for (int i = 2; i*i <= n ; i++){
            if(!primes[i]){
                for(int j = i*2 ; j <= n ; j+=i){
                    primes[j] = true;
                }
            }
        }
        for (int i = 2; i <= n ; i++){
            if (!primes[i]){
                System.out.print(i + " ");
            }
        }
    }
}
