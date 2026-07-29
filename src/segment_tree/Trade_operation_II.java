package segment_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trade_operation_II {
    public List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int totalOne = 0;
        List<Integer> ans = new ArrayList<>();
        for(char ch : s.toCharArray()){
            if(ch == '1'){
                totalOne++;
            }
        }
        List<Integer> blockStart = new ArrayList<>();
        List<Integer> blockEnd = new ArrayList<>();
        List<Integer> blockSize = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                int j = i + 1;
                while (j < n && s.charAt(j) == '0') {
                    j++;
                }
                blockStart.add(i);
                blockEnd.add(j - 1); // Store inclusive end index of the '0' block
                blockSize.add(j - i);
                i = j - 1;
            }
        }

        if(blockSize.size() <= 1){
            for(int i = 0; i < queries.length; i++){
                ans.add(totalOne);
            }
            return ans;
        }

        List<Integer> pairSum = new ArrayList<>();
        for(int i = 0; i < blockSize.size()-1; i++){
            pairSum.add(blockSize.get(i) + blockSize.get(i+1));
        }
        SGT st = new SGT();
        int N = pairSum.size();
        int[] arr = pairSum.stream().mapToInt(i->i).toArray();
        int[] stArr = st.constructSGT(arr,N);
        int[] bStart = blockStart.stream().mapToInt(i->i).toArray();
        int[] bEnd = blockEnd.stream().mapToInt(i->i).toArray();
        for(int[] q : queries){
            int l = q[0];
            int r = q[1];

            int low = lowerBound(bStart, l);
            if (low == bStart.length || bStart[low] > r) {
                ans.add(totalOne);
                continue;
            }

            int high = upperBound(bEnd, r) - 1;
            if (high < 0 || bEnd[high] < l || low > high) {
                ans.add(totalOne);
                continue;
            }

            int maxpairSum = 0;
            if(low == high) {
                // Query falls entirely inside a single zero block
                int len = Math.min(bEnd[low], r) - Math.max(bStart[low], l) + 1;
                maxpairSum = len;
            }
            else{
                int firstLen = bEnd[low] - Math.max(bStart[low],l) + 1;
                int lastLen = Math.min(bEnd[high],r) - bStart[high] + 1;

                if(high - low == 1){
                    maxpairSum = firstLen + lastLen;
                }else{
                    int firstPair = firstLen + blockSize.get(low+1);
                    int secondPair = lastLen + blockSize.get(high-1);
                    int middleLen = 0;
                    if (low + 1 <= high - 2) {
                        middleLen = st.RMQ(stArr, N, low + 1, high - 2);
                    }
                    maxpairSum = Math.max(Math.max(firstPair,secondPair),middleLen);
                }
            }
            ans.add(maxpairSum+totalOne);
        }
        return ans;
    }
    public int lowerBound(int[] arr, int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] < target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
    public int upperBound(int[] arr, int target){
        int low = 0;
        int high = arr.length;
        while(low < high){
            int mid = low + (high-low)/2;
            if(arr[mid] <= target){
                low = mid + 1;
            }
            else{
                high = mid;
            }
        }
        return low;
    }
}

class SGT {
    public int[] st;
    public int[] constructSGT(int[] arr, int n) {
        st = new int[4*n];
        buildSGT(0,0,n-1,st,arr);
        return st;
    }


    public void buildSGT(int i, int l, int r,int[] st, int[] arr){
        if(l == r){
            st[i] = arr[l];
            return;
        }
        int mid = l + (r-l)/2;
        buildSGT(2*i+1,l,mid,st,arr);
        buildSGT(2*i+2,mid+1,r,st,arr);

        st[i] = Math.max(st[2*i+1],st[2*i+2]);
    }
    int query(int start, int end, int i, int l, int r, int[] st) {
        if (l > r || l > end || r < start) {
            return 0; // Return 0 instead of MIN_VALUE for safe max combinations
        }
        if (l >= start && r <= end) {
            return st[i];
        }
        int mid = l + (r - l) / 2;
        return Math.max(query(start, end, 2 * i + 1, l, mid, st), query(start, end, 2 * i + 2, mid + 1, r, st));
    }

    public int RMQ(int[] st, int n, int l, int r) {
        if (l > r) return 0;
        return query(l, r, 0, 0, n - 1, st);
    }
}


