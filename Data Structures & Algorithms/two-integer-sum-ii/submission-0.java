class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;

        // Return indices 1 indexed
        while (l < r) {
            int current = numbers[l] + numbers[r];
            if (current == target) 
                break;
            else if (current > target)
                r -= 1;
            else if (current < target)
                l += 1;
        }

        return new int[] {l+1, r+1};
    }
}

// Input: int[] numbers, sorted in ascending order
// Return (1 Indexed) of two numbers [i,j] which add up to the target number.
    // i < j, i != j


// Indices:          0 1 2 3
// Input: numbers = [-1,0,1,2,3,4,5,6], target = 3
//                    l             
//                              r
// Output: [1,2]
// O(n) time
// O(1) space

// Exactly one valid solution, so return after you find that valid solution.