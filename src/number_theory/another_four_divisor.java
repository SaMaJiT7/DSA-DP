package number_theory;

public class another_four_divisor {
    public int sumFourDivisors(int[] nums) {
        int n = nums.length;
        int totalsum = 0;
        for(int num : nums){
            totalsum += sumcountdivisor(num);
        }
        return totalsum;
    }
    static int sumcountdivisor(int num){
        int divisorcount = 0;
        int sum  = 0;
        for(int i = 1; i * i <= num; i++){
            if(num % i == 0){
                int other = num / i;
                if(i == other){
                    divisorcount++;
                    sum += i;
                }else {
                    divisorcount += 2;
                    sum += (i + other);
                }
            }
            if(divisorcount > 4){
                return 0;
            }
        }
        return divisorcount == 4 ? sum : 0;
    }
}
