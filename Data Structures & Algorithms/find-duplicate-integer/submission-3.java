class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        while (true) {
            // Basically a do while loop
            slow = nums[slow];
            fast = nums[nums[fast]];

            if (slow == fast) {
                // Break condition, collision occours...
                break;
            }
        }

        // After collision, we want them to meet at the beginning of the cycle...
        int slow2 = 0;

        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];

            if (slow == slow2) {
                return slow;
            }
        }
    }
}
