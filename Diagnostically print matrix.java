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
