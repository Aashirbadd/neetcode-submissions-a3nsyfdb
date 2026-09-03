/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return true;
        }
        // Sort by starttime
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval curr = intervals.get(i);
            Interval next = intervals.get(i+1);

            if (curr.end > next.start) {
                return false;
            }
        }
        // Means the entire array has no conflicts

        return true;
    }
}

// Given an array of meeting time interval objects with start and end times [start1, end1], [start2, end2] ...[sn, en]
// Sorted by start times and end times... Determine if someone can hit all meetings without conflicts...
// (0,8)(8,0) is not considered a conflict --> if (end[n-1] < start[n]) then conflict!

// Input: intervals = [(0,30),(5,10),(15,20)]
// Output: false
// if (end[n-1] > start[n]) then conflict! -> 30 > 5 ? yeah -> Ret false!

// Input: intervals = [(5,8),(9,15)]
// if (end[n-1] > start[n]) then conflict! -> 8 > 9? no -> Ret true!