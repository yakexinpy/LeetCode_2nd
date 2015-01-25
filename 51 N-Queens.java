public class Solution {
    public List<String[]> solveNQueens(int n) {
        int[] col = new int[n];
        
        List<String[]> ret = new ArrayList<String[]>();
        helper(ret, col, 0, n);
        return ret;
    }
    
    private void helper(List<String[]> ret, int[] col, int cur, int n){
        if(cur == n){
            String[] res = new String[n];
            for(int i = 0; i < n; i++){
                String temp = "";
                for(int j = 0; j < n; j++){
                    if(j == col[i])
                        temp += "Q";
                    else
                        temp += ".";
                }
                res[i] = temp;
            }
            ret.add(res);
            return;
        }
        for(int i = 0; i < n; i++){
            col[cur] = i;
            if(isValid(col, cur))
                helper(ret, col, cur + 1, n);
        }
    }
    
    private boolean isValid(int[] col, int curN){
        for(int i = 0; i < curN; i++){
            if(col[i] == col[curN]) return false;
            if(Math.abs(col[curN] - col[i]) == curN - i) return false;
        }
        return true;
    }
}
