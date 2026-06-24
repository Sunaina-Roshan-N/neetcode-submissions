class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int buyIndex = 0;
        int sellIndex = 1;
        while(sellIndex < prices.length) {
            if(prices[sellIndex] > prices[buyIndex]) 
                profit += prices[sellIndex] - prices[buyIndex];
            
            buyIndex = sellIndex++;
        }
        return profit;
    }
}