package LC_QUestion;

public class maximum_manhattan {
    public int maxDistance(String moves) {
        int L = 0;
        int R = 0;
        int U = 0;
        int D = 0;
        int ex = 0;
        for(char ch : moves.toCharArray()){
            if(ch == 'L'){
                L++;
            }
            else if(ch == 'R'){
                R++;
            }
            else if(ch == 'U'){
                U++;
            }
            else if(ch == 'D'){
                D++;
            }
            else{
                ex++;
            }
        }
        int x = R-L;
        int y = U-D;

        return Math.abs(x) + Math.abs(y) + ex;
    }
}
