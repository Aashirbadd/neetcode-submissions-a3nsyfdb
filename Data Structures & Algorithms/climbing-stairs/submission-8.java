class Solution {
    private HashMap<Integer, Integer> memory = new HashMap<>();
    public int climbStairs(int n) {
        // base cases
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }

        if (memory.containsKey(n)) {
            return memory.get(n);
        }

        int solution = climbStairs(n-1) + climbStairs(n-2);

        memory.put(n, solution);

        return solution;
    }
}

// Given an integer n (total number of steps to reach the top of a staircase), if you can either climb one or 2 stairs at a time
// Return the # of different ways to reach the top of the staircase.

// Basecase
// 0 (away) --> 0 --> We're already there
// 1 (away) --> 1
// 2 (away) --> 1

// Recursive case?

// 5
// 4 3
// 3 2
// 2 1
// 1


// 3
// 2 1
// 1