package Greedy;

public class minNumberOperations {
    public int minNumberOperations(int[] target) {
        int n = target.length;
        int count = target[0];
        int temp = target[0];
        for(int i = 1; i < n; i++){
            if(target[i] > target[i-1]){
                count = count + (target[i] - temp);
            }
            temp = target[i];
        }
        return count;
    }
}
