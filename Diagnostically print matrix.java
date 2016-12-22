[1,2,3]
[4,5,6]
[7,8,9]
    
1 | 4 2 | 7 5 3 | 8 6 | 9    
    public void helper (int[][] nums) {
        int rowCount = nums.length;
        int columnCount = nums[0].length;
        int row, col;
        
        for (int k = 0; k < rowCount; k++) {
            List<Integer> list = new ArrayList<>();
            for (row = k, col = 0; row >= 0 && col < columnCount; row--, col++) {
                 list.add(nums[row][col]);
            }
            System.out.println(Arrays.toString(list.toArray()));
        }
        
        for (int k = 1; k < columnCount; k++) {
            List<Integer> list = new ArrayList<>();
            for (row = rowCount - 1, col = k; row >= 0 && col < columnCount; row--, col++ ) {
                list.add(nums[row][col]);
            }
            System.out.println(Arrays.toString(list.toArray()));
        }
        
    }
    
7 | 4 8 | 1 5 9 | 2 6 | 3

public void helper (int[][] nums) {
    int rowNum = nums.length;
    int colNum = nums[0].length;
    
    for (int i = row - 1; i >= 0; i--) {
        List<Integer> list = new ArrayList<>();
        for (int row = i && col = 0; row < rowNum && col < colNum; row--, col++) {
            list.add(nums[row][col]);
        }
    }
    for (int j = 1; j < colNum; j++) {
        List<Integer> list = new ArrayList<>();
        for (int row = 0, col = i; row < rowNum && col < colNum; row++, col++) {
            list.add(nums[row][col]);
        }
    }
}

/*zig zag print matrix
input:
a b c
d e f
g h i

output:
adbceghfi
*/
//Java
	//move down or move 
public List<Integer> printFlat (int[][] nums) {
	List<Integer> result = new ArrayList<>();
	//corner case, when there is empty matrix
	
	if (nums == null || nums.length == 0 || nums[0].length == 0) {
		return result;
	}
		
	int rowNum = nums.length;
        int colNum = nums[0].length;
        int row = 0;
        int col = 0;
        
        while (row < rowNum && col < colNum) {
        	
        	result.add(nums[row][col]);
        	//row not comes to bottom
        	if (row < rowNum - 1) {
        		row++;
        	} else if (col < colNum - 1) {
        		//comes to the bottom side
        		col++; 
        	} else { 	
        		break;
        	}
        	// print left bottom to up right
        	int x, y;
        	for (x = row, y = col; x > 0 && y < colNum - 1; x--, y++) {
        		result.add(nums[x][y]);
	        }
        	row = x++;
        	col = y--;
        	
        	result.add(nums[row][col]);
        	
        	//if in the left part, go to right
	        if(row == 0 && col < colNum - 1) {
	            col++;
	        } else {
	        //in the right part, row increase
	            row++;
        	}
	        
	        //print up right to bottom left
	        for (x = row, y = col; x < rowNum - 1 && y > 0; x++, y--) {
	        	result.add(nums[x][y]);
	        }
	        row = x--;
	        col = y++;
	        
	        
        }
        return result;

	}
