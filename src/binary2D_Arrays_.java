import java.util.Arrays;

public class binary2D_Arrays_ {
    public static void main(String[] args) {
        int[][] mat = {
                {5}
        };
        System.out.println((arr2D(mat)));
    }

    static int arr2D(int[][] mat){
//        int row = 0;
//        int col = matrix.length - 1;
//
//        while (row < matrix.length && col >= 0){
//            if(matrix[row][col] == target){
//                return new int[]{row,col};
//            }
//            if(matrix[row][col] < target){
//                row++;
//            }
//            else{
//                col--;
//            }
//        }
//        return new int[]{-1,-1};

        int sum=0,n=mat.length;

        for(int i=0;i<n;i++){
            sum=sum+mat[i][i];
            if(i!=n-i-1){
                sum+=mat[i][n-i-1];
            }
        }
        return sum;
    }
}

