package LC_QUestion;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class findLexSmallestString{
    public String findLexSmallestString(String s, int a, int b) {
        String smalleststring = s;
        HashSet<String> visited = new HashSet<>();
        Queue<String> que = new LinkedList<>();
        que.add(s);
        visited.add(s);

        while (!que.isEmpty()) {
            String curr = que.poll();

            if (curr.compareTo(smalleststring) < 0) {
                smalleststring = curr;
            }

            //Add
            StringBuilder temp = new StringBuilder(curr);
            for (int i = 1; i < s.length(); i = i + 2) {
                char c = temp.charAt(i);
                int newDigit = ((c - '0') + a) % 10; // make sure to use %10 on the full addition
                temp.setCharAt(i, (char) (newDigit + '0'));
            }
            String result = temp.toString();

            if(!visited.contains(result)){
                visited.add(result);
                que.add(result);
            }

            //rotate
            b = b % curr.length();
            String rotated = curr.substring(curr.length() - b) + curr.substring(0, curr.length() - b);

            if(!visited.contains(rotated)){
                visited.add(rotated);
                que.add(rotated);
            }
        }

        return smalleststring;
    }
}
