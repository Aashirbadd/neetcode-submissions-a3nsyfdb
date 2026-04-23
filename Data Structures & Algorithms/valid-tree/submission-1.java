class Solution {
    public boolean validTree(int n, int[][] edges) {
        // Check that it is a connected graph (all nodes touch)
        // Check there are no cycles (only 1 path from node x - y)
        HashSet<Integer> seen = new HashSet<>();
        List<List<Integer>> adj = new ArrayList<>();
        // 1. Create adjacencyList
        for (int i = 0; i < n; i ++)    adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            // Connect the edges to one another
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // 2. For each node in adj, check if it is connected & has no cycles
        
        return !containsCycle(0, adj, seen, -1) && seen.size() == n;
    }

    private boolean containsCycle(int node, List<List<Integer>> adjList, HashSet<Integer> seen, int prev) {
        // System.out.println(node);
        // Base case, if seen, ret false because it means cycle
        if (seen.contains(node))        return true;

        // Mark node & travel to neighbors
        seen.add(node);
        List<Integer> neighbors = adjList.get(node);

        for (int neighbor : neighbors) {
            if (neighbor == prev)   continue;
            if (containsCycle(neighbor, adjList, seen, node)) return true;
        }

        // It means there are no cycles in this graph
        // System.out.printf("Seen size: %d\n", seen.size());
        return false;
    }
}

// Input: int n ~ (number of nodes labeled 0 - n-1), 
//        int[][] edges (pair of nodes, undirected connections)

// Goal: Check whether these edges make a valid tree:

// Clarifying Questions:
    // 1. Hierarchical tree? (meainng in the end it needs to be directed right)
    // 2. Binary tree? or n ary tree?

// Testcases:

// Input:
// n = 5
// edges = [[0, 1], [0, 2], [0, 3], [1, 4]]

// Map to adjacencyList:
    // 3 -- 0 -- 1 - 4
    //      |
    //      2

// Output:
// true, since there is a logical parent flow of 0 (3,2,1(4))
    // If we can easily trace parent to child then it makes sense.


// Input:
// n = 5
// edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]]

// AdjacencyList:
//                  3
//                /  \
//          0 -- 1 -- 2
//               |
//               4

// Output:
// false