class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int toRemove = 0;
       

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            
            int[] curr = intervals[i];
            // intervals=[[0,2],[1,3],[2,4],[3,5],[4,6]]
            //              p
            //                   c
            // System.out.printf("curr: %d %d, prev: %d %d \n", curr[0], curr[1], prev[0], prev[1]);
            
            if (prev[1] > curr[0]) {
                if (curr[1] < prev[1]) {
                    prev = curr;
                }
                toRemove += 1;
            } else {
                if (curr[1] > prev[1]) {
                    prev = curr;
                }
            }
        }

        return toRemove;
    }
}

// Intervals are overlapping only if they have values within one another
// Intervals with a common point: 2,3 3,4 are NOT overlapping...

// Input: intervals = [[1,2],[2,4],[1,4]]
// Sort -> [[1,2], [1,4], [2, 4]]
//           prev   curr

// Overlap = if (prev[END] <= curr[START])
//              -> prev = (the one with the lesser end value since that has less chance of overlapping)
//              toRemove += 1
//              i += 1
// toRemove = 1

// If you remove a interval, you'd remove the one with a higher end point... and increment by 1...