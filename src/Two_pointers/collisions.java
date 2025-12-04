package Two_pointers;

public class collisions {
    public int countCollisions(String directions) {
        int n = directions.length();
        int L = 0;
        int R = n-1;

       while(L < n && directions.charAt(L) == 'L'){
            L++;
        }
       while(R >=0 && directions.charAt(R) == 'R' ){
            R--;
        }
        int i = L;
        int j = R;
        int collisions = 0;
        while(i <= j){
            if(directions.charAt(i) != 'S'){
                collisions++;
            }
            i++;
        }
        return collisions;
    }
}
