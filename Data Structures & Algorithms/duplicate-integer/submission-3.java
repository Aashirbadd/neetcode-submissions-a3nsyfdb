class Solution {
    public boolean hasDuplicate(int[] nums) {

        HashSet<Integer> seen = new HashSet<Integer>();
        for(int num:nums){
            if(seen.contains(num))
                return true;
            else
                seen.add(num);
        }
        return false;
    }
}

// Input: nums = [1, 2, 3, 3]
//                         ^
//         map = {1:1, 2:1, 3:2}
// map (key:num, val:counter)

// Ret true if i == j
// else keep looping
// ret false, if looped through the whole array