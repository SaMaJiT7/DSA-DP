package Trees;
import java.util.ArrayList;
import java.util.Scanner;

public class Heaps {
    public static void main(String[] args) throws Exception {
        heap<Integer> Heap = new heap<>();
            Heap.insert(34);
            Heap.insert(76);
        Heap.insert(92);
        Heap.insert(12);
        Heap.insert(55);
        Heap.insert(90);



            ArrayList List = Heap.heapsort();
        System.out.println(List);
        }
    }

class  heap<T extends Comparable<T>>{
    private ArrayList<T> list;
    public heap(){
        list = new ArrayList<>();
    }
    private void swap(int first , int second){
        T temp = list.get(first);
        list.set(first, list.get(second));
        list.set(second, temp);
    }
    private int parentindex(int index){
        return (index-1)/2;
    }
    private int leftchild(int index){
        return (index*2)+1;
    }
    private int rightchild(int index){
        return (index*2)+2;
    }
    public void insert(T Value){
        list.add(Value);
        uphead(list.size() - 1);
    }
    private void uphead(int index){
        if(index == 0){
            return;
        }
        int p = parentindex(index);
        if(list.get(index).compareTo(list.get(p)) < 0){
            swap(p,index);
        }
    }
    public T remove() throws Exception {
        if (list.isEmpty()) {
            throw new Exception("Can't remove from an Empty List.");
        }
        T temp = list.get(0);

        T last = list.remove(list.size() - 1);
        if (!list.isEmpty()) { // Only if the list is not empty after removal
            list.set(0, last);
            downheap(0);
        }
        return temp;
    }
    private void downheap(int index){
        int min = index;
        int left = leftchild(index);
        int right = rightchild(index);
        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0){
            min = left;
        }
        if(right < list.size() && list.get(min).compareTo(list.get(right)) > 0) {
            min = right;
        }


        if(min != index){
            swap(min,index);
            downheap(min);
        }
    }

    public ArrayList<T> heapsort() throws Exception {
        ArrayList<T> data = new ArrayList<>();
        while(!list.isEmpty()){
            data.add(this.remove());
        }
        return data;
    }
}
