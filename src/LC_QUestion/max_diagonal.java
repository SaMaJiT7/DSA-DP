package LC_QUestion;

public class max_diagonal {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int n = dimensions.length;
        double Maxdiagonal = Integer.MIN_VALUE;
        int Maxarea = Integer.MIN_VALUE;
        double diagonal = 0;
        
        for(int i = 0; i < n ; i++){
            int l = dimensions[i][0];
            int b = dimensions[i][1];
            
            diagonal = Math.sqrt(l*l + b*b);
            
            if(diagonal > Maxdiagonal){
                Maxarea = Math.max(Maxarea,l*b);
                Maxdiagonal = Math.max(Maxdiagonal,diagonal);
            }
            else if (diagonal == Maxdiagonal) {
                Maxarea = Math.max(Maxarea,l * b);
            }
        }
        return Maxarea;
    }
}
