class Solution {
    public int rob(int[] nums) {
        // For every number you can either choose to rob till index i & build out solution
        // Rob(i) = Max(rob(i-1), rob(i-2) + i)
        //          Exclude i,    Include i, and get max till i-2 (since i-1 is adjacent & we have to skip)
        int rob1 = 0;  // i-1
        int rob2 = 0;  // i-2
        // [rob1, rob2, robn, robn+1, ...]
        for (int n: nums) {
            int robn = Math.max(rob2, rob1 + n);
            rob1 = rob2;
            rob2 = robn;
        }
        // Rob2 will store the max value when considering the WHOLE NEIGBOURHOOD with n houses.
        return rob2;
    }
}

// Input: int[] nums ~ nums[i] represents # of money in ith house. (From house 0 - n-1)
// Houses are arranged in a straight line.

// You are planning to rob money from the houses, but you cannot rob 2 adjacent houses.
// This is because that would alert the police.

// Return the max amount of money you can rob without alerting the police.

// Test Cases:

//                0 1 2 3
// Input: nums = [1,1,3,3], output = 4
// Possibilities:
// 0,2 = 4
// 1,3 = 4

//                0 1 2 3 4
// Input: nums = [2,9,8,3,6], Output: 16
//                ^
// Index 0: 0
// Index 1: 0 or 1
// Index 2: 0,2 or 1
// Index 3: 0,2 or 1,3
// Index 4: 0,2,4 or 1,3 

// Index 2: 0,2, Index 4: Sol(2)+4 or Sol(3)
// 0,2 (10)
// 1,3 (12)
// 0,2 (10)
// 0,2,4 (16) --> Answer


