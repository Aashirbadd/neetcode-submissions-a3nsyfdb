class Solution {
    private int ROWS;
    private int COLS;
    public int numIslands(char[][] grid) {
        // Commonly used variables
        this.ROWS = grid.length;
        this.COLS = grid[0].length;
        // Initialise seen array
        boolean[][] seen = new boolean[ROWS][COLS];
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                seen[i][j] = false;
            }
        }

        int islands = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == '1' && !seen[i][j]) {
                    islands += 1;
                    markIsland(grid, seen, i, j);
                }
            }
        }

        return islands;
    }

    // DFS to traverse entire island & mark it.
    private void markIsland(char[][] grid, boolean[][] seen, int i, int j) {
        // Base cases:
        // If it's seen, out of bounds, or is water, return.
        if (i >= ROWS || j >= COLS || i < 0 || j < 0 || 
            grid[i][j] == '0' || seen[i][j]) { 
                return;
        }
        // Else: It means we are at land, mark it, and run dfs for adjacent neighbors.
        seen[i][j] = true;
        markIsland(grid, seen, i + 1, j);   // Row below (Down)
        markIsland(grid, seen, i - 1, j);   // Row above (up)
        markIsland(grid, seen, i, j + 1);   // Next column (right)
        markIsland(grid, seen, i, j - 1);   // Prev column (left)
    }
}
