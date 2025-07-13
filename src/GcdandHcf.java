public class GcdandHcf {
    public static void main(String[] args) {
        System.out.println(gcd(3,9));
        System.out.println(lcm(2,15));
    }
    public static int gcd(int a , int b){
        if(a == 0){
            return b;
        }
        return gcd(b%a,a);
    }
    public static int lcm(int a1 , int b1){
        if(gcd(a1, b1)== 0){
            return -1;
        }
        return (a1 * b1) / gcd(a1,b1);
    }
}
