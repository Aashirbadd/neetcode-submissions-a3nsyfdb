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
    public int minMeetingRooms(List<Interval> intervals) {
        // Find the number of rooms that are required to schedule all meetings without any conflicts.
        int roomsNeeded = 1;

        if (intervals.size() <= 1)      return intervals.size();
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));   // ascending order by start time

        // PQ with the minimum end time at the tip...
        PriorityQueue<Interval> q = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        // a comes before b if a is less than b... Least value in the tip....
        q.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {
            Interval prev = q.peek();
            Interval curr = intervals.get(i);

            if (prev.end > curr.start) {
                q.add(curr);
                roomsNeeded = Math.max(roomsNeeded, q.size());
            } else {
                while (!q.isEmpty() && q.peek().end <= curr.start) {
                    q.poll();
                }
                q.add(curr);
            }
        }

        return roomsNeeded;
    }
}
// Input: intervals = [(0,40),(5,10),(15,20)]   Output: 2

// First and foremost thing is to sort by start time...
// Then, if prev.end > curr.start --> means there is a conflict and we need an extra room

// if (prev.end > curr.start) rooms += 1
//  40 > 5 ? rooms = 1, 10 > 15? no rooms = 1
// Rooms is initialized to 1...
// 1 is the base case
