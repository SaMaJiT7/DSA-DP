import java.util.Arrays;

public class sorted_matrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9},
                {10,11,12}
        };
        System.out.println(Arrays.toString(search(arr,8)));
    }

    static int[] BinarySearch(int[][] matrix,int row,int cStart,int cEnd,int target){
        while(cStart <= cEnd){
            int mid = cStart + (cEnd - cStart)/2;

            if(matrix[row][mid] == target){
                return new int[]{row,mid};
            }
            if(matrix[row][mid] < target){
                cStart = mid + 1;
            }
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }
    static int[] search(int[][] matrix , int target){
        int rows= matrix.length;
        int cols =matrix[0].length;

        if(rows == 1){
            return BinarySearch(matrix,0,0,cols-1,target);
        }

        int Rstart = 0;
        int Rend = rows - 1;
        int Cmid = cols/2;

        while(Rstart< Rend -1){
            int Mid = Rstart + (Rend - Rstart)/2 ;
            if(matrix[Mid][Cmid] == target){
                return new int[]{Mid,Cmid};
            }
            if(matrix[Mid][Cmid] < target){
                Rstart = Mid ;
            }
            else {
                Rend = Mid ;
            }
        }

        if(matrix[Rstart][Cmid] == target){
            return new int[]{Rstart,Cmid};
        }
        if(target <= matrix[Rstart][Cmid-1]){
            return BinarySearch(matrix,Rstart,0,Cmid-1,target);
        }
        if(target >= matrix[Rstart][Cmid+1] && target<= matrix[Rstart][cols-1]){
            return BinarySearch(matrix,Rstart,Cmid +1,cols-1,target);
        }
        if(target <= matrix[Rstart+1][Cmid-1]){
            return BinarySearch(matrix,Rstart+1,0,Cmid-1,target);
        }
        else{
            return BinarySearch(matrix,Rstart+1,Cmid +1,cols-1,target);
        }
    }
}
