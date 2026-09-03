class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1]; // Stores the min # to get each amount
        for (int i = 0; i < amount + 1; i++)    dp[i] = amount + 1;
        // Initialise each dp element with max value...
        dp[0] = 0;      // Base Case: No coins are needed to provide an amount of 0

        for (int i = 1; i < amount + 1; i++) {
            // Calculate each amount starting from 1...
            for (int coin : coins) {
                if (coin <= i) {
                    // If we can even get a valid ans with curr coin denomination
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        return dp[amount] < amount + 1 ? dp[amount] : -1;
    }
}

// Given an integer array coins and integer amount which is a target amount of money, return the fewest amount of couns that add up to amount...

// So if you have: coins = [1,5,10], amount = 12

// And you choose to take coins[i], that's 1 + coinChange(coins, amount - coins[i])
// Or it's gonna be not take coins of i...

// That's the broad recurrance relation...