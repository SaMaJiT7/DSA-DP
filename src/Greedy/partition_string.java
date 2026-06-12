package Greedy;

import java.util.HashSet;

public class partition_string {
    public int partitionString(String s) {
//        HashSet<Character> ispresent = new HashSet<>();
//        int partition = 1;
//        for(char c : s.toCharArray()){
//            if(ispresent.contains(c)){
//                partition = partition + 1;
//                ispresent.clear();
//            }
//            ispresent.add(c);
//        }
//        return partition;
        int[] pos = new int[26];
        int partition = 1;
        int currStr = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(pos[c-'a'] >= currStr){
                partition++;
                currStr = i;
            }
            pos[c-'a'] = i;
        }
        return partition;
    }
}
