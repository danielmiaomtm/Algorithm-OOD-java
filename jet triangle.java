class Solution {
  public static void main(String[] args) {
    Solution sol = new Solution();
    int[][] matrix = new int[][]{{1,1,1,1,1,1}, 
                                 {1,0,0,0,1,1}, 
                                 {1,0,0,0,1,1}, 
                                 {1,1,1,1,1,1}, 
                                 {1,1,1,1,1,1} 
                                };

    List<Integer> result = sol.triPos(matrix);
    for (int pos : result) {
      System.out.println(pos);
    }
  }
  
  public List<Integer> triPos (int[][] matrix) {
    
    List<Integer> result = new ArrayList<>();
    int rowNum = matrix.length, colNum = matrix[0].length;
    
    for (int i = 0; i < rowNum; i++) {
      for (int j = 0; j < colNum; j++) {
        if (matrix[i][j] == 0) {
          result.add(i);
          result.add(j);
          helper(matrix, result, i, j, rowNum, colNum);
          return result;
        }
      }
    }
  
  
  return result;
}

public void helper (int[][] matrix, List<Integer> result, int i, int j, int rowNum, int colNum) {
   
    // go to right, find width
    int width = 0;
    int row = i, col = j;
    while (col < colNum && matrix[i][col] == 0) {
      width++; 
      col++;
    }
    // go to bottom, find height  
    int height = 0;
    while (row < rowNum && matrix[row][j] == 0) {
      height++;
      row++;
    }
    
    result.add(width);
    result.add(height);
    return;
}


}
