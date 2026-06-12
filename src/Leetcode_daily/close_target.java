package Leetcode_daily;

public class close_target {
    public int closestTarget(String[] words, String target, int startIndex) {
        int left = startIndex;
        int right = startIndex;
        int n = words.length;
        int  result = Integer.MAX_VALUE;
        while (left >= 0 || right < n){
            if(left  >= 0 && words[left].equals(target)){
                int ans = Math.abs(left - startIndex);
                result = Math.min(result,Math.min(ans,n-ans));
            }
            if(right < n && words[right].equals(target)){
                int ans = Math.abs(right - startIndex);
                result = Math.min(result,Math.min(ans,n-ans));
            }

            left--;
            right++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
