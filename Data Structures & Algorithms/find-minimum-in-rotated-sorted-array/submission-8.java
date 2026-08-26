class Solution {
    public int findMin(int[] nums) {
        // Input: nums = [4,5,0,1,2,3]
        int l = 0, r = nums.length - 1;

        int min = Integer.MAX_VALUE;
        while (l <= r) {
            if (nums[l] < nums[r]) {
                // Means you're in the sorted portion, just take potential min and break
                min = Math.min(min, nums[l]);
                break;
            }

            int mid = (l + r) / 2;
            
            if (nums[mid] >= nums[l]) {
                // Search right...
                min = Math.min(min, nums[l]);
                l = mid + 1;
            } else {
                // Search left?
                min = Math.min(min, nums[mid]);
                r = mid - 1;
            }
        }

        return min;
    }
}
// Find the minimum element in a sorted array... I have no clue how to do this tbh...


