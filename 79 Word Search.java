public class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() < 1) return true;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++)
                if(helper(board, word, i, j, 0))
                    return true;
        }
        return false;
    }
    
    private boolean helper(char[][] board, String word, int row, int col, int pos){
        if(pos >= word.length()) return true;
        if(row < 0 || row >= board.length || col < 0 || col >= board[0].length)
            return false;
        
        if(board[row][col] == word.charAt(pos)){
            board[row][col] = '#';
            boolean res = helper(board, word, row - 1, col, pos + 1);
            res = res || helper(board, word, row + 1, col, pos + 1);
            res = res || helper(board, word, row, col - 1, pos + 1);
            res = res || helper(board, word, row, col + 1, pos + 1);
            
            board[row][col] = word.charAt(pos);
            return res;
        }
        return false;
    }
}
