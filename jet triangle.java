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
  
	  
	  public List<Node> triPos (int[][] matrix) {
		    
		    List<Node> result = new ArrayList<>();
		    int rowNum = matrix.length, colNum = matrix[0].length;
		    boolean[][] visited = new boolean[rowNum][colNum];
		    
		    for (int i = 0; i < rowNum; i++) {
		      for (int j = 0; j < colNum; j++) {
		        if (!visited[i][j] && matrix[i][j] == 0) {

		          Node node = helper(matrix, i, j, rowNum, colNum);
		          result.add(node);
		          
		          for (int a = node.top; a < node.top + node.height; a++) {
		        	  for (int b = node.left; b < node.left + node.width; b++) {
		        		  visited[a][b] = true;
		        	  }
		          }
		          
		        }
		        
		      }
		    }
		  
		  
		  return result;
		} 
	  
	  
	  
	//只有一个矩阵的话，可以用binary search，因为是连续的，但是如果是多个的话，只能两边走  
	public Node helper (int[][] matrix, int row, int col, int rowNum, int colNum) {
	   
	    // go to right, find width
		
		int width = binarySearch(matrix, row, col, true);		
		int height = binarySearch(matrix, row, col, false);

		return new Node(row, col, width - col + 1, height - row + 1);
	    
	    
	}
	//binary search找到边界位置
	public int binarySearch (int[][] matrix, int row, int col, boolean findWidth) {
		int left = findWidth ? col : row;
		int right = findWidth ? matrix[0].length - 1 : matrix.length - 1; 
		while (left <= right) {
			int mid = left + (right - left) / 2;
			
			if (findWidth ? matrix[row][mid] == 0 : matrix[mid][col] == 0) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}						
		}
		
		return right;
	}


}
