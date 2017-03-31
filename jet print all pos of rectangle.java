//如果原数组不能被改变	
public List<List<Integer>> triPos (int[][] matrix) {
	    
		List<List<Integer>> result = new ArrayList<>();
		Set<Integer> visited = new HashSet<>();  
	    int rowNum = matrix.length, colNum = matrix[0].length;
	    
	    for (int i = 0; i < rowNum; i++) {
	      for (int j = 0; j < colNum; j++) {
	    	  
	        if (!visited.contains(i * colNum + j) && matrix[i][j] == 0) {
	          List<Integer> list = new ArrayList<>();
	          helper(matrix, list, i, j, rowNum, colNum, visited);
	          result.add(new ArrayList<>(list));
	        }
	      }
	    }
	  	  
	  return result;
	}


public void helper (int[][] matrix, List<Integer> list, int i, int j, int rowNum, int colNum, Set<Integer> visited) {
	   
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
    
    list.add(i);
    list.add(j);
    list.add(width);
    list.add(height);
    
    //update the triangle area from 0 to 1
    for (row = 0; row < height; row++) {
    	for (col = 0; col < width; col++) {
    		visited.add((row + i) * colNum + (j + col));;
    	}
    }
    
}
