package stackandQueue;

public class trappinng_water {
    public int trap(int[] height) {
        int n = height.length;
        int sum = 0;
        int[] MXL = new int[n];
        int[] MXR = new int[n];
        int[] water = new int[n];
        MXL[0] = height[0];
        MXR[n-1] = height[n-1];
        for(int i = 1; i < n;i++){
            MXL[i] = Math.max(MXL[i-1],height[i]);
        }
        for(int i = n-2; i >= 0; i--){
            MXR[i] = Math.max(height[i],MXR[i+1]);
        }

        for(int i = 0; i < n; i++){
            water[i] = Math.min(MXL[i],MXR[i]) - height[i];
            sum += water[i];
        }
        return sum;
    }
}
