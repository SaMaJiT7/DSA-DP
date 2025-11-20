package LC_QUestion;

public class bits1and2 {
    public static void main(String[] args) {
        int[] bits = {1,1,1,0};
        boolean ans = isOneBitCharacter(bits);
        System.out.println(ans);
    }
    public static boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;

        while(i < n){
            if(bits[i] == 1){
                i = i+2;
            }
            else{
                if(i == n-1) return true;
                i++;
            }
        }
        return false;
    }
}
