
// longest common substring
public static int getLongestCommonSubstring(String a, String b){
			int m = a.length();
			int n = b.length();
		 
			int max = 0;
		 
			int[][] dp = new int[m + 1][n + 1];
		 
			for(int i = 1; i <= m; i++){
				for(int j = 1; j <= n; j++){
					if(a.charAt(i - 1) == b.charAt(j - 1)){
					
						dp[i][j] = dp[i-1][j-1]+1;
						
						max = Math.max(max, dp[i][j]);
					} else {
						dp[i][j] = 0;
					} 	
		 
		 
				}
			}
		 
			return max;
		}
    
    
    
    public static int getLongestCommonSubsequence(String a, String b){
			int m = a.length();
			int n = b.length();
		 		 
			int[][] dp = new int[m + 1][n + 1];
		 
			for(int i = 1; i <= m; i++){
				for(int j = 1; j <= n; j++){
					if(a.charAt(i - 1) == b.charAt(j - 1)){
					
						dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1] + 1);
					} else {
						dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
					}		
					
				}
			}
		 
			return dp[m][n];
		}
