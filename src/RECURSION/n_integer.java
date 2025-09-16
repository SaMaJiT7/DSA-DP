package RECURSION;

import java.util.ArrayList;

public class n_integer {
    public int[] sumZero(int n) {
        ArrayList<Integer> list = new ArrayList<>(n);
        if(n == 1){
            return new int[]{0};
        }
        if(n % 2 == 0){
            for(int i = 1; i < n/2; i++){
                list.add(i);
                list.add(-i);
            }
        }
        else{
            sumZero(n-1);
            list.add(0);
        }
        int[] result = list.stream().mapToInt(Integer::intValue).toArray();

        return result;
    }
}
