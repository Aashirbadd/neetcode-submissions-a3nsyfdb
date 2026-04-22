// Input: heights = [
//   [4,2,7,3,4],
//   [7,4,6,4,7],
//   [6,3,5,3,6]
// ]
// Output: [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]
class Solution {
    int ROWS;
    int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        // Constant definition for clean code
        this.ROWS = heights.length;
        this.COLS = heights[0].length;
        // Track which cells can touch each extremity.
        boolean[][] canTouchPacific = new boolean[ROWS][COLS];
        boolean[][] canTouchAtlantic = new boolean[ROWS][COLS];
        // Run DFS on columns first
        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, Integer.MIN_VALUE, canTouchPacific, heights);         // Left (Pacific)
            dfs(i, COLS - 1, Integer.MIN_VALUE, canTouchAtlantic, heights);  // Right (Atlantic)
        }
        // Run DFS on rows second
        for (int i = 0; i < COLS; i++) {
            dfs(0, i, Integer.MIN_VALUE, canTouchPacific, heights);         // Top (Pacific)
            dfs(ROWS - 1, i, Integer.MIN_VALUE, canTouchAtlantic, heights);  // Bottom (Atlantic)
        }
        // Now that we've tracked which cell can reach atlantic and pacific, count them
        List<List<Integer>> output = new ArrayList<>();
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (canTouchPacific[row][col] && canTouchAtlantic[row][col]) {
                    output.add(new ArrayList<>(Arrays.asList(new Integer[] {row, col})));
                }
            }
        }
        // Return total cells that touch pacific & atlantic
        return output;
    }

    // Helper function that marks seen based on previous values
    private void dfs(int i, int j, int prev, boolean[][] seen, int[][] heights) {
        // Assume this function starts at edge, see if it can reach cell or not.
        // For the cell to be valid it must be >= prevValue, and within bounds
        if (i >= ROWS || i < 0 || j >= COLS || j < 0 || 
            seen[i][j] || heights[i][j] < prev) {
            return;
        }
        // Means we are in range && valid (heights[i][j] > prev)
        seen[i][j] = true;
        int curr = heights[i][j];
        // Call dfs to check adjacent cells
        dfs(i + 1, j, curr, seen, heights); // down
        dfs(i - 1, j, curr, seen, heights); // up
        dfs(i, j + 1, curr, seen, heights); // right
        dfs(i, j - 1, curr, seen, heights); // left

        return;
    }
}
