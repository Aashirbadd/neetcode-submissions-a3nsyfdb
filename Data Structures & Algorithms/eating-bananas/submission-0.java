class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int num : piles) max = Math.max(max, num);
        int l = 1;
        int r = max;
        int k = max;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (possibleToEat(mid, piles, h)) {
                k = Math.min(k, mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return k;
    }

    private boolean possibleToEat(int k, int[] piles, int h) {
        // See if it's possible to eat all bananas in rate k in h time
        int remaining = h;
        for (int pile : piles) {
            int tTaken = pile / k;
            if (pile % k > 0) tTaken += 1;
            remaining -= tTaken;
            if (remaining < 0) return false;
        }
        System.out.printf("k: %d, h: %d, remaining: %d\n", k, h, remaining);
        return remaining >= 0; 
    }
}
// Input: int[] piles (# of bananas in ith pile), h (hours to eat all bananas)

// K = banana/hr rate, (you decide) (you can only eat one pile per h)

// Goal: Return the min integer k, so you can eat the bananas within h hours
// So you sort it, and you run binary search on it optimising for a minumum K.
// Indices:         0 1  2  3
// Input: piles = [25,10,23,4], h = 4
//                          ^
// Total = 72/4 = 18 (at the very minimum)
// Output: 25
// Basically see if it's possible to eat bananas in k time, and min k return that.