package Leetcode_daily;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class sequential_dits {
    public List<Integer> sequentialDigits(int low, int high) {
//        List<Integer> answer = new ArrayList<>();
//        for(int startDigit = 1; startDigit <= 9; startDigit++){
//            int currentNumber = startDigit;
//            int nextDigit = startDigit + 1;
//
//            while(nextDigit <= 9){
//
//                currentNumber = currentNumber * 10 + nextDigit;
//
//                if(currentNumber >= low && currentNumber <= high){
//                    answer.add(currentNumber);
//                }
//
//                if(currentNumber > high) break;
//                nextDigit++;
//            }
//        }
//
//        return answer;
        List<Integer> ans = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i < 9; i++){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            int currNumber = 0;
            int digit = queue.poll();
            if(digit >= low && digit <= high){
                ans.add(digit);
            }
            if(digit > high) break;
            int CurrDigit = digit % 10;
            if(CurrDigit + 1 <= 9){
                int nextDigit = CurrDigit + 1;
                currNumber = CurrDigit * 10 + nextDigit;
                queue.add(currNumber);
            }
        }
        return ans;
    }
}
