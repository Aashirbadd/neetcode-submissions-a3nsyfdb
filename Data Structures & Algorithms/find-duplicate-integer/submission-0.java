class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        // Now slow and fast are at the intersection. We need to keep looping until they meet again.
        int head = 0;
        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }

        return head;
    }
}

// Input: int[] nums, contains n+1 integers, range 1-n
    // Each number in the input array, is <= to its index.

// Indices:       0 1 2 3 4
// Input: nums = [1,2,3,2,2]
//                    s
//                    f
//                    h
// Output: 2

// 0 -> 1 -> 2 <-> 3
//           ^
//           4

// Index where they meet will be the gate of the cycle, and includes the cyclical number