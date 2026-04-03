class Solution {
    public int[] productExceptSelf(int[] nums) {
        // Create lProd, rProd, and fill them
        int[] lProd = new int[nums.length];
        int[] rProd = new int[nums.length];
        int[] output = new int[nums.length];

        lProd[0] = 1;
        rProd[nums.length - 1] = 1;

        for(int l = 1; l < nums.length; l++){
            int r = (nums.length - 1) - l;
            lProd[l] = lProd[l-1] * nums[l-1];
            rProd[r] = rProd[r+1] * nums[r+1];
        }

        // Fill the output array
        for(int i = 0; i < nums.length; i++){
            output[i] = lProd[i] * rProd[i];
        }

        return output;
    }
}  

// Using the division operation is pretty chill

// Index:         0 1 2 3
// Input: nums = [1,2,4,6]
//                  l
//                r
// LeftProduct =  [01,01,02,8]
// RightProduct = [48,24,06,1]
// ProductOutput= [48,24,12,8]
//  (1 * 2) * 4 == 1 * 2 * 4 == 1 * (2 * 4)
// RightProduct = [1,2,8,48]
// Output: [48,24,12,8]

// Indices:        0 1 2 3 4
// Input: nums = [-1,0,1,2,3]
// Pointer:          ^            
// LeftProduct = [1,-1,0,0,0]
// RightProduct =[0,06,6,3,1]
// ProductOutput=[0,-6,0,0,0]
// Output: [0,-6,0,0,0]

