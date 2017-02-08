public int minDiff (int[] a, int[] b) {
		  int minDiff = Integer.MAX_VALUE;
		  int colNum = b.length, rowNum = a.length;
		  int[][] dp = new int[rowNum + 1][colNum + 1];
		  for (int j = 1; j <= colNum; j++) {
			  dp[0][j] = b[j - 1];
		  }
		  for (int i = 1; i <= rowNum; i++) {
			  dp[i][0] = a[i - 1];
		  }
		  for (int i = 1; i <= rowNum; i++) {
			  for (int j = 1; j <= colNum; j++) {
				  dp[i][j] = Math.min(dp[i - 1][j - 1] + (int)Math.abs(a[i - 1] - b[j - 1]), dp[i][j - 1]);
				  
			  }
		  }
		  for (int[] d : dp) {
			  System.out.println(Arrays.toString(d));
		  }
		  return dp[rowNum][colNum];
	  }
