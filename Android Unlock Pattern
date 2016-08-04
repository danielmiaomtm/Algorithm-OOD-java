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
