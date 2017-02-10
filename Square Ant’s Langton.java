/*

*/


public class Main {

    //当前位置
    private static int x;
    private static int y;

    private static int[][] a = new int[100][100];

    //当前方向
    private static int direction = 0;

    public static void main(String[] args) {

        int[][] board = new int[][]{{1,0,0},
				    {0,0,0}, 
				    {1,1,1},
				    {0,0,0}};  
		 
		 sol.move(1, 1, 2, board, 5);      
	     for (int[] b : board) {
	    	 System.out.println(Arrays.toString(b));
	     }

    }


  // 移动的方法
	// up(0), left(1), down(2), right(3)
    int[][] dir = new int[][]{{-1, 0},{0,-1},{1,0},{0,1}};
    
    public void move(int row, int col, int dire, int[][] board, int step) throws Exception {
    	while (step > 0) {
    		if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
    			return;
    		}
    		System.out.println("row " + row);
    		System.out.println("col " + col);
    		 //如果是白的，则右转    		
            if(board[row][col] == 0) {
            	dire = ((dire - 1) + 4) % 4;
                board[row][col] = 1;
            } else {
              //如果是黑的则左转
            	dire = (dire + 1) % 4;
                board[row][col] = 0;
            }
            row += dir[dire][0];
            col += dir[dire][1];
            System.out.println("newRow " + row);
    		System.out.println("newCol " + col);
            step--;
    	}
        
    }
}
