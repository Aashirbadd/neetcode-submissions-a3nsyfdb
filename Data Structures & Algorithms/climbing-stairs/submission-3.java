class Solution {
    // Memoised DFS solution, then bottom up solution.
    public int climbStairs(int n) {
        HashMap<Integer, Integer> cache = new HashMap<>();

        // dfs from step 0 to step n
        return dfs(0, n, cache);
    }

    public int dfs(int curr, int goal, HashMap<Integer, Integer> cache) {
        if (curr > goal)                return 0;
        // Base case, == 5
        if (curr == goal)               return 1;
        // Base case (already in cache)
        if (cache.containsKey(curr))    return cache.get(curr);

        // The increment cases
        int oneStep = dfs(curr + 1, goal, cache);
        int twoStep = dfs(curr + 2, goal, cache);

        int solution = oneStep + twoStep;
        // Cache & return solution
        cache.put(curr, solution);
        return solution;
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
