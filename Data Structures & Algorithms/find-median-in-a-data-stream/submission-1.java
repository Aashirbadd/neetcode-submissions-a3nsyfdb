class MedianFinder {

    PriorityQueue<Integer> small;
    PriorityQueue<Integer> large;

    public MedianFinder() {
        this.small = new PriorityQueue<>(
            // a before b if a is larger (MaxHeap, smallest at root)
            (a,b) -> Integer.compare(a,b) * -1
        );
        this.large = new PriorityQueue<>(); // Normal Minheap
    }
    
    public void addNum(int num) {
        small.add(num);
        // Ensure small.peek() <= large.peek();
        if (!small.isEmpty() && !large.isEmpty()
            && small.peek() > large.peek()) {
                // Move number from small to large, so its in right place
                large.add(small.poll());
            }
        // Make sure sizes are balanced (+- 1)
        if (small.size() > large.size()) {
            large.add(small.poll());
        }
        // Make sure sizes are balanced in reverse also (+- 1)
        if (large.size() > small.size() + 1) {
            small.add(large.poll());
        }
    }
    
    public double findMedian() {
        int sp = small.isEmpty() ? -1 : small.peek();
        int lp = large.isEmpty() ? -1 : large.peek();
        double med = ((double) (sp + lp) / 2);
        // System.out.printf("sp %d, lp %d, comb %f \n", sp, lp, med);

        if (small.size() > large.size())        return sp;
        else if (large.size() > small.size())   return lp;
        else                                    return med;
    }
}

// 2 different heaps, (min & max)
// Small = MaxHeap (largest @ tip), Large = MinHeap (smallest @ tip)
// Median = (Small.Peek() + Big.Peek()) / 2, or if one is larger, it's the peek() of the larger
    // Important Condition:
    // 1. Make sure that both heaps are the same size, or one is larger by the other
    //      by one element at most.
    // 2. Small.Peek() <= Big.Peek()    (For obvious reasons)