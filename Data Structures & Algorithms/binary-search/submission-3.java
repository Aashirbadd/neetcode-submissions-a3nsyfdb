class Solution {
    public int search(int[] nums, int target) {
        // if num, ret num
        // if num > c, l = m+1
        // if num < c, r = m-1
        // i      0 1 2 3 4 5
        // nums=[-1,0,3,5,9,12]
        //        l          r
        //                ^
        // target=9
        int l = 0;
        int r = nums.length -1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int curr = nums[mid];
            if (curr == target) return mid;
            else if (target > curr) l = mid + 1;
            else if (target < curr) r = mid - 1;
        }
        return -1;
    }
}

// Input: int[] nums (sorted ascending), int target
// Goal: Return index of target within nums if it exists, else -1.

// Test Case:
//        index:   0 1 2 3 4 5
// Input: nums = [-1,0,2,4,6,8], target = 4
//                       l r
//                       ^
// Output: 3

