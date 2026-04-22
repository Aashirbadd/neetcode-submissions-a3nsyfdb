class Solution {
    private int[] candidates;
    private int target;
    private List<List<Integer>> output;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // Sort candidates to more easily avoid duplicates.
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        this.output = new ArrayList<>();

        dfs(0, 0, new ArrayList<>());

        return output;
    }

    private void dfs(int currSum, int index, List<Integer> subList) {
        // System.out.printf("index: %d, currSum: %d, subList: %s\n", index, currSum, subList);
        // Base cases
        if (currSum == target) {
            output.add(new ArrayList<>(subList));
            return; // Add copy of subList & return since all new sums are larger than curr.
        }
        if (index >= candidates.length || currSum > target) {
            return; // Means we're out of bounds
        } 

        // Meat of the algorithm.

        // Choose number
        subList.add(candidates[index]);
        dfs(currSum + candidates[index], index + 1, subList);
        // Not choose number
        subList.remove(subList.size() - 1);
        int numToSkip = candidates[index];
        // Skip any duplicates
        while (index < candidates.length && candidates[index] == numToSkip) {
            index += 1;
        }
        // Either index will be out of range (return), or non duplicate
        dfs(currSum, index, subList);
    }
}

// Input candidates which may contain duplicates & target number target
// Return all UNIQUE combinations of candidates that sum upto target.


// Constraints:
    // 1. Each element from candidates may be chosen at most once.
    // 2. Solution set must not contain duplicate combinations.
    //      Idea: I think I can sort to solve this constraint.
    // 3. Combinations can be returned in any order, and order of numbers in each combo can
    //      be in any order.
                        // 0 1 2 3 3 4 5
// Input: candidates = [9,2,2,4,6,1,5], target = 8
//          0 1 2 3 4 5
// Sorted: [1,2,2,4,5,9]
//                      
//          ^         
// Choose [1,9] 

// Not Choose [], [1,n5] 
// For not choose, keep iterating until you find unique number.

// Output: 
// [1,2,5], 