class Solution {
    private int indexToAdd = 0;
    private List<List<Integer>> adjList;
    private HashMap<Integer, Integer> seen;
    private int[] courseList;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Build out adjList first...
        // I'm going to build the ordering in reverse (course -> prereq) so we can return prereqs
        // in post order form, the adjList will have [prereq, course]...
        adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)        adjList.add(new ArrayList<Integer>());

        for (int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }

        courseList = new int[numCourses];
        seen = new HashMap<>();
        // Key = Processed - 0, CurrentlyProcessing/Cycle - 1...
        // AdjList is built, now do DFS with topsort...
        for (int i = 0; i < numCourses; i++) {
            if (containsCycle(i)) {
                return new int[0];
            }
        }

        return courseList;
    }

    // DFS post order traversal from course i to end of adjList
    // If there is no cycle, returns false, else true
    // Also fills out valid order in courseList...
    private boolean containsCycle(int i) {
        // BaseCase --> If we're already currently processing it ret true
        if (seen.containsKey(i) && seen.get(i) == 1) {
            return true;        // Means this is a cycle...
        } else if (seen.containsKey(i) && seen.get(i) == 0) {
            return false;       // Means we can already take this..
        }
        // Mark as 1 cuz were processing this right now...
        seen.put(i, 1);
        // Then see if we can visit all neighbors
        for (Integer neighbor : adjList.get(i)) {
            if (containsCycle(neighbor)) {
                return true;
            }
        }
        // This means all neighbors can be completed!
        seen.put(i, 0);
        courseList[indexToAdd++] = i;
        return false;
    }
}
