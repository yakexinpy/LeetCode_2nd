public class Solution {
    public void solveSudoku(char[][] board) {
        List<Integer> pos = new ArrayList<Integer>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++)
                if(board[i][j] == '.')
                    pos.add(i * 9 + j);
        }
        
        helper(pos, board, 0);
    }
    
    private boolean helper(List<Integer> pos, char[][] board, int count){
        if(count == pos.size()) 
            return true;
        int p = pos.get(count);
        int row = p / 9;
        int col = p % 9;
        for(int v = 1; v <= 9; v++){
            if(isValid(board, p, v)){
                board[row][col] = (char)(v + '0');
                if(helper(pos, board, count + 1))
                    return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    
    private boolean isValid(char[][] board, int pos, int val){
        int row = pos / 9;
        int col = pos % 9;
        
        for(int i = 0; i < 9; i++){
            if(board[row][i] - '0' == val) return false;
            if(board[i][col] - '0' == val) return false;
            int r = (row / 3) * 3 + i / 3;
            int c = (col / 3) * 3 + i % 3;
            if(board[r][c] - '0' == val) return false;
        }
        return true;
    }
}
