class Solution {
    private int START = 0;
    private int END = 1;

    public int[][] insert(int[][] intervals, int[] newInterval) {
        // intervals=[[1,3],[4,6]]      newInterval=[2,5]
        //             ^
        //                                             ^

        // 
        List<int[]> output = new ArrayList<>();
        int i = 0;
        boolean merged = false;
        while (i < intervals.length) {
            int[] curr = intervals[i];
            // System.out.printf("NewInterval: %d %d, Curr: %d %d\n", newInterval[0], newInterval[1], curr[0], curr[1]);
            if (newInterval[END] < curr[START]) {
                // System.out.println("ONE");
                output.add(newInterval);
                merged = true;
                break;
            } else if (curr[END] >= newInterval[START]) {
                // System.out.printf("MERGE\n");
                newInterval[START] = Math.min(newInterval[START], curr[START]);
                newInterval[END] = Math.max(newInterval[END], curr[END]);
            } else {
                // We are completely before newInterval
                // System.out.println("3!");
                output.add(curr);
            }
            // Any other conditions where you add the newInterval? If it's in the end
            i+= 1;
        }

        while (i < intervals.length) {
            output.add(intervals[i]);
            
            i += 1;
        }
        if (!merged) {
            output.add(newInterval);
        }

        return output.toArray(new int[0][]);
    }
}
