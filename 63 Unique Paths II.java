public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] steps = new int[row][col];
        
        for(int i = 0; i < row; i++){
            if(obstacleGrid[i][0] == 1) break;
            steps[i][0] = 1;
        }
        for(int j = 0; j < col; j++){
            if(obstacleGrid[0][j] == 1) break;
            steps[0][j] = 1;
        }
        
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(obstacleGrid[i][j] == 1)
                    steps[i][j] = 0;
                else
                    steps[i][j] = steps[i][j - 1] + steps[i - 1][j];
            }
        }
        return steps[row - 1][col - 1]; 
    }
}
