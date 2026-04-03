class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> seen = new HashMap();

        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            int pair = target - num;
            if (seen.containsKey(pair)){
                return new int[]{seen.get(pair), i};
            }
            seen.put(num, i);
        }
        
        return null;
    }
}


// Input: int[] nums, int target
// output: int[] --> [i, j], i != j, nums[i] + nums[j] == target

// Return the indices of nums that sum up to target.
// Return the smaller index first.

//         0 1 2 3
// nums = [3,4,5,6], target = 7
//           ^

// seen = {3:0, }
// j = 1
// Output: [0,1]

// index:         0 1 2
// Input: nums = [4,5,6], target = 10
// i              - - ^
// seen: {4:0, 5:1, }

// Output: [0,2]