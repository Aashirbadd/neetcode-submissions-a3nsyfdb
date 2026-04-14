class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(
            (a,b) -> b-a
        );

        for (int stone: stones) heap.add(stone);

        while (heap.size() >= 2) {
            int a = heap.poll();
            int b = heap.poll();
            int c = Math.abs(a-b);
            if (c != 0) heap.add(c);
        }

        return heap.isEmpty()? 0 : heap.poll();
    }
}

// Given an array of integers (stones), stones[i] = weight of i'th stone

// Run a simulation, where each step we choose two heaviest stones weight(x,y)
    // x == y stones are destroyed
    // x < y, stone of weight x is destroyed, and weight y has new weight (y-x)
        // (Smaller stone is destroyed, larger stone has difference weight)

// Continue the simulation until no more than 1 stone remains.
// Return the weight of the last remaining stone or return 0.

// Put them all in a heap, poll two, smash, then put back in the heap
// If there's only 1 element in the heap, return its weight
// If heap is empty, return 0;