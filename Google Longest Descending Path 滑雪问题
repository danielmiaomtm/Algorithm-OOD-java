给出一个矩阵，求矩阵中从某个点开始，最长的下降路径。路径可以走上下左右四个方向。求最长路径的长度。
1 2 3 4 
5 6 7 8 
其中一条最长路径是8 7 6 5 1

时间 O(N) 空间 O(1)


public class Ski {
    // 一个全局矩阵记录每个点能开始的最长路径
    int[][] dp;
    
    public int getLongestPath(int[][] matrix){
        dp = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                // 对每个点开始深度优先搜索
                dp[i][j] = dfs(i, j, matrix);
                // 看是否有必要更新全局最大长度
                if(dp[i][j] > max){
                    max = dp[i][j];
                }
            }
        }
        return max;
    }
    
    public int dfs(int i, int j, int[][] m){
        // 如果已经计算过，则直接返回
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int length = 1;
        // 递归上下左右
        if(i > 0 && m[i - 1][j] < m[i][j]){
            length = Math.max(dfs(i - 1, j, m) + 1, length);
        }
        if(j > 0 && m[i][j - 1] < m[i][j]){
            length = Math.max(dfs(i, j - 1, m) + 1, length);
        }
        if(i < m.length - 1 && m[i + 1][j] < m[i][j]){
            length = Math.max(dfs(i + 1, j, m) + 1, length);
        }
        if(j < m[0].length - 1 && m[i][j + 1] < m[i][j]){
            length = Math.max(dfs(i, j + 1, m) + 1, length);
        }
        dp[i][j] = length;
        return length;
    }
}
