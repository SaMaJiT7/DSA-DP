package Leetcode_daily;

import java.util.PriorityQueue;

public class Maximum_total_value_subarray {
    public long getValue(long l, long r, segmentTree minST, segmentTree maxST,int n){
        long minEl = minST.Query(l,r,n);
        long maxEl = maxST.Query(l,r,n);

        return maxEl-minEl;
    }
    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b) -> Long.compare(b[0],a[0])); // store like {val, l, r}
        segmentTree minST = new segmentTree(nums,true);
        segmentTree maxST = new segmentTree(nums,false);
        for(int l = 0; l < n; l++){
            long value = getValue(l,n-1,minST,maxST,n);
            pq.add(new long[]{value,l,n-1});
        }


            long result  = 0;
            while(k-- > 0 && !pq.isEmpty()){
                long[] val = pq.poll();
                result += val[0];
                long l = val[1];
                long r = val[2] - 1;
                if(l <= r) {
                    long value = getValue(l, r, minST, maxST, n);
                    pq.add(new long[]{value,l,r});
                }
            }
            return result;
    }
}

class segmentTree{
    int[] st;
    boolean isMinTree;

    public segmentTree(int[] arr, boolean flag){
        int n = arr.length;
        isMinTree = flag;

        st = new int[4*n];

        Buildsgt(0,0,n-1,st,arr,isMinTree);
    }

    public static void Buildsgt(int i, int l, int r, int[] st,int[] arr,boolean isMinTree){
        if(l == r){
            st[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        Buildsgt(2*i+1,l,mid,st,arr,isMinTree);
        Buildsgt(2*i+2,mid+1,r,st,arr,isMinTree);

        if(isMinTree){
            st[i] = Math.min(st[2*i+1],st[2*i+2]);
        }
        else{
            st[i] = Math.max(st[2*i+1],st[2*i+2]);
        }
    }

    public  long Querysegment(long start,long end,int i, int l, int r, int[] st){
        if(l > r){
            return isMinTree ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        if(l > end || r < start){
            return isMinTree ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        if(l >= start && r <= end){
            return st[i];
        }
        int mid = l + (r-l)/2;
        long a = Querysegment(start,end,2*i+1,l,mid,st);
        long b = Querysegment(start,end,2*i+2,mid+1,r,st);
        if(isMinTree){
            return Math.min(a,b);
        }
        else{
            return Math.max(a,b);
        }
    }

    public long Query(long l, long r, int n){
        return Querysegment(l,r,0,0,n-1,st);
    }
}
