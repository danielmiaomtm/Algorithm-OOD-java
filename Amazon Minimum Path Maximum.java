/*
Maximum Minimum Path
给一个int[][]的matirx，对于一条从左上到右下的path p_i，p_i中的最小值是m_i，求所有m_i中的最大值。只能往下或右
比如：
[8, 4, 7]
[6, 5, 9]
有3条path：
8-4-7-9 min: 4
8-4-5-9 min: 4
8-6-5-9 min: 5
return: 5. 
*/

public int MaxMinPath (int[][] matrix) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return 0;
    }
    int min = Integer.MAX_VALUE;
    helper(matrix, min, 0, 0);
    return max;
}
public void helper (int[][] matrix, int min, int row, int col) {

    if (row >= matrix.length || col >= matrix[0].length) {
        return;
    }
    if (row == matrix.length - 1 && col == matrix[0].length - 1) {
        max = Math.max(min, max);
        return;
    }
    min = Math.min(matrix[row][col], min);
    helper(matrix, min, row + 1, col);
    helper(matrix, min, row, col + 1);

}
