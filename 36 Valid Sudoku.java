public class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        
        for(int i = 0; i < board.length; i++){
            set.clear();
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        
        for(int j = 0; j < board[0].length; j++){
            set.clear();
            for(int i = 0; i < board.length; i++){
                if(board[i][j] == '.') continue;
                if(set.contains(board[i][j])) return false;
                set.add(board[i][j]);
            }
        }
        
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                set.clear();
                for(int r = i * 3; r < i * 3 + 3; r++){
                    for(int c = j * 3; c < j * 3 + 3; c++){
                        if(board[r][c] == '.') continue;
                        if(set.contains(board[r][c])) return false;
                        set.add(board[r][c]);
                    }
                }
            }
        }
        
        return true;
    }
}
