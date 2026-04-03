class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // First let's sort the input array.
        Arrays.sort(nums);

        // nums=[-1,0,1,2,-1,-4]
        // sort=[-4,-1,-1,0,1,2]
        //        i
        //              l
        //                    r
        // Now run the two pointer
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length -2; i++) {
            // Run two pointer for l & r to find any triplets
            int l = i+1;
            int r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    output.add(new ArrayList(List.of(nums[i], nums[l], nums[r])));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (r > l && nums[r] == nums[r-1]) r--;
                    l++;
                }
                else if (sum > 0) r--;
                else if (sum < 0) l++;
            }
            while (i < nums.length-2 && nums[i] == nums[i+1]) i++;
        }
        return output;
    }
}

// Input: int[] nums

// Return: All triplets nums[i], nums[j], nums[k] where their sums == 0, and i,j,k are unique
    // Extra conditional: No triplets!

// Example:
// Indices:        0 1 2 3  4  5
// Input: nums = [-1,0,1,2,-1,-4]
// Sorted:nums = [-5,-4,-1,-1,0,1,2,3,4,5]
// i                  ^
// j                     ^
// k                                ^
// Output: [[-5,0,5],[-5,1,4],[-5,2,3],[],[-1,-1,2],[-1,0,1],]
// Output: [[-1,-1,2],[-1,0,1]]
// O(n^2)
// O(1 or n) (depending on the sorting library under the hood.)