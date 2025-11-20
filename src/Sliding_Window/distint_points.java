package Sliding_Window;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class distint_points {
    public int distinctPoints(String s, int k) {
        Set<Pair> st = new HashSet<>();
        int x = 0 ,y = 0;
        for(int i = 0; i < k ; i++){
            if(s.charAt(i) == 'U'){
                y++;
            }
            if(s.charAt(i) == 'D'){
                y--;
            }
            if(s.charAt(i) == 'L'){
                x--;
            }
            if(s.charAt(i) == 'R') x++;
        }
        st.add(new Pair(x,y));

        for(int i = 0; i < s.length() - k ; i++){
            if(s.charAt(i) == 'U') y--;
            if(s.charAt(i) == 'D') y++;
            if(s.charAt(i) == 'L') x++;
            if(s.charAt(i) == 'R') x--;

            if(s.charAt(i+k) == 'U') y++;
            if(s.charAt(i+k) == 'D') y--;
            if(s.charAt(i+k) == 'L') x--;
            if(s.charAt(i+k) == 'R') x++;

            st.add(new Pair(x,y));
        }
        return st.size();
    }
    class Pair {
        int x;
        int y;

        Pair(int first, int second) {
            this.x = first;
            this.y = second;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return x == pair.x && y == pair.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
