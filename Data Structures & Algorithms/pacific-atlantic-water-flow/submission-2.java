class Solution {
    private int ROWS;
    private int COLS;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        ROWS = heights.length; COLS = heights[0].length;
        boolean[][] canReachPacific = new boolean[ROWS][COLS];
        boolean[][] canReachAtlantic = new boolean[ROWS][COLS];

        // Fill with false
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                canReachPacific[i][j] = false;
                canReachAtlantic[i][j] = false;
            }
        }

        for (int i = 0; i < ROWS; i++) {
            dfs(i, 0, heights, canReachPacific, heights[i][0]);
            dfs(i, COLS - 1, heights, canReachAtlantic, heights[i][COLS - 1]);
        }

        for (int j = 0; j < COLS; j++) {
            dfs(0, j, heights, canReachPacific, heights[0][j]);
            dfs(ROWS - 1, j, heights, canReachAtlantic, heights[ROWS - 1][j]);
        }

        List<List<Integer>> output = new ArrayList<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (canReachPacific[i][j] && canReachAtlantic[i][j]) {
                    List<Integer> coords = Arrays.asList(i, j);
                    output.add(coords);
                }
            }
        }

        return output;
    }

    private void dfs(int row, int col, int[][] heights, boolean[][] seen, int prev) {
        // Water can only flow from >= prev
        // Base Cases
        // System.out.printf("Row: %d, Col: %d\n", row, col);
        if (row < 0 || row >= ROWS || col < 0 || col >= COLS || seen[row][col] ||
            heights[row][col] < prev) {
            return;
        }

        // Otherwise, mark, and check adjacent
        seen[row][col] = true;

        dfs(row + 1, col, heights, seen, heights[row][col]);
        dfs(row - 1, col, heights, seen, heights[row][col]);
        dfs(row, col + 1, heights, seen, heights[row][col]);
        dfs(row, col - 1, heights, seen, heights[row][col]);
    }
}

// Start at edges and go in...