class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // Run the 2d matrix like it's a 1d matrix
        

        int rows = matrix.length;
        int columns = matrix[0].length;
        int l = 0;
        int r = rows * columns - 1; // Bc 0 idx

        if (rows == 0 || columns == 0) return false;

        while (l <= r) {
            int mid = l + (r-l) / 2; // To prevent int overflow
            int row = mid/columns; // 3*4 12/4 = 3
            int col = mid%columns; // 3*4 12%4 = 0

            if (target == matrix[row][col]) return true;
            else if (target < matrix[row][col]) r = mid - 1;
            else if (target > matrix[row][col]) l = mid + 1;
        }

        return false;
        
    }
}
//   0. 1. 2. 3
// [[1, 2, 4, 8] 0
// [10,11,12,13] 1
// [14,20,30,40]]2
// l = 0
// r = 11
// m = 5
// row = (m/cols) = 3
// col = (m%cols) = 0
// Rows = 3
// Cols = 4
