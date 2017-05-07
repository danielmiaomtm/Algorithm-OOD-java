/*

Print an NxM matrix with nw-se diagonals starting at bottom left corner. Ex:


1  2  3  4
5  6  7  8
9 10 11 12
The output should be:


9
5 10
1 6 11
2 7 12
3 8
4
*/	 
   
   
 public List<List<Integer>> print (int[][] matrix) {
    List<List<Integer>> result = new ArrayList<>();
    int rowNum = matrix.length;
    int colNum = matrix[0].length;
	 
    int row = rowNum - 1, col = 0;
    for (int r = row; i >= 0; i--) {
      int c = col;
      List<Integer> list = new ArrayList<>();
      while (r < rowNum && c < colNum) {
	  list.add(matrix[r][c]);
	  r++;
	  c++;
      }
      result.add(list);
    }
    
    row = 0, col = 1;
    for (int c = col; c < colNum; c++) {
      int r = row;
      List<Integer> list = new ArrayList<>();
      while (r < rowNum && c < colNum) {
	  list.add(matrix[x][y]);
	  r++;
	  c++;
      }
      result.add(list);
    }
    return result;
 }
