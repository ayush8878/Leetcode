import java.util.PriorityQueue;

public class KthLargest {
    // store value of k
    private static int k;
    // Declare a PriorityQueue as heap
    private PriorityQueue<Integer> heap;

    public KthLargest(int k, int[] nums)
    {
        this.k = k;
        heap = new PriorityQueue<>();
        // insert all in heap
        for(int num:nums)
        {
            heap.offer(num);
        }
        // as we need kth largest element remove last K elements from max heap
        while(heap.size() > k)
        {
            heap.poll();
        }
    }

    public int add(int val) {
        // add val in heap
        heap.offer(val);
        // if heap size change after insertion then remove 1 element
        if(heap.size() > k)
        {
            heap.poll();
        }
        return heap.peek();
    }
}

