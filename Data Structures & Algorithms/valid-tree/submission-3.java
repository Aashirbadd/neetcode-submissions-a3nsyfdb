class Solution {
    private List<List<Integer>> adjList;
    private HashSet<Integer> seen;

    public boolean validTree(int n, int[][] edges) {
        // Undirected edges, see if these edges make up a valid tree.
        // What changes up a regular graph from a tree?
        // Tree Properties: 1) Has no cycles 2) Is fully connected

        // N nodes labeled from 0 - (n-1). And list of undirected edges. Let's convert that to a adjList
        adjList = new ArrayList<>();
        seen = new HashSet<>();

        for (int i = 0; i < n; i++)     adjList.add(new ArrayList<Integer>());
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        boolean containsCycle = cycleCheck(0, -1);

        return seen.size() == n && !containsCycle;
    }

    // DFS function to see whether there is a cycle within adjList
    private boolean cycleCheck(int curr, int prev) {
        // Base Case
        if (seen.contains(curr))    return true;

        seen.add(curr);
        // Traverse all neighbors
        for (Integer neighbor : adjList.get(curr)) {
            if (neighbor != prev && cycleCheck(neighbor, curr)) {
                return true;
            }
        }

        // Means no neighbors have cycles
        return false;
    }
}

// What defines valid tree?
// It is hierarchical, idk just watch the NC vid lol... Time to EAt!