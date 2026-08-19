class Solution {
    public int maxProfit(int[] prices) {
        // Input: prices = [10,1,5,6,7,1]
        //                  b  s
        // Buy low, sell high

        // Max profit (combo of min buy and max sell or MAX(sell - buy))
        // Output: 6
        int b = 0, maxProfit = 0;

        for (int s = 0; s < prices.length; s++) {
            int currProfit = prices[s] - prices[b];
            maxProfit = Math.max(currProfit, maxProfit);
            if (prices[s] < prices[b]) {
                b = s;
            } 
        }

        return maxProfit;
    }
}
