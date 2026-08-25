class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        // Return the number of car fleets...
        // Input: target = 10, position = [1,4], speed = [3,2]
        // Output: 1

        // Pair position and time to reach target together, so we can sort and analyse...
        double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));
        // ascending order by default...
        double leaderTime = cars[position.length - 1][1];
        int fleets = 1;
        // You need to do it in reverse because the latest car is the one that has
        // The most preference... Meaning that that the latest speed is the biggest...
        for (int i = position.length - 2; i >= 0; i--) {
            // [5, 2.6, 6]
            double currTime = cars[i][1];
            if (currTime > leaderTime) {
                leaderTime = currTime;
                fleets += 1;
            }
        }
        // // Sort via position -> [10, 4.5, 3, 3] -> 3
        //                          

        return fleets;
    }
}

// There are n cars travelling to the same dest on a 1 lane highway...


// Input: target = 10, position = [4,1,0,7], speed = [2,2,1,1], output = 3
// timeToReachTarget = [10-4=6/2===3, 9/2=4.5, 10, 3]
// Sort via position -> [10, 4.5, 3, 3] -> 3