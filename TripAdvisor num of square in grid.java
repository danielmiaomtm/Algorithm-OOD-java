/*
num of square : 
dp[0][j] = j
dp[i][0] = j;
dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + Math.min(i, j);

num of rect:

F(i, j) = F(i - 1, j) + F(i, j - 1) - F(i - 1, j - 1) + i * j 

*/
