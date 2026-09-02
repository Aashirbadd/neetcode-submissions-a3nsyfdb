class Solution {
    public int rob(int[] nums) {
        // [rob1, rob2, n, n+1, ...]
        // Input: nums = [2, 9, 8, 3, 6]
        // Algo:                      ^
        // CurrMax = max(n + rob1, rob2) = 16
        // rob1 = 13, rob2 = 16

        int rob1 = 0, rob2 = 0;
        for (int num : nums) {
            int currMax = Math.max(rob2, rob1 + num);
            rob1 = rob2;
            rob2 = currMax;
        }

        return rob2;
    }
}

// Given an integer array nums, where nums[i] represents the most money in the ith house
// You are planning to rob money from these houses, but you cannot rob two ADJACENT houses...
// Because the security system will alert the police if adjacent houses were broken into...
// Return the max money you can rob without alerting the police...

// Input: nums = [1, 1, 3, 3]
// Output: 4

// Input: nums = [2,9,8,3,6]
//                ^   ^   ^
//                  ^   ^
// Output: 16