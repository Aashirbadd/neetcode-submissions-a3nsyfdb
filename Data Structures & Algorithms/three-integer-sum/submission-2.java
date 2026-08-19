class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Sorts in ascending by default...
        Arrays.sort(nums);

        // Input: nums = [-1,0,1,2,-1,-4]
        
        List<List<Integer>> output = new ArrayList<>();
        // Double duplicate checking...
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;

            while (l < r) {
                int curr = nums[l] + nums[r];
                int target = nums[i] * -1;
                // Input: nums = [-4, -1, -1, 0, 1, 2]
                //                     i   
                //                            l     r
                // Sol: [-1, -1, 2], [-1, 0, 1]
                
                if (curr == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[r]);

                    output.add(list);
                    // Move one pointer forward...
                    l += 1;
                    // Duplicate handling below...
                    while (l < r && nums[l] == nums[l-1]) {
                        l += 1;
                    }
                } 
                else if (curr < target) {
                    l += 1;
                } 
                else {
                    r -= 1;
                }
            }
            // Duplicate prevention...
            while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                i += 1;
            }
        }

        return output;
    }
}
