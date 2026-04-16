class Solution {
    private List<List<Integer>> output;
    private int[] nums;
    private int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
        this.output = new ArrayList<>();

        dfs(new ArrayList<>(), 0, 0);

        return this.output;
    }

    private void dfs(List<Integer> currSubset, int currSum, int index) {
        // Second Basecase
        if (currSum == target) {
            output.add(new ArrayList<>(currSubset));
            return;
        }
        // Basecase
        if (index >= nums.length || currSum > target) return;
                
        // Add Case
        currSubset.add(nums[index]);
        dfs(currSubset, currSum + nums[index], index);
        // Remove Case
        currSubset.remove(currSubset.size() - 1);
        dfs(currSubset, currSum, index + 1);
    }
}