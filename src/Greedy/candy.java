package Greedy;

public class candy {
    public int candy(int[] ratings) {
//        int n = ratings.length;
//        int[] left = new int[n];
//        left[0] = 1;
//        for(int i = 1; i < n; i++){
//            if(ratings[i] > ratings[i-1]){
//                left[i] = left[i-1] + 1;
//            }
//            else{
//                left[i] = 1;
//            }
        int n = ratings.length;
        int sum = 1, i = 1;

        while(i < n){
            if(ratings[i] == ratings[i-1]){
                sum = sum + 1;
                i++;
                continue;
            }

            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }
            int down = 0;
            while (i < n && ratings[i] < ratings[i - 1]) {
                down++;
                sum += down;
                i++;
            }


            sum += Math.max(0, (down + 1) - peak);
        }

        return sum;
    }
}


//        int curr = 1;
//        int sum = Math.max(1,left[n-1]);
//        for(int i = n-2; i >= 0; i--){
//           if(ratings[i] > ratings[i+1]){
//               curr = curr + 1;
//
//           }
//           else{
//               curr = 1;
//           }
//           sum  += Math.max(left[i],curr);
//        }
//        return sum;
//    }





//    public static int[] right(int[] arr){
//        int[] right = new int[arr.length];
//        right[arr.length-1] = 1;
//        for(int i = arr.length-2; i >= 0; i--){
//            if(arr[i] > arr[i+1]){
//                right[i] = right[i+1] + 1;
//            }
//            else{
//                right[i] = 1;
//            }
//        }
//        return right;
//    }
//}
