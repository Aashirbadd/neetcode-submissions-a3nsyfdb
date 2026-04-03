class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        //  0 1 2 3 4 5 6
        // [3,1], t=1
        //  l r
        //  ^
        while (l <= r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;

            if (nums[l] < nums[r]) {
                // Normal BS
                if (target > nums[mid]) l = mid + 1;
                else r = mid - 1;
            } else if (nums[mid] > nums[l]) {
                // Left is sorted
                if (mid != l && target >= nums[l] && target <= nums[mid-1]) r = mid - 1;
                else l = mid + 1;
            } else {
                // Right is sorted
                if (mid != r && target >= nums[mid+1] && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}

// Input: int[n] nums (rotated 1-n times), int target
// Goal: Return index of target, else -1.

// Visualise:
// [6,1,2,3,4,5] 1
// [5,6,1,2,3,4] 2
// [4,5,6,1,2,3] 3
// [2,3,4,5,6,1] 5
// [3,4,5,6,1,2] 4
// [1,2,3,4,5,6] 0-6
//            lr
//              ^
// If mid == target, ret mid;
// If l < r (we are in an entirely sorted array), normal BS from here
// If l > right (we are in between subarrays)
    // Goal: Go to the correct subarray which is closer to the target number
    // If MP > left, (left portion is sorted)
        // If we want a higher number than mid, we go right
        // If we want a number between l and mid, we go left
    // If MP < left, (right portion is sorted)
        // If we want a number between mid and right, we go right
        // Else we go left

