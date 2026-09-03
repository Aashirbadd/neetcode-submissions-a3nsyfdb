class Solution {
    public int maxProduct(int[] nums) {
        int currMax = 1;
        int currMin = 1;
        int sol = Integer.MIN_VALUE;

        for (int num : nums) {
            int oldCurrMax = currMax;
            currMax = Math.max(Math.max(currMax * num, currMin * num), num);
            currMin = Math.min(Math.min(oldCurrMax * num, currMin * num), num);

            sol = Math.max(currMax, sol);
        }

        return sol;
    }
}
