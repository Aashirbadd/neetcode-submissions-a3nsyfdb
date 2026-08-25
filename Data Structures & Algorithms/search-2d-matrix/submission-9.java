class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int size = rows * cols;
        int l = 0;
        int r = size - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            int row = mid / cols;
            int col = mid % cols;
            int curr = matrix[row][col];

            if (curr == target) {
                return true;
            } else if (curr > target) {
                r = mid - 1;
            } else if (curr < target) {
                l = mid + 1;
            }
        }

        // Binary search has ran on the entire matrix, the sol does not exist...
        return false;
    }
}


// Input is a 2d array matrix...
// Each row is sorted in non decreasing
// The first integer in every row is greater than the last integer in the previous row...
// Ret true if target exists within the matrix, or false otherwise...

// Can you write a solution that runs in O(log (m * n)) time?

// Yeah you can.. Just treat it as a flat array of m * n and run binary search on it...
// Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
//                   0 1 2 3   4   5  6  7    8  9  10 11
// Output: true

// How to convert from int to row and col?
// Row would be num / col 3/4 = 0
// Col would be num % col 3%4 = 3


