package Two_pointers;

import java.util.Arrays;
import java.util.EnumSet;

public class Two_sum_II {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        Arrays.fill(answer,-1);
        int n = numbers.length;
        int i = 0;
        int j = n-1;
        while(i < j){
            int sum = numbers[i] + numbers[j];
            if(sum == target){
                answer[0] = i+1;
                answer[1] = j+1;
                break;
            }
            else if(sum > target){
                j--;
            }
            else{
                i++;
            }
        }
        return answer;
    }
}
