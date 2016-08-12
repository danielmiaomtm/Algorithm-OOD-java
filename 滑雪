 public int[][] dp;
    
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
