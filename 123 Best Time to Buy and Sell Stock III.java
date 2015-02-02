public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        int[] prof = new int[prices.length + 1];
        prof[prices.length] = 0;
        int max = 0;
        for(int i = prices.length - 1; i >= 0; i--){
            max = Math.max(max, prices[i]);
            prof[i] = Math.max(prof[i + 1], max - prices[i]);
        }
        
        int min = max;
        int maxProf = 0;
        for(int i = 0; i < prices.length; i++){
            min = Math.min(min, prices[i]);
            maxProf = Math.max(maxProf, prices[i] - min + prof[i + 1]);
        }
        
        return maxProf;
    }
}
