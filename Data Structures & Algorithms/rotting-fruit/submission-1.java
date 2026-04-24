class Solution {
    private int EMPTY = 0;
    private int FRESH = 1;
    private int ROTTEN = 2;

    private int[][] directions = new int[][]{{1,0}, {-1,0}, {0,1}, {0,-1}};
    // down, up, right, left

    public int orangesRotting(int[][] grid) {
        // Assume you're allowed to modify original data.
        Queue<int[]> q = new LinkedList<>();
        // Begin BFS with all rotten elements in the q.
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == ROTTEN)   q.add(new int[] {i, j});
            }
        }
        int days = 0;
        // Run BFS
        while (!q.isEmpty()) {
            // Every new day that passes, rot adjacent cell
            int rottenCount = q.size();
            boolean additionalFruitRotten = false;
            // For all rotten fruit, check adjacent cells, & rot fresh adjacent fruit.
            for (int i = 0; i < rottenCount; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                // Add all adjacent cells that might be fresh rn.
                for (int[] direction : directions) {
                    int newRow = row + direction[0];
                    int newCol = col + direction[1];
                    // Check bounds
                    if (newRow < 0 || newRow >= grid.length || newCol < 0 || newCol >= grid[0].length) continue;
                    // If fresh, we rot it, and add to q
                    if (grid[newRow][newCol] == FRESH) {
                        // System.out.printf("newRow: %d, newCol: %d\n", newRow, newCol);
                        additionalFruitRotten = true;
                        q.add(new int[] {newRow, newCol});
                        grid[newRow][newCol] = ROTTEN;
                    }
                }
            }
            if (additionalFruitRotten) days += 1;
        }

        // Check if there are any fresh fruit remaining
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == FRESH)    return -1;
            }
        }

        // Means all oranges are rotten, return # of days it took for all of them to rot.
        return days;
    }
}
// grid=[   [1,1,0],
//          [0,1,1],
//          [0,1,2]]


// Given a 2d matrix (grid), each cell can have one of 3 possible values:
    // 0 ~ Represents an empty cell
    // 1 ~ fresh fruit
    // 2 ~ rotten fruit
// Every minute, vertically & adjacent fruits get rotten.

// Return # of minutes that must elapse until 0 fresh fruits are remaining. Else return -1.