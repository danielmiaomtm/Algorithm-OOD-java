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

int max = Integer.MIN_VALUE;
int rowNum;
int colNum;
public maxMinPath helper(int[][] matrix){
	rowNum = matrix.length;
	colNum = matrix[0].length;
	int min = Integer.MAX_VALUE;
	helper(matrix, min, 0, 0);
	return min;
}
public void helper (int[][] matrix, int min, int row, int col) {
	if (row >= rowNum || col >= colNum) {
		return;
	}
	if (rowNum - 1 == row && colNum - 1 == col) {
		min = Math.min(min, matrix[row][col]);
		max = Math.max(max, min);
		return;
	}
	min = Math.min(min, matrix[i][j]);
	helepr(matrix, min, row + 1, col);
	helper(matrix, min ,row, col + 1);
}
