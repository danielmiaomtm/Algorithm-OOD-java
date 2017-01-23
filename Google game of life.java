/*
(< 2)    1 -> 0   Any live cell with fewer than two live neighbors dies, as if caused by under-population. 
(2 || 3) 1 -> 1   Any live cell with two or three live neighbors lives on to the next generation. 
(> 3)    1 -> 0   Any live cell with more than three live neighbors dies, as if by over-population.. 
(3)      0 -> 1   Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction

0 : 上一轮是0，这一轮过后还是0
1 : 上一轮是1，这一轮过后还是1
2 : 上一轮是1，这一轮过后变为0
3 : 上一轮是0，这一轮过后变为1

*/


public void gameOfLife(int[][] board) {
    int m = board.length, n = board[0].length;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            int lives = 0;
            // 判断上边
            if(i > 0){
                lives += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1 : 0;
            }
            // 判断左边
            if(j > 0){
                lives += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1 : 0;
            }
            // 判断下边
            if(i < m - 1){
                lives += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1 : 0;
            }
            // 判断右边
            if(j < n - 1){
                lives += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1 : 0;
            }
            // 判断左上角
            if(i > 0 && j > 0){
                lives += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1 : 0;
            }
            //判断右下角
            if(i < m - 1 && j < n - 1){
                lives += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1 : 0;
            }
            // 判断右上角
            if(i > 0 && j < n - 1){
                lives += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1 : 0;
            }
            // 判断左下角
            if(i < m - 1 && j > 0){
                lives += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1 : 0;
            }
            // 根据周边存活数量更新当前点，结果是0和1的情况不用更新
            if(board[i][j] == 0 && lives == 3){
                board[i][j] = 3;
            } else if(board[i][j] == 1){
                if(lives != 2 && lives != 3) { 
                  board[i][j] = 2;
                }
            }
        }
    }
    // 解码
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            board[i][j] = board[i][j] % 2;
        }
    }
}
