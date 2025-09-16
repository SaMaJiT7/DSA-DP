package BackTracking;

public class tower_of_hanoi {
    public int towerOfHanoi(int n, int from, int to, int aux) {
        if(n == 0 || n == 1){
            return n;
        }

        int moves = towerOfHanoi(n-1,from,aux,to);
        moves++;
        moves += towerOfHanoi(n-1,aux,to,from);
        return moves;
    }
}
