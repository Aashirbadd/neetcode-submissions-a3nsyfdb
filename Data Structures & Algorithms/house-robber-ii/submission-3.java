class Solution {
    private int[] nums;
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        this.nums = nums;

        int robFirst = helper(0, nums.length - 1);
        int robLast = helper(1, nums.length);

        return Math.max(robFirst, robLast);
    }

    private int helper(int start, int end) {
        int rob1Back = 0, rob2Back = 0;

        for (int i = start; i < end; i++) {
            int robCurr = Math.max(nums[i] + rob2Back, rob1Back);
            rob2Back = rob1Back;
            rob1Back = robCurr;
        }

        return rob1Back;    // By entire linear scan, rob1Back is robCurr
    }
}
