class Solution {
    public int search(int[] nums, int target) {
        // Input: nums = [-1,0,2,4,6,8], target = 4
        //                 l
        //                           r
        // Output: 3
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int curr = nums[mid];

            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                r = mid - 1;
            }
            else {
                l = mid + 1;
            }
        }

        return -1;
    }
}
