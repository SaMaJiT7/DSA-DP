package LC_QUestion;

public class set_bits {
    public int smallestNumber(int n) {
//        for(int i = n; i <= (1 << 30); i++){
//            if((i & (i+1)) == 0){
//                return i;
//            }
//        }
//        return -1;

        int bits = Integer.highestOneBit(n);

        if(bits == n+1) return n;

        bits <<= 1;

        return bits - 1;
    }

    public int minBitFlips(int start, int goal) {

        int result = 0;


        while (start > 0 || goal > 0) {
            int bitA = start & 1; // extract last bit of start
            int bitB = goal & 1; // extract last bit of goal

            int xorBit = bitA ^ bitB; // XOR of current bits
            if(xorBit == 1){
                result++;
            }


            start >>= 1; // move to next bit
            goal >>= 1;

        }
        return result;
    }
}
