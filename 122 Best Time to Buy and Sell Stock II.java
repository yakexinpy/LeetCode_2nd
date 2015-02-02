public class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0;
        for(int i = 1; i < prices.length; i++){
            int df = prices[i] - prices[i - 1];
            if(df > 0)
                prof += df;
        }
        return prof;
    }
}
