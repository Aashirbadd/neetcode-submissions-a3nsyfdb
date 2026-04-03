class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int t = 0;
        int b = matrix.length - 1;
        int l = 0;
        int r = matrix[0].length - 1;
        
        while (t <= b) {
            int row = (t + b) / 2;
            if (target >= matrix[row][l] && target <= matrix[row][r]) {
                while (l <= r) {
                    int col = (l + r) / 2;
                    if (target == matrix[row][col]) return true;
                    else if (target > matrix[row][col]) l = col + 1;
                    else r = col - 1;
                }
                // return false;
                l = 0;
                r = matrix[0].length - 1;
            }
            if (target > matrix[row][r]) t = row + 1;
            if (target < matrix[row][r]) b = row - 1;
        }

        return false;
    }
}

// Input: int[m][n] matrix, int target
// Rows are sorted in ascending order (Down +)
// Each row will have a greater number, and (left->right+) (increase)
// Goal: Return true if the target exists in the matrix, false otherwise.

// Solution O(log(m*n)) time
// Hint: Double for loop

// Test Case:
// rows:             0 1  2. 3
// Input: matrix = 0[[1,2, 4, 8], 
                // 1[10,11,12,13], 
                // 2[14,20,30,40]], t m b
                //    l        r
                
                
                
                // target = 50

// BS on rows and columns.
// See if target is in correct row, if so run BS on it to find column.
// Else reduce row search space

// Loop, then BS M*log(n)

// Output: true