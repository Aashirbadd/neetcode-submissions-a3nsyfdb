class Solution {
    // Constants
    char LAND = '1';
    char WATER = '0';

    // Directions
    int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands(char[][] grid) {
        // Count and return the number of islands...
        int islands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == LAND) {
                    islands += 1;
                    markSeen(grid, i, j);
                }
            }
        }

        return islands;
    }

    private void markSeen(char[][] grid, int row, int col) {
        // DFS right? Okay, it's iterative remember... Okay...
        // So you go in directions right.. Right...
        // BFS requires a q, DFS requires a stack? I think so..
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {row, col});

        while (!stack.isEmpty()) {
            int[] rowCol = stack.pop();
            row = rowCol[0];
            col = rowCol[1];

            grid[row][col] = WATER;   // Mark here so even entry point is good...

            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Make sure it is in range
                if (newRow >= grid.length || newRow < 0 || newCol >= grid[0].length || newCol < 0) {
                    continue;
                }

                if (grid[newRow][newCol] == LAND) {
                    stack.push(new int[] {newRow, newCol});
                }
            }
        }

        return;
    }
}


// Input: grid = [
//     ["1","1","0","0","1"],
//     ["1","1","0","0","1"],
//     ["0","0","1","0","0"],
//     ["0","0","0","1","1"]
//   ]
// Output: 4

// 1's are land, 0's are water.
// Count and return the number of islands: Meaning adjacent lands (horizontally & vertically)
// water is surrounding the grid. Return the number of unconnected 1's...