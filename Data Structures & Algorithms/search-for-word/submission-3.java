class Solution {
    public boolean exist(char[][] board, String word) {
        boolean[][] seen = new boolean[board.length][board[0].length];
        resetArray(seen);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, 0, i, j, seen)) return true;
            }
        }
        return false;
    }

    private void resetArray(boolean[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                array[i][j] = false;
            }
        }
    }

    private boolean dfs(char[][] board, String word, int wordIndex, int i, int j, boolean[][] seen) {
        // System.out.printf("WordIndex: %d\n", wordIndex);
        // Base Cases:
        if (wordIndex >= word.length()) {
            return true;    // Go till out of range
        }
        
        if (i >= board.length || i < 0 ||
                    j >= board[0].length || j < 0 ||
                    seen[i][j] ||
                    board[i][j] != word.charAt(wordIndex)) {
            return false;   // Out of bounds
        }
        // System.out.printf("Word: %s, board[i][j] : %c, wordIndex: %d, i: %d, j: %d\n",
        //  word, board[i][j], wordIndex, i, j);

        // Meat of solution:
        // Mark seen
        seen[i][j] = true;
        // 1. Choose letter: (Assuming char (i) == correct num)
        boolean down = false, up = false, left = false, right = false;
        if (board[i][j] == word.charAt(wordIndex)) {
            down = dfs(board, word, wordIndex + 1, i + 1, j, seen);  // down;
            up = dfs(board, word, wordIndex + 1, i - 1, j, seen);  // up;
            right = dfs(board, word, wordIndex + 1, i, j + 1, seen);  // right;
            left = dfs(board, word, wordIndex + 1, i, j - 1, seen);  // left;
        }
        // Reset that seen value
        seen[i][j] = false;
        // Return if something was found
        return left || right || down || up;
    }
}

// Given a 2d grid of characters (Board), and a string word, 
    // ret true if the word is in the grid
    // else false

// For the word to be present it must be possible to form it with a path vertically or horizantally
// Same cell cannot be used more than once

// Input: 
// board = [
//   ["A","B","C","D"],
//   ["S","A","A","T"],
//   ["A","C","A","E"]
// ],
// word = "CAT"

// Output: true

// DFS with include/exclude logic.