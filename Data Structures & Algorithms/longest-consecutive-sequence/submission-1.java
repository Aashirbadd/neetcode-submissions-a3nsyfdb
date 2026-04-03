class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        
        // Put nums in the set
        for (int num : nums) {
            set.add(num);
        }
        // Find largest sequence, and return it
        int largest = 0;
        for (int num : nums){
            if (!set.contains(num-1)){
                // Means we're at the start of the sequence
                int current = 1;
                while (set.contains(num + current)){
                    current += 1;
                }
                largest = Math.max(largest, current);
            }
        }
        return largest;
    }
}

// Return the length of the LONGEST consecutive sequence of elements in the order.
// Ie: 1, 2, 3 --> i, i+1, i+2 = Sequence of 3
// NOTE: The elements do NOT have to be consecutive in the original array.

// You must write an algorithm in O(n) time. --> So no sorting.

// Test Cases:
// Index:         0 1  2 3  4 5 6
// Input: nums = [2,20,4,10,4,5,3]
//                          ^
//                              ^
// LongestAtI  = [2,01,03,1,1,1,4]
// Output: 4

// Input: nums = [0,3,2,5,4,6,1,1]
//                ^
// Set: {0,1,2,3,4,5,6}
// Output: 7

// [1, 2, 3, 10, 11, 12]