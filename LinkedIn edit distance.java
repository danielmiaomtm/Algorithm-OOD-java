/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
(each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character
Hide Tags
*/



public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        int[][] dp = new int[n + 1][m + 1];
        for(int i = 0; i <= m; i++){
            dp[0][i] = i; 
        }
        for(int i = 0; i <= n; i++){
            dp[i][0] = i;
        }
        
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1];
                }else{
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j],dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
