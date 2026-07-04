class Solution {
    public int maxProfit(int[] prices) {
        int buyIndex = 0;
        int sellIndex = 1;

        int maxProfit = 0;
        int currentProfit = 0;

        while(sellIndex < prices.length) {
            if(prices[sellIndex] > prices[buyIndex]) {
                currentProfit = prices[sellIndex++] - prices[buyIndex];
                if(currentProfit > maxProfit)
                    maxProfit = currentProfit;
            } else {
                buyIndex = sellIndex;
                sellIndex++;
            }
        }

        return maxProfit;
    }
}
