package Greedy;

import java.util.Arrays;

public class Bag_of_tokens {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxscore = 0;
        int score = 0;
        int n = tokens.length;
        int i = 0;
        int j = n-1;
        while(i <= j){
            if(power >= tokens[i]){
                score++;
                power -= tokens[i];
                i++;
                maxscore = Math.max(score,maxscore);
            }
            else if(score >= 1){
                power += tokens[j];
                j--;
                score--;
            }
            else {
                return maxscore;
            }
        }
        return maxscore;
    }
}
