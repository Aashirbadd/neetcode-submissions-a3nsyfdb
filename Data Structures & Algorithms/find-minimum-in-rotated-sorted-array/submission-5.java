class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while (l <= r) {
            if (nums[l] <= nums[r]) return Math.min(nums[l],min);

            int mid = (l + r) / 2;
            // int mid = l + (r-l) / 2;
            if (nums[mid] < nums[l]) {
                min = Math.min(nums[mid], min);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return min;
    }
}

// Input: int[n] nums (sorted array which has been rotated (1-n) times)
// Goal: Return the minimum number in this array in log(n) time

// Index:         0 1 2 3 4 5
// Input: nums = [3,4,5,6,1,2]
//                l         r
// Ptr:               ^
// If l < r, we are in the sorted portion, we return l
// Otherwise we need to figure out where the pivot point is pivot between 1 and 2 subarray
    // We know the answer will be in the second subarray
    // How do we cut the search space to find the second subarray
    // If MP > L, then subarray will be at r
    // If mp <= L, then subarray will be at left, possibly including l

//  0 1 2 3 4 5
// [1,2,3,4,5,6]
// [6,1,2,3,4,5]
// [5,6,1,2,3,4]
// [4,5,6,1,2,3]
// [3,4,5,6,1,2]
//  l         r
//      ^
// Output: 1