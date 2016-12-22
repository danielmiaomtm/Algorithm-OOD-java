/*
how many ways to sum $100, based on coins[1,2,5];
*/

//dp
public int ways (int[] coins, int target) {
  int[][] nums = new int[coins.length + 1][coins[0].length + 1];
  
  for (int j = 0; j <= target; j++) {
    nums[0][j] = 0;
  }
  for (int i = 0; i <= coins.length; i++) {
    nums[i][0] = 1;
  }
  
  for (int i = 1; i <= coins.length; i++) {
    for (int j = 1; j <= target; j++) {
      if (j < coins[i - 1]) {
        nums[i][j] = nums[i - 1][j];
        continue;
      }
      nums[i][j] = nums[i - 1][j] + nums[i][j - coins[i - 1]]; 
    }
  }
  return nums[coins.length][coins[0].length];
}

//recursion



