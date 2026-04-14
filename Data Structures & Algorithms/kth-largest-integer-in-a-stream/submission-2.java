class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int num: nums) {
            this.add(num);
        }
    }
    
    public int add(int val) {
        heap.add((Integer) val);

        if (heap.size() > k)    heap.poll();
        
        return heap.peek();
    }
}
//  0 1 2 3 4 5 6 7 8
// [1,2,3,3,3,5,6,7,8]
//              ^