class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // First let's make it into a adjacencyList...
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)    adjList.add(new ArrayList<Integer>());

        for (int[] prereq : prerequisites) {
            adjList.get(prereq[0]).add(prereq[1]);
        }

        HashSet<Integer> seen = new HashSet<>();
        // So you created the AdjList, now what? Start from each course to see if it can be completed...
        for (int i = 0; i < numCourses; i++) {
            if (containsCycle(i, adjList, seen)) {
                return false;
            }
        }

        // No cycles mean all courses can be completed!
        return true;
    }

    // Traverses from start of the node to all neighbors with DFS...
    private boolean containsCycle(int i, List<List<Integer>> adjList, HashSet<Integer> seen) {
        // DFS baseCase
        if (seen.contains(i)) {
            return true;
        }

        seen.add(i);
        for (Integer neighbor : adjList.get(i)) {
            if (containsCycle(neighbor, adjList, seen)) {
                return true;
            }
        }

        // Means this course can be completely traversed
        adjList.set(i, new ArrayList<Integer>());
        seen.remove(i);

        return false;
    }
}

// numCourses = 4, prerequisites = [[0,1],[1,2],[2,1],[3,0]]
// Expected Output: false

// 3 -> 0 -> 1 <-> 2 
// Basically this is a cycle...