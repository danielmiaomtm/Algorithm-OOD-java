/*
平面蜂窝结构，每一个cell是正六边形，每个cell都有六个相邻的cells。
整个蜂窝的高和宽 （cell数）是可以任意输入的，注意相邻的列都是上下错开的。设计class ＋ function，
给定高和宽，再给定一个数字，顺时针打印出与数字对应的cell相邻的六个cell里面的数字。比如图例，在高和宽input 为 3和6，
输入index为4的情况，按顺序打印出3，7，8，5，2，1.  如果赶上边缘上的cell（没有6个相邻的cells），空缺的位置要打印“－1”.
数据结构自己设计，数据自己初始化，就连运行test那两行代码也要自己写。总之所有东西都是自己写。

__     __     __      __   
/0 \__/6 \_/12\__/   \__
\__/3 \_/9 \__/15\__/  
/1  \_/7\__/13\__/   \__
\__/4 \_/10\__/16\__/  
/2 \__/8 \__/14\__/  \__
\__/5 \__/11\__/17\__/  
/   \_ /    \__/    \__/  \__
*/


public class practise {
	
	
	public static int[][] matrix;
	public static int width;
	public static int height;
	
	
	public practise(int width, int height) {
		this.matrix = new int[height][width];
		this.width = width;
		this.height = height;
		int index = 0;
		for (int col = 0; col < width; col++) {
			for (int row = 0; row < height; row++) {
				matrix[row][col] = index++;
			}
		}
		
		
	}

	public static List<Integer> getNeighbor (int index) {
		int total = width * height;
		List<Integer> result = new ArrayList<>();
		
    if (index >= width * height) {
			return result;
		}
    
		int col = index / height;
		int row = index % height;
		
		if (col % 2 == 1) {
			int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
			for (int[] dir : directions) {
				int x = row + dir[0];
				int y = col + dir[1];
				if (x < 0 || x >= height || y < 0 || y >= width) {
					result.add(-1);
				} else {
					result.add(matrix[x][y]);
				}
			}
		} else {
			int[][] directions = new int[][]{{-1, 0}, {-1, 1}, {0, 1}, {1, 0}, {0, -1}, {-1, -1}};
			for (int[] dir : directions) {
				int x = row + dir[0];
				int y = col + dir[1];
				if (x < 0 || x >= height || y < 0 || y >= width) {
					result.add(-1);
				} else {
					result.add(matrix[x][y]);
				}
			}
		}
		
		return result;
	}



//test
	public static void main (String[] args) {
		practise sol = new practise(5, 3);
		for (int[] m : matrix) {
			System.out.println(Arrays.toString(m));
		}
		
		List<Integer> list = getNeighbor(6);
		
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	
}
