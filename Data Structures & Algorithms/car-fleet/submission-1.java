class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        float[][] finishTime = new float[position.length][2];
        for (int i = 0; i < position.length; i++) {
            finishTime[i][0] = (float) (target - position[i])/speed[i];
            finishTime[i][1] = position[i];
        }

        // Sort via position first, finishTime second
        Arrays.sort(finishTime, (a,b) -> {
            return -1 * Float.compare(a[1],b[1]);
            // Positive if b > a, so descending order
        });

        // target=10
        // position=[6,8]
        // speed=   [3,2]
        // arrivalT=[1:8,1.3:6]

        int fleets = 0;
        float leaderArrivalTime = 0;    // Slowest
        for (int i = 0; i < position.length; i++) {
            float arrivalTime = finishTime[i][0];
            if (arrivalTime > leaderArrivalTime) {
                fleets += 1;
                leaderArrivalTime = arrivalTime;
            }
        }

        return fleets;
    }
}

// Input: int[n] position, int[n] speed, int target (destination)
// Car can NOT pass another car ahead, but only drive the same speed of a car already ahead
// Car fleet is the non-empty set of cars driving at the same position & speed.
// Single car is also a car fleet. (Base case) --> Condition
// If a car catches up to a car fleet the moment the fleet reaches the destination
// the car is considered to be a part of the fleet.

//                                 0 1 2
// Input: target = 10, position = [2,1,4], speed = [6,3,2]
// (Float) (norm) TimetoReachFinish = [1.3:0,3:1,3:2]
// (Float) (sort) TimetoReachFinish = [3:2,1.3:0,3:1]

// (Podium) CurrFleet (if arrTime > currFleetArrival)
// Sort them. Position beats speed, then it would be ttrFinish
// So for each that finishes slower && is at a lesser position, then add them part of diff fleet

// Fleet = [3h[0,1,2]]
// for num in timeToReachFin:
    // For every high position
    // Every car that finishes before them or equal, then 
// Time to reach dest.
// (target-position)/speed
// 0 (8/6) = 2h
// 1 (9/3) = 3h
// 2 (6/2) = 3h
// Output: 1
// But here the edge case is not really shown.