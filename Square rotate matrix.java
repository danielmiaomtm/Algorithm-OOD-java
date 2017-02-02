
/*
  顺时钟 90
  按照对角线，上下swap，然后按照对角线对称swap
  1 2 3     7 8 9          7 4 1
  4 5 6     4 5 6          8 5 2
  7 8 9     1 2 3          9 6 3
  
*/



public void rotate(int[][] matrix) {
    //上下交换
    for (int i = 0; i < matrix.length / 2; i++) {
        int up = i;
        int bottom = matrix.length - 1 - i;
        for (int j = 0; j < matrix[0].length; j++) {
            int temp = matrix[up][j];
            matrix[up][j] = matrix[bottom][j];
            matrix[bottom][j] = temp;
        }
    }
    //按照斜对角线走 交换
    for (int i = 0; i < matrix.length; i++) {
        for (int j = i; j < matrix[0].length; j++) {
            int temp = matrix[i][j];
            matrix[i][j] = matrix[j][i];
            matrix[j][i] = temp;
        }
    }

}
