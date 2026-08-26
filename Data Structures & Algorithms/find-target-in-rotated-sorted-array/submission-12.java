class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;


        // nums=[3,5,1], target=3
        //       l   r
        //         m

        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                    return mid;
                } 
            
            if (nums[l] <= nums[r]) {
                // Sorted portion...
                if (nums[mid] < target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            } else {
                if (nums[mid] >= nums[l]) {
                    // Sorted left portion...
                    if (target <= nums[mid] && target >= nums[l]) {
                        r = mid - 1;
                    } else {
                        l = mid + 1;
                    }
                } else {
                    // Sorted right portion...
                    if (target >= nums[mid] && target <= nums[r]) {
                        l = mid + 1;
                    } else {
                        r = mid - 1;
                    }
                }
            }
        }

        return -1;
    }
}

// Search in rotated sorted array...


//                0 1 2 3 4 5
// Input: nums = [3,4,5,6,1,2], target = 2 Output: 4
//                l
//                          r
//                        ^
