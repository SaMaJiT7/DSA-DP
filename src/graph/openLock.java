package graph;

import java.util.*;

public class openLock {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deadend = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        visited.add("0000");
        if(deadend.contains("0000")){
            return -1;
        }
        int count = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0) {
                String curr = queue.poll();
                if (curr.equals(target)) {
                    return count;
                }
                for (int i = 0; i < 4; i++) {
                    char[] arr = curr.toCharArray();
                    char originalchar = arr[i];
                    arr[i] = (char) (((originalchar - '0' + 1) % 10) + '0');
                    String forwardstr = new String(arr);

                    arr[i] = (char) (((originalchar - '0' + 9) % 10) + '0');
                    String backwardstr = new String(arr);
                    arr[i] = originalchar;
                    if (!visited.contains(forwardstr) && !deadend.contains(forwardstr)) {
                        queue.add(forwardstr);
                        visited.add(forwardstr);
                    }
                    if (!visited.contains(backwardstr) && !deadend.contains(backwardstr)) {
                        queue.add(backwardstr);
                        visited.add(backwardstr);
                    }
                }
            }
            count++;
        }
        return -1;
    }
}
