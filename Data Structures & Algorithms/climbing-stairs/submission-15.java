class Solution {
    public int climbStairs(int n) {
    if (n <= 2) return n;

    int twoBack = 1;  // ways to reach step 1
    int oneBack = 2;  // ways to reach step 2

    for (int i = 3; i <= n; i++) {
        int current = oneBack + twoBack;  // this step's answer
        twoBack = oneBack;                // slide the window forward
        oneBack = current;
    }

    return oneBack;
}
}
