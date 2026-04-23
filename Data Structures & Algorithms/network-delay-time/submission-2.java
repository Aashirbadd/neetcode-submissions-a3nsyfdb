// Implement Solution:
// 1. Convert times into an adjancency list so it is represented as a graph which can be easily traversed
// 2. Traverse from start node to all nodes (noting the best time to reach each node)
// 3. Out of all the nodes return the min time to reach all nodes.
class Solution {
    // Indices of graph elements
    private int TARGET = 0;
    private int TIME = 1;
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Convert times into an adjancency list so it is represented as a graph which can be easily traversed
        List<List<int[]>> adjList = new ArrayList<>();
        // Fill with empty arrays (nodes 1 - n)
        for (int i = 0; i < n+1; i++)   adjList.add(new ArrayList<>());
        // Fill out adjList
        for (int[] time : times) {
            int source = time[0];
            int target = time[1];
            int _time = time[2];
            adjList.get(source).add(new int[] {target, _time});
        }
        // 2. Traverse from start node to all nodes (noting the best time to reach each node)
        // This will note best time to reach each node.
        HashMap<Integer, Integer> timeToReachNode = new HashMap<>();
        // Now we will use DFS to traverse from start of node to all nodes.
        dfs(k, 0, adjList, timeToReachNode);
        // DFS function will fill out timeToReachNode for all nodes from start (k), use that for final answer

        // EDGE CASE: Unconnected graph, not all nodes were reached.
        if (timeToReachNode.size() < n) return -1;

        // All nodes were reached, return max (time where all of them are reached)
        int timeToReachAll = 0;
        for (int node : timeToReachNode.keySet()) {
            timeToReachAll = Math.max(timeToReachAll, timeToReachNode.get(node));
        }
        // return time to reach all
        return timeToReachAll;
    }

    private void dfs(int node, int elapsedTime, List<List<int[]>> adjList, HashMap<Integer, Integer> timeToReachNode) {
        // System.out.printf("node: %d\n", node);
        // Base case (when to return early)?
        // 1. When elapsedTime > timeToReachNode (ret early, we've already calculated).
        if (timeToReachNode.containsKey(node) && elapsedTime >= timeToReachNode.get(node)) return;
        // Fill out time
        timeToReachNode.put(node, elapsedTime);
        // Run DFS on neighbors
        List<int[]> neighbors = adjList.get(node);
        for (int[] neighbor : neighbors) {
            dfs(neighbor[TARGET], elapsedTime + neighbor[TIME], adjList, timeToReachNode);
        }
        // We've reached all neighbors from startNode, return.
        return;
    }
}
//  (1)   (1)
// 1 > 2 > 3
//     ^

// Understand question: 

// Input: int n ~ number of directed nodes (indexed 1-n)
//        int[][] times ~ directed edges times[i] = (ui, vi, ti)
//          ui = source node (1-n), vi = target node (1-n), ti = weight (time from v -> t)
//        int k ~ Node we will send signal FROM (start node)

// Return the MINIMUM time it will take for ALL nodes to recieve the signal. If impossible return -1 instead.

// Test cases:
// Input: times = [[1,2,1],[2,3,1],[1,4,4],[3,4,1]], n = 4, k = 1

//               1
//       (1) /        \ (4)
//          2           4
//          (1) \     ^ (1)
//                3

// We can calculate this with a DFS from the start node to the next node. For each node we report the
// Minimum time it took to reach that edge. Out of all the minimum times, we will return the MAX
// Because that's the time to reach ALL NODES.

// Coding Approach:
// 1. Convert times into an adjancency list so it is represented as a graph which can be easily traversed
// 2. Traverse from start node to all nodes (noting the best time to reach each node)
// 3. Out of all the nodes return the min time to reach all nodes.

// Question:
// 1. Can there be cycles in the graph?
// 2. Can there possibly be unconnected parts? Yes -> Ret -1 in that case
// 3. Do you think there are any usecases/edgecases I might be overlooking?