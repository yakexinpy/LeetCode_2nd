public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        if(target < matrix[0][0] || target > matrix[row - 1][col - 1])
            return false;
            
        int l = 0, r = row * col - 1;
        int mid = r / 2;
        
        while(l <= r){
            int i = (mid / col) % row;
            int j = mid % col;
            if(matrix[i][j] == target) return true;
            if(matrix[i][j] < target)
                l = mid + 1;
            else
                r = mid - 1;
            mid = (r + l) / 2;
        }
        return false;
    }
}
