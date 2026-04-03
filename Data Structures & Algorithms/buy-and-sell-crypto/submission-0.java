class Solution {
    public int maxProfit(int[] prices) {
        int buy = 0;
        int sell = 1;
        int maxProfit = 0;

        while (sell < prices.length){
            int currentProfit = prices[sell] - prices[buy];
            maxProfit = Math.max(maxProfit, currentProfit);

            if (prices[sell] < prices[buy]){
                buy = sell;
            }
            sell += 1;
        }

        return maxProfit;
    }
}

// Input: int[] prices, prices[i] = Stock price on i'th day

// Pick one buy date, and one sell date.
// Return the max profit which you can achieve.
// You can choose not to make any transactions, in which case your profit == 0

// Indices:         0  1 2 3 4 5
// Input: prices = [10,1,5,6,7,1]
// buy                 ^
// sell                        ^
// Profit = prices[sell] - prices[buy] = 6
// Optimise for high sell price, low buy price
// Output: 6