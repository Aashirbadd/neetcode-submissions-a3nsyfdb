class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        // Binary search from 0 - k...
        int l = 1, r = Integer.MIN_VALUE;
        for (int i = 0; i < piles.length; i++) {
            r = Math.max(r, piles[i]);
        }

        int k = r;
        while (l <= r) {
            int mid = (l + r) / 2;
            
            // Find time to eat bananas...
            int time = 0;
            for (int i = 0; i < piles.length; i++) {
                time += Math.ceilDiv(piles[i], mid);
                // OR Math.ceil((double) x / y);
            }
            // System.out.printf("mid: %d, time: %d\n", mid, time);

            if (time <= h) {
                // System.out.printf("mid: %d\n", mid);
                k = Math.min(k, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return k;
    }
}

// Given integer array piles -> number of bananas in the ith pile...
// h -> Hours to eat all bananas...

// Find the minimum banana eating rate k. Each hour, choose a pile of bananas and
// eat k bananas from that pile... If it has less than k bananas finish eating from that pile and don't eat from another pile for a whole hour...

// Return the minimum integer so you can eat all bananas in h hours...

// Input: piles = [1,4,3,2], h = 9
// 
// Output: 2
