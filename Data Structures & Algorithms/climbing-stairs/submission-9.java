class Solution {
    public int climbStairs(int n) {
        int oneStep = 1, twoStep = 1;

        for (int i = 0; i < n; i++) {
            int temp = oneStep;
            oneStep = oneStep + twoStep;
            twoStep = temp;
        }

        return twoStep;
    }
}

// Given an integer n, you can climb either 1 or 2 steps at a time...
// Return the number of distinct ways you can reach the top of then staircase...
// 2 = 2
//      0
//    1   (2)
//  (2)

//      n = 3

//              0
//          1       2
//        (2)   (3)   (3)

// How do you do it? Idk...