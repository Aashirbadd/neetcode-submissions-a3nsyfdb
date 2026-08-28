class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Given an array of integers nums, and an integer target, return indices i, j
        // such that nums[i] + nums[j] == target, and i != j...
        HashMap<Integer, Integer> map = new HashMap<>();
        // nums[i] -> i
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        return null;
    }
}
