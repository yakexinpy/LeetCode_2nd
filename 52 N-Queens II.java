public class Solution {
    public int totalNQueens(int n) {
        if(n < 1) return 0;
        int[] col = new int[n];
        int total = helper(0, col, 0, n);
        return total;
    }
    
    private int helper(int total, int[] col, int cur, int n){
        if(n == cur){
            total += 1;
            return total;
        }
        
        for(int i = 0; i < n; i++){
            col[cur] = i;
            if(isValid(col, cur))
                total = helper(total, col, cur + 1, n);
        }
        return total;
    }
    
    private boolean isValid(int[] col, int cur){
        for(int i = 0; i < cur; i++){
            if(col[i] == col[cur]) return false;
            if(Math.abs(col[cur] - col[i]) == cur - i) return false;
        }
        return true;
    }
}
