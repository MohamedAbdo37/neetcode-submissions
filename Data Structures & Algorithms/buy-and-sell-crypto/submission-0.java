class Solution {
    public int maxProfit(int[] prices) {
        int maxValue = 0;
        int maxProfit = 0;
        for (int i = prices.length - 1; i > -1 ; i --) {
            maxValue = Math.max(maxValue, prices[i]);
            maxProfit = Math.max(maxProfit, maxValue - prices[i]);
        } 

        return maxProfit;
    }
}
