/*
There are n coins in a line. (Assume n is even). 
Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
The player with the larger amount of money wins.
Would you rather go first or second? Does it matter?
Assume that you go first, describe an algorithm to compute the maximum amount of money you can win.

*/              

int coins(int[] A) {
        int n=A.length;
        int[][] sum=new int[n][n];
        int[][] dp=new int[n][n];
 
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++)
                sum[i][j]=A[j]+(i==j?0:sum[i][j-1]);
 
        for(int i=n-1;i>=0;i--)
            for(int j=i;j<n;j++) {
                if(i==j)
                    dp[i][j]=A[i];
                else
                    dp[i][j]=sum[i][j]-Math.min(dp[i+1][j], dp[i][j-1]);
            }
        return dp[0][n-1];
    }
