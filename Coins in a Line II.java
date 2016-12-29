/*
There are n coins with different value in a line. 
Two players take turns to take one or two coins from left side until there are no more coins left. 
The player who take the coins with the most value wins.

Could you please decide the first player will win or lose?

Example
Given values array A = [1,2,2], return true.

Given A = [1,2,4], return false.
*/


/*
定义dp[i]表示从i到end能取到的最大值
当我们在i处，有两种选择：
1.若取values[i]，对方可以取values[i+1] 或者values[i+1] + values[i+2]
当对方取values[i+1] 后 ，我们只能从 i+2 到end内取，我们所取得最大值是dp[i+2],  注意：对方所选取的结果一定是使得我们以后选取的值最小
当对方取values[i+1] + values[i+2]后，我们只能从i+3到end内取，我们所取得最大值是dp[i+3]。
此时：dp[i] = values[i] + min(dp[i+2],dp[i+3]) , 注意：对方所选取的结果一定是使得我们以后选取的值最小

2.若取values[i] + values[i+1],对方可取values[i+2] 或者values[i+2] + values[i+3]
当对方取values[i+2]后，我们只能从i+3到end内取，我们取得最大值是dp[i+3]
当对方取values[i+2]+values[i+3]后，我们只能从i+4到end内去，我们取得最大值是dp[i+4]
此时：dp[i] = values[i] + values[i+1]+min(dp[i+3],dp[i+4])

这里的取最小值和上面一样的意思，对方选取过之后的值一定是使得我们选取的值最小，对方不傻并且还很聪明
最后我们可以取上面两个dp[i]的最大值，就是答案，这里意思是：对方留得差的方案中，我们选取的最大值。
*/


public boolean firstWillWin(int[] values) {
        // write your code here
        int len = values.length;
        if (len <= 2) {
            return true;
        }
        //dp[i] means the largest value you(the first player) 
        //can get when you start from values[i] 
        int[] dp = new int[len+1];
        //not even exist
        dp[len] = 0;
        //when you happen to have the last coin, yes, consider the last first
        dp[len-1] = values[len-1];
        //sure we should get the last two for most value
        dp[len-2] = values[len-1] + values[len-2];
        //same rules, why leave two(len-1, len-2) for the other player
        dp[len-3] = values[len-2] + values[len-3];
        //next we are gonna sum up
        for (int i = len-4; i >= 0; i--) {
            //you have to have values[i] and the non-optimal later choice
            //because the other player is smart to leave you the worse one
            //between two of your optimal choices
            dp[i] = values[i] + Math.min(dp[i+2], dp[i+3]);
            dp[i] = Math.max(dp[i], values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
            //equals to: dp[i] = Math.max(values[i] + Math.min(dp[i+2],dp[i+3]), values[i] + values[i+1] + Math.min(dp[i+3], dp[i+4]));
        }
        //compute the total value of coins
        int sum = 0;
        for (int a: values) {
            sum += a;   
        }
        //compare your final value to the other player's
        return dp[0] > sum - dp[0];
    }
