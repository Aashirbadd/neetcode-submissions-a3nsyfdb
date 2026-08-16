class Solution {
    public int longestOnes(int[] nums, int k) {
        int l = 0;
        int kLeft = k;
        int maxLength = 0;
        // Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
        //                l
        //                          r
        // kLeft = -1
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0)   kLeft -= 1;
            
            int length = r - l + 1;
            if (kLeft >= 0) {
                maxLength = Math.max(maxLength, length);
            } else {
                // Move left pointer until you remove a 0
                while (nums[l] != 0) l += 1;
                l += 1;     // Move one right
                kLeft += 1; // Add a k.
            }
        }

        return maxLength;
    }
}

// Understand question -> Input: binary array, and integer k.
// Goal: We want max number of consecutive 1's in the array. -> You're allowed to also flip k 0's to make it count...

// Let's look at some test cases...
// Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
//                          l
//                                    r
// Max = 3
// Output: 6

// Okay so you essentially count the damn 0's as 1's too (upto k)
// The difficulty is in simply counting the 0's as 1's...

// Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
//                      l
//                                      r
// Output: 10