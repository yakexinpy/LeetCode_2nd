public class Solution {
    public int numTrees(int n) {
        if(n < 2) return n;
        int[] count = new int[n + 1];
        count[0] = 1;
        count[1] = 1;
        
        for(int root = 2; root <= n; root++){
            for(int j = 1; j <= root; j++)
                count[root] += count[j - 1] * count[root - j];
        }
        return count[n];
    }
}
