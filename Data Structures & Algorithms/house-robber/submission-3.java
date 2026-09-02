class Solution {
    public int rob(int[] nums) {
        // Index:         0 1 2 3 4
        // Input: nums = [2,9,8,3,6]
        
        // When you're standing in front of house I, you can take the max of 2 back
        // and rob it
        // or you can take the max up until its neighbor

        //  0  1. 2. 3  4
        // [2, 9, 8, 3, 6]
        //                ^
        // curr = Max(rob(i) + rob(twoBack), rob(adjNeighbor)) = 16
        // adjNeighbor = 16
        // twoBack = 12

        int adjNeighbor = 0, twoBack = 0;

        for (int num : nums) {
            int curr = Math.max(num + twoBack, adjNeighbor);
            twoBack = adjNeighbor;
            adjNeighbor = curr;
        }

        return adjNeighbor;
    }
}
