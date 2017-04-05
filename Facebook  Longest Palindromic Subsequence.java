/*
Find longest palindrome subsequence

input: abda
output : aba|ada

    0 1 2 3
  0 1 1 1 3
  1   1 1 1
  2     1 1
  3       1

*/


public int longestPalindromeSubsequence (String string) {

	char[] str = string.toCharArray();
	int[][] temp = new int[str.length][str.length];

	for (int i = 0; i < temp.length; i++) {
		temp[i][i] = 1;
	}

	for (int len = 2; len <= string.length(); len++) {
		for (int i = 0; i <= str.length - len; i++) {
			int j = i + len - 1;
			if (len == 2 && str[i] == str[j]) {
				temp[i][j] = 2;
			} else if (str[i] == str[j]) {
				temp[i][j] = temp[i + 1][j - 1] + 2;
			} else {
				temp[i][j] = Math.max(temp[i + 1][j], temp[i][j - 1]);
			}
		}
	}
	return temp[0][str.length - 1];
}
