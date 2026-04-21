class Solution {
    private List<List<Integer>> output;
    private int[] nums;
    private int target;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        output = new ArrayList<>();
        this.nums = nums;
        this.target = target;

        // This helper function will hydrate the output member variable.
        dfs(0, 0, new ArrayList<>());

        return output;
    }

    private void dfs(int index, int currSum, List<Integer> subList) {
        // Base Cases:
        if (index >= nums.length || currSum > target)  return;
        else if (currSum == target) {
            output.add(subList);
            return;     // Because no more solutions since we have only + nums
        }

        // We are in a valid case now, what do we do?

        // Choose that number
        subList.add(nums[index]);
        dfs(index, currSum + nums[index], new ArrayList(subList));

        // Not choose that number
        subList.remove(subList.size() - 1);
        dfs(index + 1, currSum, new ArrayList(subList));
    }
}


// In the input array nums, return all the unique combinations that add up to "target"

// Constraints:
    // 1. Combinations can be returned in any order
    // 2. Order of the numbers in each combination can be in any order
    // 3. The same number can be chosen from nums an unlimited number of times.
    // 4. Two combinations are the same if the FREQUENCY of each chosen number is the same
    //      else they are different.

// Questions:
    // Will there always be an answer
    // Will there be any negative numbers?

// Algorithm:
// For each input:
// Input: nums = [2,5,6,9], target = 9

// choose the number in that index again, or continue with what we have so far 
    // and check the number in the next index

// Decision Tree:
//              2
//         2,2(4)   2,5(7)
//      2,2,2(6)    2,2,5(9)
// ...