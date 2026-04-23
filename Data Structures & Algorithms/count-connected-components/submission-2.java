// 1. Convert the list of edges into an adjacencyList so we can more easily traverse it.
// 2. Keep a seen hashSet to track visited nodes & do a DFS traversal starting from node 0
//  to n-1 & increment. Skip seen nodes, and for every new node we will increment & run DFS again.

class Solution {
    public int countComponents(int n, int[][] edges) {
        // 1. Convert the list of edges into an adjacencyList so we can more easily traverse it.
        List<List<Integer>> adjList = new ArrayList<>();
        // Fill adjList with empty arrays   {[],[],[]}
        for (int i = 0; i < n; i++)     adjList.add(new ArrayList<>());
        // Fill out adjList to represent edges correctly
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);  // [x,y] x <-> y
        }
        //  2. Keep a seen hashSet to track visited nodes & do a DFS traversal starting from node 0
        //  to n-1 & increment. Skip seen nodes, and for every new node we will increment & run DFS again.
        HashSet<Integer> seen = new HashSet<>();
        int connectedComponents = 0;
        for (int i = 0; i < n; i++) {
            if (!seen.contains(i)) {
                connectedComponents += 1;   // Increment num of connectedComponents
                dfs(i, adjList, seen);      // DFS to start from 1 to all connected neighbors.
            }
        }
        // Return number of connected components
        return connectedComponents;
    }

    // Runs DFS to touch all connected neighbors from starting node, and add to seen HashSet.
    private void dfs(int startNode, List<List<Integer>> adjList, HashSet<Integer> seen) {
        // Base Case (when to return early)? Seen? (Y), anything else
        if (seen.contains(startNode)) return;
        // Mark node as seen
        seen.add(startNode);
        // Meat of solution: DFS traversal to all neighbors
        List<Integer> neighbors = adjList.get(startNode);
        for (int neighbor : neighbors) {
            dfs(neighbor, adjList, seen);
        }
        // Complete DFS traversal. Return.
        return;
    }
}

// Understand question:
// 1 -- 2 -- 3
// Input: int n ~ You have a graph of n nodes.
//          int[][] edges ~ edges[i] = [aᵢ, bᵢ] denites edges between two nodes.

// Definitions: Clear.
// Test Cases: Clear.

// Constraints/Clarifying Questions:
// 1. No repeated edges
// 2. Are nodes always labeled from (0 - n-1)? Yes. Good to know.
// 3. Does the graph have any cycles? And how should we handle them if it does. No.

// How I will tackle this problem:
// 1. Convert the list of edges into an adjacencyList so we can more easily traverse it.
// 2. Keep a seen hashSet to track visited nodes & do a DFS traversal starting from node 0
//  to n-1 & increment. Skip seen nodes, and for every new node we will increment & run DFS again.

// Go back to you. Does this make sense? And how does it sound from your perspective?
// SG. I will implement this, and after implementation we will run through test cases & runtime analysis.