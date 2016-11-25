/*
There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until there are no more coins left. 
The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.
*/

public boolean firstWillWin(int[] values) {
    // write your code here
    // dp 表示从i到end 的最大值
    // int values[] ={1,2,4,3,4,8,5,6,12};
    int len = values.length;
    // 长度小于2的时候第一个人一定获胜
    if(len <= 2)
        return true;
    int dp[] = new int[len+1];
    dp[len] = 0;
    dp[len-1] = values[len-1];
    dp[len-2] = values[len-1] + values[len - 2];
    dp[len - 3] = values[len-3] + values[len - 2];
    for(int i = len - 4; i >= 0; i--){
        dp[i] = values[i] + Math.min(dp[i+2],dp[i+3]);
        dp[i] = Math.max(dp[i],values[i]+values[i+1]+ Math.min(dp[i+3],dp[i+4]));

    }
    int sum = 0;
    for(int a:values)
        sum +=a;
    return dp[0] > sum - dp[0];
}
