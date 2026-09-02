class Solution {
    public int climbStairs(int n) {
        if (n <= 2)     return n;
        // i = 3
        
        int oneBack = 2;    // # of ways to reach step 2
        int twoBack = 1;    // # of ways to reach step 1

        for (int i = 3; i <= n; i++) {
            // This meat of the algorithm works for i = 3 to n (inclusive)
            int curr = oneBack + twoBack;   // Ways to get to step i
            twoBack = oneBack;          // ways to get to step i - 2 (i++)
            oneBack = curr;          // ways to get to step i - 1 (i++)
        }

        return oneBack;     // i is now n+1, so this is # of ways to get to step n.
    }
}
