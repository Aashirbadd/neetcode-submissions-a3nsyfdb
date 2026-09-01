class Solution {
    private List<List<Integer>> adjList;
    private HashSet<Integer> seen;
    public int countComponents(int n, int[][] edges) {
        // Convert to adjList first...
        adjList = new ArrayList<>();
        seen = new HashSet<>();
        for (int i = 0; i < n; i++)         adjList.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                components += 1;
                dfs(i, -1);
            }
        }

        return components;
    }

    // Marks seen nodes
    private void dfs(int curr, int prev) {
        // Base Case: If node is already seen, ret
        if (seen.contains(curr)) {
            return;
        }

        // Mark & process
        seen.add(curr);
        for (Integer neighbor : adjList.get(curr)) {
            if (neighbor != prev) {
                dfs(neighbor, curr);
            }
        }

        return;
    }
}
// Just understand the question

// n nodes, labeled from 0 - n-1... Input: int n, int[][]edges -> edge[i] = [ai, bi] means edge between ai and bi

// Return the number of connected components in the graph....
// Oh this is easy

// Input:
// n = 5, edges = [[0,1],[1,2],[3,4]]
// (0) -> (1) -> (2)
// (3) -> (4)

// Seen = 0, 1, 2, 3, 4...


// Output: 2