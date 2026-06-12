package range_query;

import java.util.Arrays;

public class Range_Query_307 {
    int[] nums;
    int[] blocks;
    int blocksize;
    public Range_Query_307(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        blocksize = (int) Math.ceil(Math.sqrt(n));
        int numberOfBlocks = (n + blocksize - 1) / blocksize;
        this.blocks = new int[numberOfBlocks];
        Arrays.fill(blocks,0);
        for(int i = 0; i < nums.length; i++){
            int block = i / blocksize;
            blocks[block] += nums[i];
        }
    }

    public void update(int index, int val) {
        int b = index / blocksize;
        blocks[b]  = blocks[b] - nums[index] + val;
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        int startblock  = left / blocksize;
        int endblock = right / blocksize;
        if(startblock == endblock){
            for(int i = left; i <= right; i++){
                sum += nums[i];
            }
        }
        else{
            //left
            int endofstartblock = ((startblock+1) * blocksize)- 1;
            for(int i = left; i <= endofstartblock; i++){
                sum += nums[i];
            }

            //middle
            for(int b = startblock+1; b <= endblock-1; b++){
                sum += blocks[b];
            }

            //right
            int startindexofendblock = (endblock * blocksize);
            for(int i = startindexofendblock; i <= right; i++){
                sum += nums[i];
            }
        }
        return sum;
    }
}
