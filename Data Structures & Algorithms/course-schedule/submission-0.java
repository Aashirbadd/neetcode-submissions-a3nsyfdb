class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Map onto adjacency list
        // If it is possible to finish every course 0 - n-1, ret true
        // If there is a cycle -> ret false (set)

        // 1. Fill out Adjacency List (index = course), (array = list of prerequisites)
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adjacencyList.add(new ArrayList<>());
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];

            adjacencyList.get(course).add(prereq);
        }

        // 2. For each course, see if it is possible to finish (0 - n-1)
        for (int i = 0; i < numCourses; i++) {
            HashSet<Integer> seen = new HashSet<>();    // For catching cycles

            // This will be a DFS helper function seeing if course i can be completed
            if (!canComplete(i, adjacencyList, seen))   return false;
        }

        // 3. Loop passing means all courses can be successfully completed
        return true;
    }

    private boolean canComplete(int i, List<List<Integer>> adjList, HashSet<Integer> seen) {
        // DFS Function
        // 1. Base Cases: 
            // False: Seen = Cycle = False, 
            // True: [] = no prereqs remaining = possible
        // Cycle
        if (seen.contains(i))           return false;
        // No more prereqs 
        if (adjList.get(i).isEmpty())   return true;

        // 2. Means we have prereqs to check if they are possible to complete:
        seen.add(i);
        List<Integer> prereqs = adjList.get(i);

        for (int prereq : prereqs) {
            // For every prereq, if we can't complete, ret false, else keep going!
            if (!canComplete(prereq, adjList, seen))    return false;
        }

        // Means all prereqs can be complete
        adjList.set(i, new ArrayList<>());  // Empty arrayList to eliminate redundant work
        seen.remove(i);
        return true;        // We can complete this course!
    }
}

// Input:   int[][] prerequisites = [a, b] ~ Means you must take course b before a (Unique)
//          int numCourses ~ Courses you're required to take (0 - numCourses - 1)

// Return: (boolean) If it is possible to finish all courses, else false.


// Test Cases:
// Input: numCourses = 2, prerequisites = [[0,1]]

// Output: true

// Prerequisites can be represented as a graph (adjacency list)
// 1 -> 0
// So it's possible to take 1, then 0 and take 2 courses

// Input: numCourses = 2, prerequisites = [[0,1],[1,0]]
//  0 <-> 1
// Output: false, since it's impossible to take 1 before 0 and 0 before 1.

// Any other test cases? Idk tbh

// Input: numCourses = 2, prerequisites = [[0,1],[1,3]]
    // 3 -> 1 -> 0
    // True
// Is numCourses always equal to prerequistes?
    // Yes you are required to take all courses
// Will the prerequisites be sorted?
    // No they will not be sorted.

// Okay essentially, what we want to do is to draw the course list into a graph and
// and if there is a path that we can complete, return true, 
// else if there is a loop, return false because it's impossible to complete

// One way to detect a cycle is with the turtose & hare algorithm, where we increment
// one by 2 and the other by 1, if it's possible to reach the end then we return else
// we ret false.

// But how do we ensure what to start with and what to end with?