package HEAP;

import java.util.*;

public class frequency_sort{
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        PriorityQueue<Pair> MinHeap = new PriorityQueue<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            MinHeap.add(new Pair(entry.getValue(),entry.getKey()));
        }

        List<Integer> result = new ArrayList<>();
        while(MinHeap.size() != 0){
            Pair p = MinHeap.poll();
            for(int i = 0; i < p.freq;i++){
                result.add(p.value);
            }
        }
        return result.stream().mapToInt(i->i).toArray();
    }
    class Pair implements Comparable<Pair>{
        public int freq;
        public int value;


        public  Pair(int freq,int value){
            this.freq = freq;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.freq != other.freq) {
                return Integer.compare(this.freq, other.freq); // min-heap on frequency
            }
            return Integer.compare(other.value,this.value);       // tie-break on value
        }
    }
public int[] frequencySortAsc(int[] nums) {
    HashMap<Integer,Integer> map = new HashMap<>();
    PriorityQueue<Pair> Maxheap = new PriorityQueue<>();
    for(int num : nums){
        map.put(num,map.getOrDefault(num,0)+1);
    }
    for(Map.Entry<Integer,Integer> entry : map.entrySet()){
        Maxheap.add(new Pair(entry.getValue(),entry.getKey()));
    }

    List<Integer> result = new ArrayList<>();
    while(Maxheap.size() != 0){
        Pair p = Maxheap.poll();
        for(int i = 0; i < p.freq;i++){
            result.add(p.value);
        }
    }
    return result.stream().mapToInt(i->i).toArray();
}
    class pair implements Comparable<Pair>{
        public int freq;
        public int value;


        public  pair(int freq,int value){
            this.freq = freq;
            this.value = value;
        }

        @Override
        public int compareTo(Pair other) {
            if (this.freq != other.freq) {
                return Integer.compare(other.freq,this.freq); // Max-heap on frequency
            }
            return Integer.compare(this.value,other.value);       // tie-break on value
        }
    }
}
