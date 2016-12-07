/*
Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns 
of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously 
selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.
*/
public class Solution {
    int result=0;
    public int numberOfPatterns(int m, int n) {
        int[][] matrix=new int[10][10];
        matrix[1][3] = matrix[3][1] = 2;
        matrix[4][6] = matrix[6][4] = 5;
        matrix[7][9] = matrix[9][7] = 8;
        matrix[1][7] = matrix[7][1] = 4;
        matrix[2][8] = matrix[8][2] = 5;
        matrix[3][9] = matrix[9][3] = 6;
        matrix[1][9] = matrix[9][1] = 5;
        matrix[3][7] = matrix[7][3] = 5;
        boolean[] visited=new boolean[10];
        helper(visited,m,n,0,0,matrix);
        return result;
        
    }
    
    private void helper(boolean[] visited,int m,int n,int begin,int count,int[][] matrix){
        if(count >= m) {
          result++;
        }
        if(count >= n) {
          return;
        }
        for(int i = 1; i <= 9; i++){
            if(visited[i] == true) {
              continue;
            }
            int crossnum = matrix[begin][i];
            if(crossnum != 0 && !visited[crossnum]) {
              continue;
            }
            visited[i] = true;
            helper(visited, m, n, i, count + 1, matrix);
            visited[i] = false;
        }
    }
    
    
}
