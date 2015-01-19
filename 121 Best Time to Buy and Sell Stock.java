public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 1) return 0;
        
        int[] low = new int[prices.length];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            low[i] = min;
        }
        
        int[] high = new int[prices.length];
        int max = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--){
            max = Math.max(max, prices[i]);
            high[i] = max;
        }
        
        int prof = Integer.MIN_VALUE;
        for(int i = prices.length - 1; i >= 0; i--){
            prof = Math.max(prof, high[i] - low[i]);
        }
        return prof;
    }
}
