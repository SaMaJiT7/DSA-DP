package string;

public class kthBit {
    public char findKthBit(int n, int k) {
        if(n == 1){
            return '0';
        }
        int length = (1 << n) - 1;
        int middle = (length + 1) / 2;
        if(k == middle){
            return '1';
        } else if (k > middle) {
            int d = k - middle;
            int bit = middle - d;
            return invert(findKthBit(n-1,bit));
        }
        else{
            return findKthBit(n-1,k);
        }
    }
    public char invert(char ch){
        if(ch == '0'){
            return '1';
        }
        else{
            return '0';
        }
    }
}
