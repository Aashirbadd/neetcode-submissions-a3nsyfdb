class Solution {
    public int climbStairs(int n) {
        // So this code we are starting backwards
        // Saying if we started oneStep (on the solution)
        // And two step One behind, both would only have
        // 1 way to reach the top
        int top = 1, oneBehind = 1;

        for (int i = 0; i < n - 1; i++) {
            int temp = top;
            top += oneBehind;
            oneBehind = temp;
        }

        return top;
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