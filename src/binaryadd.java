public class binaryadd {
    public static void main(String[] args) {
        
    }

    public String addBinary(String a, String b) {
        int an = Integer.parseInt(a,2);
        int bn = Integer.parseInt(b,2);

        int add = an + bn;

        String add7 = Integer.toBinaryString(add);

        return add7;
    }
}
