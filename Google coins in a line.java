/*
There are n coins in a line. Two players take turns to take one or two coins from right side until there are no more coins left. 
The player who take the last coin wins.
Could you please decide the first play will win or lose?
Example
n = 1, return true.
n = 2, return true.
n = 3, return false.
n = 4, return true.
n = 5, return true.
Challenge
O(n) time and O(1) memory

*/

   public boolean firstWillWin(int n) {
        boolean[] dp = new boolean[n + 1];
        boolean[] visit = new boolean[n + 1];
        
        return search(n, dp, visit);
    }

    private boolean search(int n, boolean[] dp, boolean[] visit){
        if(visit[n]){
            return dp[n];
        }

        if(n == 0){
            dp[n] = false;
        }else if (n == 1 || n == 2){
            dp[n] = true;
        }else{
            boolean result = false;
            //如果对手只走一步
            if (n - 3 >= 0) {
              result = result || search(n - 2, dp, visit) && search(n - 3, dp, visit);
            }
            //如果对手走了两步
            if (n - 4 >= 0) {
              result = result || search(n - 3, dp, visit) && search(n - 4, dp, visit);
            }
           dp[n] = result;
        }

        visit[n] = true;
        return dp[n];
    }
}



/*
There are n coins with different value in a line. Two players take turns to take one or two coins from left side until there are
no more coins left. The player who take the coins with the most value wins.
Could you please decide the first player will win or lose?
Example
Given values array A = [1,2,2], return true.
Given A = [1,2,4], return false.
*/





    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return false;
        }

        if(values.length < 3){
            return true;
        }

        int n = values.length;
        int[][] dp = new int[n + 1][n + 1];
        boolean[][] visit = new boolean[n + 1][n + 1];

        int[] sum = new int[n + 1];
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + values[i - 1];
        }

        return search(1, n, sum, dp, visit) > sum[n] / 2;
    }

    private int search(int start, int end, int[] sum, int[][] dp, boolean[][] visit){
        if(visit[start][end]){
            return dp[start][end];
        }

        if(end - start >= 2){
            dp[start][end] = (sum[end] - sum[start - 1]) - Math.min(search(start + 1, end, sum, dp, visit), search(start + 2, end, sum, dp, visit));
        }else{
            dp[start][end] = sum[end] - sum[start - 1];
        }

        visit[start][end] = true;
        return dp[start][end];
    }
}









/*
There are n coins in a line. Two players take turns to take a coin from one of the ends of the line until there are no more coins left. 
The player with the larger amount of money wins.
Could you please decide the first player will win or lose?
Example
Given array A = [3,2,2], return true.
Given array A = [1,2,4], return true.
Given array A = [1,20,4], return false.

Challenge
Follow Up Question:
If n is even. Is there any hacky algorithm that can decide whether first player will win or lose in O(1) memory and O(n) time?
*/

https://zhengyang2015.gitbooks.io/lintcode/content/coins_in_a_line_iii_396.html?q=

public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return false;
        }

        int n = values.length;
        int[] sum = new int[n + 1];
        sum[0] = 0;
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i - 1] + values[i - 1];
        }
        int[][] dp = new int[n + 1][n + 1];
        boolean[][] visit = new boolean[n + 1][n + 1];

        return search(1, n, sum, dp, visit) > sum[n] / 2;
    }

    private int search(int start, int end, int[] sum, int[][] dp, boolean[][] visit){
        if(visit[start][end]){
            return dp[start][end];
        }

        if(start == end){
            visit[start][end] = true;
            return dp[start][end] = sum[end] - sum[start - 1];
        }

        int max = (sum[end] - sum[start - 1]) - Math.min(search(start, end - 1, sum, dp, visit), search(start + 1, end, sum, dp, visit));

        visit[start][end] = true;
        dp[start][end] = max;
        return dp[start][end];
    }
}
