// Approach:
// 1. Convert the edges list into an adjacency list. (In a graph form)
// 2. Condition: See if that graph is coonnected (no disconnected nodes)
// 3. Condition: See if there are no cycles in the graph
// 4. If both conditions are true, ret true, else false.
class Solution {
    public boolean validTree(int n, int[][] edges) {
        // 1. Convert the edges list into an adjacency list. (In a graph form)
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Nodes will be index number (0 - n-1)
            adjList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);  // x <-> y (undirected means they are both pointing to each other)
        }
        // To check they are connected & cycles, we will use a HashSet<Integer> data structure to assist us
        HashSet<Integer> seen = new HashSet<>();
        // We will use a DFS graph traversal to see if we can touch all nodes
        // from a start point & check for cycles
        if (containsCycle(-1, 0, adjList, seen)) return false;
        // Means it does not contain cycle. Check for second condition (connectedness/ all nodes visited)
        // seen.size() == n means all nodes are visited from a start.
        return seen.size() == n;
    }

    // DFS function to visit all nodes from start & check for cycles
    private boolean containsCycle(int prev, int node, List<List<Integer>> adjList, HashSet<Integer> seen) {
        // Base Cases: (When to return early)
        if (seen.contains(node))    return true;   // Means there is a cycle!
        // Mark node as seen now:
        seen.add(node);
        // Meat of the function: traverse all neighbor nodes
        List<Integer> neighbors = adjList.get(node);
        for (int neighbor : neighbors) {    // Make sure this type cast works (expected to work)
            // Check if neighbor == prev to avoid false positive
            if (neighbor == prev)                               continue;
            // If there is a cycle in a neighbor there is a cycle in the whole graph, ret true
            if (containsCycle(node, neighbor, adjList, seen))   return true;
        }
        // Means all neighbor nodes don't have cycle, ret false, there is no cycle in this graph.
        return false;
    }
}


// Given n nodes (labeled 0 - n-1), and list of undirected edges (of pairs of nodes connected to one another)
// Write a function to check whether these edges make up a valid tree.

// 1. Understand the problem better. (Definitions, Constraints, Test/Edge Cases)
// Definitions:
//  Valid Tree: 1) Connected graph 2) No cycles.
//          x                   x                           x
//         / \               /     \                       /
//        y   z (Valid)     y  --   z (Invalid)           y    z (Invalid)

// Constraints?
//      1. n = number of nodes, labeled from 0 - n-1
//      2. The range of n? (always positive)
// Test Cases: 
//  Run thru some

// Approach:
// 1. Convert the edges list into an adjacency list. (In a graph form)
// 2. Condition: See if that graph is coonnected (no disconnected nodes)
// 3. Condition: See if there are no cycles in the graph
// 4. If both conditions are true, ret true, else false.

// Makes sense? Okay let's go code.