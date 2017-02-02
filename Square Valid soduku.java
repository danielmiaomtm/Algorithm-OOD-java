public class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        
        for (int i = 0; i <= 8; i++) {
            if (!isValid(board, i, i, 0, 8)) {
                return false;
            }
            if (!isValid(board, 0, 8, i, i)) {
                return false;
            }
        }    
    
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isValid(board, i * 3, i * 3 + 2, j * 3, j * 3 + 2)) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isValid(char[][] board, int x1, int x2, int y1, int y2) {
        Set<Character> set = new HashSet();
        
        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                if (board[i][j] != '.' && !set.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    
    
}



