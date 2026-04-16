class Solution {
    private int[] nums;
    private List<List<Integer>> output;

    public List<List<Integer>> subsets(int[] nums) {
        this.output = new ArrayList<>();
        this.nums = nums;

        dfs(0, new ArrayList<>());
        return output;
    }

    private void dfs(int index, List<Integer> currSubset) {
        // System.out.printf("size: %d, i: %d\n", currSubset.size(), index);
        if (index >= nums.length) {
            output.add(new ArrayList<>(currSubset));
            return;
        }

        // Choose element at index
        currSubset.add(nums[index]);
        dfs(index + 1, currSubset);

        // Not choose element at index
        currSubset.remove(currSubset.size() - 1);   // Remove element at the end
        dfs(index + 1, currSubset);
    }
}

// Given an array nums of **unique** integers, return all possible subsets of nums

// Input: nums = [1,2,3]

// Brute force, for all i, j create a subset, and return that sublist of nums O(n^2)
// Anything else? Some sort of recursion?
// Output: Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
