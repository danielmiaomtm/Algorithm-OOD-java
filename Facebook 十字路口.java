/*
题目：矩阵中由1构成的一横一竖的连续的1，并且这一横一竖有一个交叉点的， 是一条十字路
总的来说对每一个1：  和他在同一列上，与他相连的的连续的1的数量 + 和同他在同一行上，与他相连的连续的1的数量 的和  
就是以当前1为交叉点的十字路的长度
找出矩阵中最长的十字路。 

举几个例子吧

0 0 0
1 1 1
1 0 0   中最长的十字路长度是4

0 0 1 0 0 0
0 0 1 1 1 1
1 1 1 0 1 0
0 0 1 0 0 1
   中最长的十字路长度是7

*/

public class Solution {
    public int maxXing(int[][] nums) {
        if (nums.length == 0 || nums[0].length == 0)
            return 0;
        int rowHit = 0;
        int[] colHit = new int[nums[0].length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                if (nums[i][j] == 0) continue;
                // get rowHit
                if (j == 0 || nums[i][j - 1] == 0) {
                    rowHit = 0;
                    while (j + rowHit < nums[0].length && nums[i][j + rowHit] == 1)
                        rowHit ++;
                }
                // get colHit
                if (i == 0 || nums[i - 1][j] == 0) {
                    colHit[j] = 0;
                    while (i + colHit[j] < nums.length && nums[i + colHit[j]][j] == 1)
                        colHit[j] ++;
                }
                max = Integer.max(max, colHit[j] + rowHit - 1);
            }
        }
        return max;
    }
}
