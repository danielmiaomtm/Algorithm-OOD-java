/*
I
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one 
share of the stock), design an algorithm to find the maximum profit.

*/
Time O(n)
Space O(1)

  public class Solution {
      public int maxProfit(int[] prices) {
          int n = prices.length;
          if (n <= 1) return 0;
          int res = 0, minVal = prices[0];
          for (int i = 1; i < n; ++i) {
              res = Math.max(res, prices[i] - minVal);
              minVal = Math.min(minVal, prices[i]);
          }
          return res;
      }
  }


/*
II
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you 
like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in 
multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/
Time O(n)
Space O(1)

  public int maxProfit (int[] prices) {
    if (prices == null || prices.length <= 1) {
      return 0;
    }
    int pre = prices[0];
    int result = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > pre) {
        result += prices[i] - pre;
      } 
      pre = prices[i];
    }
    return result;
  }
  
  
/*

III

Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

Time O(n)
Space O(n)
  public int maxProfit(int[] prices) {
      // write your code here
      if(prices == null || prices.length <= 1) {
          return 0;
      }

      int[] left = new int[prices.length];
      int[] right = new int[prices.length];

      int result = 0;
      int min = prices[0];
      for (int i = 1; i < prices.length; i++) {
          result = Math.max(result, prices[i] - min);
          min = Math.min(min, prices[i]);
          left[i] = result;
      }
      int max = prices[prices.length - 1];
      result = 0;
      for (int i = prices.length - 2; i >= 0; i--) {
          result = Math.max(result, max - prices[i]);
          max = Math.max(max, prices[i]);
          right[i] = result;
      }
      int sum = 0; 
      for (int i = 0; i < prices.length; i++) {
          sum = Math.max(sum, left[i] + right[i]);
      }
      return sum;
  }


/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:

You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

IV
Time O(n)
Space O(n)


  public int maxProfit(int k, int[] prices) {
      // write your code here
      if(prices == null || prices.length <= 1 || k <= 0) {
          return 0;
      }
      // it means you can get maximum profit in the arrs without any restriction, like II
      if(k > prices.length / 2){
          int sum = 0;
          for(int i = 1; i < prices.length; i++){
              if(prices[i] > prices[i - 1]) {
                  sum += prices[i] - prices[i - 1];
              }
          }
          return sum;
      }

      int[] local = new int[k + 1];
      int[] global = new int[k + 1];

      for (int i = 0; i < prices.length - 1; i++) {
          int diff = prices[i + 1] - prices[i];
          for (int j = k; j >= 1; j--) {
              local[j] = Math.max(global[j - 1] + Math.max(diff, 0), local[j] + diff);
              global[j] = Math.max(local[j], global[j]);
          }
      }
      return global[k];
  }
