class Solution {
    private int ROWS;
    private int COLS;
    private int EMPTY = 0;
    private int FRESH = 1;
    private int ROTTEN = 2;

    private int[][] directions = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int orangesRotting(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        LinkedList<int[]> q = new LinkedList<>();
        // Do a first pass and put all rotten oranges in the q.
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == ROTTEN) {
                    q.add(new int[] {i, j});
                }
            }
        }

        int minutes = 0;
        while (!q.isEmpty()) {
            // Rot all adjacent oranges IG...
            int orangesToProcess = q.size();
            boolean anyRotten = false;
            while (orangesToProcess-- > 0) {
                int[] curr = q.poll();

                for (int[] direction : directions) {
                    int newRow = curr[0] + direction[0];
                    int newCol = curr[1] + direction[1];

                    if (newRow < 0 || newRow >= ROWS || newCol < 0 || newCol >= COLS ||
                        grid[newRow][newCol] == EMPTY || grid[newRow][newCol] == ROTTEN) {
                            continue;
                        }
                    
                    // Else Mark & add to queue
                    grid[newRow][newCol] = ROTTEN;
                    anyRotten = true;
                    q.add(new int[] {newRow, newCol});
                }
            }
            minutes += anyRotten ? 1 : 0;
        }

        boolean allRotten = true;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (grid[i][j] == FRESH)    allRotten = false;
            }
        }

        return allRotten ? minutes : -1;
    }
}

// In a 2d grid, each cell can have 3 possible values...
// 0 = empty, 1 = fresh, 2 = rotten

// Every minute, if a fresh fruit horizontally or vertically adjacent is not rotten, it also becomes
// rotten...

// Return number of minutes that must elapse until there are no fresh fruits remaining...
// If that is impossible, return -1...