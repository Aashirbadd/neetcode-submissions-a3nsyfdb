class Solution {
    
    public int numDecodings(String s) {
        HashMap<Integer, Integer> dp = new HashMap<>();
        return dfs(s, 0, dp);
    }

    private int dfs(String s, int i, HashMap<Integer, Integer> dp) {
        // System.out.printf("I: %d, s[i]: %s\n", i, i < s.length() ? s.charAt(i) : -1);
        // Base Cases:
        if (i == s.length()) {
            return 1;       // Entire string can be decoded in 1 way
        }
        else if (s.charAt(i) == '0') {
            return 0;
        }
        else if (dp.containsKey(i)) {
            return dp.get(i);
        }

        int sol = dfs(s, i+1, dp);

        if (i+1 < s.length()) {
            if (Integer.parseInt(s.substring(i, i+2)) <= 26) {
                sol += dfs(s, i+2, dp);   // Can also be double digit...
            }
        }

        // Cache
        dp.put(i, sol);
        return sol;
    }
}

// Base case:
// Entire string can be decoded in 1 way
// 0 can never be decoded by itself...

// Let's build out the solution with that
// Input: s = "121" Output: 3