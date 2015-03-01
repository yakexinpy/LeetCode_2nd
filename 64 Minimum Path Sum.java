public class Solution {
    public int minPathSum(int[][] grid) {
        int[] sum = new int[grid[0].length];
        for(int i = 0; i < sum.length; i++){
            if(i == 0)
                sum[i] = grid[0][i];
            else
                sum[i] = sum[i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(j == 0)
                    sum[j] = sum[j] + grid[i][j];
                else
                    sum[j] = Math.min(sum[j], sum[j - 1]) + grid[i][j];
            }
        }
        
        return sum[sum.length - 1];
    }
}
