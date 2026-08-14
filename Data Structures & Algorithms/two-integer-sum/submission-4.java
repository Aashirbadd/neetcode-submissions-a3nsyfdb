class Solution {

    // Input: 
    // nums = [3,4,5,6], target = 7
    // Output: [0,1]
    public int[] twoSum(int[] nums, int target) {
        // Give the two indices in nums that add upto target.
        HashMap<Integer, Integer> numsMap = new HashMap<>();    // Maps number -> index

        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            if (numsMap.containsKey(complement) && numsMap.get(complement) != i) {
                return new int[] {i, numsMap.get(complement)};
            }
        }

        // Should never reach here, but returns an empty array in this case.
        return new int[]{};
    }
}
