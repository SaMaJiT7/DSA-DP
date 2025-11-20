package HEAP;

public class heap_with_array {
    private int[] heap;
    private int size;
    public heap_with_array(int[] arr) {
        heap = new int[arr.length];  // Initialize with same capacity
        size = arr.length;
        System.arraycopy(arr, 0, heap, 0, size);  // Copy input array
    }

    public void build() {
        for (int i = (size / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    public int getMax() {
        if (size == 0) {
            return -1;
        } else {
            return heap[0];
        }
    }

    public void insert(int val) {
        // Resize if necessary (double capacity)
        if (size == heap.length) {
            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, size);
            heap = newHeap;
        }
        heap[size] = val;
        size++;
        heapifyUp(size - 1);
    }

    public void delete() {
        if (size == 0) {
            return;  // Or throw exception
        }
        heap[0] = heap[size - 1];  // Move last to root
        size--;  // Reduce size
        heapifyDown(0);  // Restore heap property
    }

    private void heapifyDown(int index) {
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    private void heapifyUp(int index) {
        if (index == 0) {
            return;
        }
        int parent = (index - 1) / 2;
        if (heap[index] > heap[parent]) {
            swap(index, parent);
            heapifyUp(parent);
        }
    }

    void print(){
        for(int i : heap){
            System.out.println(i+" ");
        }
    }
    public void heap_sort(int i , int last){
        swap(heap[i],heap[last]);
        last--;
        heapify(i,last);
    }
    public void heapify(int index, int last){
        int largest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left <= last && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right <= last && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapify(largest,last);
        }
    }

    public void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {};
        int n = arr.length;
       heap_with_array qp = new heap_with_array(arr);
       qp.build();
       for(int i = 0; i < n ; i++){
           qp.heap_sort(0,n-i-1);
       }
       qp.print();
    }

}
