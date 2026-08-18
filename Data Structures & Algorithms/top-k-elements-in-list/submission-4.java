class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Return the k most frequent elements within an array...
        // Input: nums = [1,2,2,3,3,3], k = 2
        // Frequency: {1:1, 2:2, 3:3}
        // So we return 2 and 3...
        // The best way to do this is with a heap (minHeap) of size k -> Lowest at the tip, only the top k remain..
        // Output: [2,3]

        // First we obtain the frequency of each element in nums...
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Create a minheap (minimum at the tip)
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> {
                return freq.get(a) - freq.get(b);
            }
        );

        for (int num : freq.keySet()) {
            pq.add(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = pq.poll();
        }

        return output;
    }
}
