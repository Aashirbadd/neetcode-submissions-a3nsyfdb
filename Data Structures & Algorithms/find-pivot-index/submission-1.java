class Solution {
    public int pivotIndex(int[] nums) {
        int[] l = new int[nums.length];
        int[] r = new int[nums.length];

        //        left = [1,8,11,17,22,28]
        //        rigt = [28,27,20,17,11,6]
        // Input: nums = [1,7,3,6,5,6]
        // Fills from left side
        for (int i = 0; i < nums.length; i++) {
            int prev = (i == 0) ? 0 : l[i-1];
            l[i] = prev + nums[i];
            // System.out.printf("LIdx: %d, val: %d\n", i, l[i]);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            int prev = (i == nums.length - 1) ? 0 : r[i+1];
            r[i] = prev + nums[i];
            // System.out.printf("RIdx: %d, val: %d\n", i, r[i]);
        }

        for (int i = 0; i < nums.length; i++) {
            if (l[i] == r[i]) return i;
        }


        return -1;
    }
}

// Understand: Input: Integer array nums.
// Goal: Calculate pivot index? -> Def?

// Pivot Index: Index where sum of all numbers of the left == sum of all numbers to the right of that index...

// Does that mean we need running sum of left and right, and calculate? Lol.


//        left = [1,8,11,17,22,28]
//        rigt = [28,27,20,17,11,6]
// Input: nums = [1,7,3,6,5,6]
//                  i
// Output: 3

// Build it out and the solution just spawns...