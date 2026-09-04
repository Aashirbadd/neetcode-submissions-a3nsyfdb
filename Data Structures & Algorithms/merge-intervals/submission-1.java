class Solution {
    // Constants
    int START = 0;
    int END = 1;

    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[START] == b[START]) {
                return Integer.compare(b[END], a[END]);
            } else {
                return Integer.compare(a[START], b[START]);
            }
        });  // Sort by start time in ascending order.
        
        int[] prev = intervals[0];
        
        List<int[]> output = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            // System.out.printf("Curr: %d %d, Prev: %d %d\n", curr[0], curr[1], prev[0], prev[1]);

            if (prev[END] >= curr[START]) {
                prev[END] = Math.max(prev[END], curr[END]);
            } 
            else 
            {
                output.add(prev.clone());
                prev = curr;
            }
        }

        output.add(prev.clone());

        return output.toArray(new int[0][]);
    }
}

// Understand question:

// intervals[i] = startI, endI --> Merge all overlapping intervals...
// Return the list of non overlapping intervals in any order...

// Intervals are non overlapping if they have no common point...
// Ex 1,2 and 3,4 are non overlapping

// But 1,2 2,3 are overlapping....

// Basically if Prev(End) <= Curr(Start) -> Merge them

// Input: intervals = [[1,3],[1,5],[6,7]]. Output: [[1,5],[6,7]]
//                           prev   curr

// if Prev(End) <= Curr(Start) -> Merge them
// (3 <= 1) -> Yes! Merge [1,5] (now that's prev)
// (5 <= 6) -> NO! Push [1,5 onto output], 
// Prev is now [6,7] and has no more elements to compare to, Push onto output.
// We will return [[1,5], [6,7]]