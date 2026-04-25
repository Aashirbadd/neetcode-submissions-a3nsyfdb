class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        int includeFirst = robRange(nums, 0, nums.length - 1);
        int includeLast = robRange(nums, 1, nums.length);
        return Math.max(includeFirst, includeLast);
        // Dynamic programming does not fit into the constraints you're putting it in. Only the one it's saying.
    }

    private int robRange(int[] nums, int start, int end) {
         // [rob2, rob1, robn, robn+1, ...]
        int rob1 = 0, rob2 = 0;

        for (int n = start; n < end; n++) {
            int robN = Math.max(rob1, rob2 + nums[n]);
            rob2 = rob1;
            rob1 = robN;
        }
        return rob1;    // Rob1 is robN (considering all N houses in range).
    }
}
