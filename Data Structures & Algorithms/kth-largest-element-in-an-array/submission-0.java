class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
        return heap.peek();
    }
}

// Given an unsorted array of integers, and an integer k, return the kth largest element
// in the array.

// K'th largest element in sorted order
// Put into a heap, and pop out the kth largest element
    // Minheap or maxheap? (Minheap of size k) (Min will be at root, keep popping)
    // return heap.peek() in the end once you run through the whole array
    // Time complexity = n(log(n)), space O(n)