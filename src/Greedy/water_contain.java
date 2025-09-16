package Greedy;

public class water_contain {
    public int maxArea(int[] height) {
        int n = height.length;
        int i = 0;
        int j = n-1;
        int maxArea = Integer.MIN_VALUE;

        while(i < j){
            int length = Math.min(height[i],height[j]);
            int breadth = j - i;
            maxArea = Math.max(maxArea,length*breadth);
            if(height[i] < height[j]){
                i++;
            }
            else {
                j--;
            }
        }
        return maxArea;
    }
}
