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
		    
		    for (int i = rowNum - 1; i >= 0; i--) {
		      int j = 0;
		      List<Integer> list = new ArrayList<>();
		      for (int x = i; j < colNum && x < rowNum; x++, j++) {
		    	 list.add(matrix[x][j]);
		      }
		      result.add(list);
		    }
		    
		    for (int j = 1; j < colNum; j++) {
		      int x = 0;
		      List<Integer> list = new ArrayList<>();
		      for (int y = j; x < rowNum && y < colNum; y++, x++) {
		    	  list.add(matrix[x][y]);
		      }
		      result.add(list);
		    }
		    return result;
		  }
