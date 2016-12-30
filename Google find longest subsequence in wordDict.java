/*
一个字典里存着word，给一个target string，判断出字典里最长的subsequence word。（这个word是target string的subsequence）
优化时间 O (t + Len(dict))

target = "czab"    dict : ["ab", "cab"]

0 (c) 2  3   0  -1   1
1 (z) 2  3  -1  -1   1
2 (a) 2  3  -1  -1  -1
3 (b) -1 3  -1  -1  -1

*/

public int maxSubsequence (List<String> dict, String target) {
  
	//预处理target，更新每一个char出现的pos
	int[][] arrs = new int[target.length()][26];
	int maxLen = 0;

	for (int i = target.length() - 1; i >= 0; i--) {
		for (int j = 0; j < 26; j++) {
			if (target.charAt(i) - 'a' == j) {
				arrs[i][j] = i;	
			} else {
				if (i + 1 < target.length()) {
					arrs[i][j] == arrs[i + 1][j];
				} else {
					arrs[i][j] = -1;
				}
			}
		}
	}

	for (String word : dict) {
		if (word.length() > target) {
			continue;
		}
		int pos = 0;
		for (char c : word.toCharArray()) {
			pos = arrs[pos][c];
			if (pos == -1) {
				break;
			} 
			pos = 
		}
		maxLen = Math.max(maxLen, word.length());
	}
	
	return maxLen;
}
