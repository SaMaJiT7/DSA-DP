public class rangeXOR {
    public static void main(String[] args) {
        //XOR from a to b is equal
        int a = 9;
        int b = 3;
        int ans = xor(a) ^ xor1(b-1);
        System.out.println(ans);


        //This will give TLE for Bigger Number.
        int ans2 = 0;
        for (int i = b; i <=a ; i++) {
            ans2 = ans2 ^ i;
        }
        System.out.println(ans2);
    }
    //This give from 0 to a
    static int xor(int a) {
        if (a % 4 == 0) {
           return (a);

        } else if (a % 4 == 1) {
            return (1);

        } else if (a % 4 == 2) {
            return (a + 1);
        }
        return 0;
    }
        static int xor1(int b){
            if(b % 4 == 0){
                return (b);

            }
            else if (b % 4 == 1) {
                return (1);

            }
            else if (b % 4 == 2){
               return (b+1);
            }
            return 0;
   }
}
