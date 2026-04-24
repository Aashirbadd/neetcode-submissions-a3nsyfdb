class Solution {
    // Bottom up solution (start at end)
    public int climbStairs(int n) {
        if (n < 2) return 1;
        // If we're already at n and we take one step (how many ways to get there)
        // n-2 = 3 -> n-1 (2) -> n (1)
        int oneStep = 1;
        int twoStep = 1;

        for (int i = n-2; i > 0; i--) {
            // Keep running till i == 0, so we know # of ways from 0 - n
            int oldOneStep = oneStep;
            oneStep = oneStep + twoStep;
            twoStep = oldOneStep;
            // i -> oneStep -> twoStep
            //      prevI ->    oneStep -> twoStep
        }

        return oneStep + twoStep;
    }
}

// Input: int n ~ # of steps to reach the top of the staircase.

// Constraints:
// You can climb either 1 or 2 steps at a time. 

// Goal:
// Return the # of distinct ways to climb to the top of the staircase


// Test cases:
// Input: n = 2, Output: 2
// Why?
// 1) 1 + 1 = 2
// 2) 2 = 2

// Essentially, how many different ways can we get to a sum of target (if we're only adding 1's or 2's)

// Input: n = 3 Output: 3

// 1) 1 + 1 + 1 = 3
// 2) 1 + 2 = 3
// 3) 2 + 1 = 3

// So I noticed that the answer builds on the previous numbers aswell.

// Input: n = 4 Output: 5

// 1) 1 + 1 + 1 + 1 = 4
// 2) 1 + 1 + 2 = 4
// 3) 1 + 2 + 1 = 4
// 4) 2 + 1 + 1 = 4
// 5) 2 + 2 = 4
