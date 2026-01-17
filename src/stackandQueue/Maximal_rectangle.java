package stackandQueue;

import java.util.Stack;

public class Maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;  // Handle empty matrix
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int[] vec = new int[m];
        for(int j = 0; j < m; j++){
            vec[j] = matrix[0][j] -'0';
        }
        int max_rec = MAH(vec);
        for(int i = 1; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == '0'){
                    vec[j] = 0;
                }
                else{
                    vec[j] += matrix[i][j] - '0';
                }
            }
            max_rec = Math.max(max_rec,MAH(vec));
        }
        return max_rec;
    }
    public int MAH(int[] nums){
        int n = nums.length;
        int[] width = new int[n];
        int[] left = NSL(nums);
        int[] right = NSR(nums);
        int maxarea = 0;
        for(int i = 0; i < n; i++){
            width[i] = right[i] - left[i] - 1;
        }
        for(int i = 0; i < n; i++){
            int area = nums[i] * width[i];
            maxarea = Math.max(area,maxarea);
        }
        return maxarea;
    }
    public int[] NSL(int[] arr){
        int n = arr.length;
        int pseudoindex = -1;
        Stack<PAIR> st = new Stack<>();
        int[] left = new int[n];
        for(int i = 0; i < n; i++){
            if(!st.isEmpty() && st.peek().first >= arr[i]){
                while(!st.isEmpty() && st.peek().first >= arr[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                left[i] = pseudoindex;
            }
            else{
                left[i] = st.peek().second;
            }
            st.push(new PAIR(arr[i],i));
        }
        return left;
    }

    public int[] NSR(int[] arr){
        int n = arr.length;
        int pseudoindex = n;
        Stack<PAIR> st = new Stack<>();
        int[] right = new int[n];
        for(int i = n-1; i >= 0; i--){
            if(!st.isEmpty() && st.peek().first >= arr[i]){
                while (!st.isEmpty() && st.peek().first >= arr[i]){
                    st.pop();
                }
            }
            if(st.isEmpty()){
                right[i] = pseudoindex;
            }
            else{
                right[i] = st.peek().second;
            }
            st.push(new PAIR(arr[i],i));
        }
        return right;
    }

    class PAIR {
        int first;
        int second;
        PAIR(int f, int s){
            this.first = f;
            this.second = s;
        }
    }
}
