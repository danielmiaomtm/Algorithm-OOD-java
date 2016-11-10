/*
Longest Common Substring
给出两个字符串，找到最长公共子串，并返回其长度。

样例

给出A=“ABCD”，B=“CBCE”，返回 2
注意

子串的字符应该连续的出现在原字符串中，这与子序列有所不同。
*/

  int result = 0;
  int longestCommonSubstring(string &A, string &B) {
        int lena = a.length();
        int lenb = b.length();

        if (lena == 0 || lenb == 0){
            return 0;
        }

        int[][] dp = new int[lena + 1][lenb + 1];
        for (int i = 0; i <= lena; i++) {
          dp[i][0] = 0;
        }
        for (int j = 0; j <= lenb; j++) {
          dp[0][j] = 0;
        }
        for (int i = 1; i <= lena; i++){
            for (int j = 1; j <= lenb; j++{
                if (a.charAt(i-1) == b.charAt(j-1){
                    dp[i][j] = dp[i-1][j-1] + 1;
                    if (dp[i][j] > result) {
                      result = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return result;
    }
    
    
/*    
Please write a function to calculate the Longest Common Subsequence (LCS) given two strings.

LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
*/


int lcs(String a, String b){
    int lena = a.length();
    int lenb = b.length();
    
    if (lena == 0 || lenb == 0){
        return 0;
    }
    
    int[][] dp = new int[lena+1][lenb+1];
    for (int i = 0; i <= lena; i++){
        for (int j = 0; j <= lenb; j++{
            if (i == 0 || j == 0){
                dp[i][j] = 0;
            } else if (a.charAt(i-1) == b.charAt(j-1){
                dp[i][j] = dp[i-1][j-1] + 1;
            } else {
                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
            }
        }
    }
    return dp[lena][lenb];
}
