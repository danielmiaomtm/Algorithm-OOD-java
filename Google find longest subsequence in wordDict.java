/*
一个字典里存着word，给一个target string，判断出字典里最长的subsequence word。（这个word是target string的subsequence）
优化时间 O (t + Len(dict))

target = "czab"    dict : ["ab", "cab"]

0 (c)  2  3   0  -1  ...  1
1 (z)  2  3  -1  -1  ...  1
2 (a)  2  3  -1  -1  ... -1
3 (b) -1  3  -1  -1  ... -1
       a  b   c   d  ...  z
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
		
		}
		maxLen = Math.max(maxLen, word.length());
	}
	
	return maxLen;
}





class TrieNode {
	TrieNode[] children;
	int val;
	boolean isWord;
	TrieNode (int val) {
		this.val = val;
		this.children = new TrieNode[26];
		this.isWord = false;
	}
}
int[][] arrs;
public int longestSubsequence (String target, List<String> dict) {
	int len = target.length();
	if (len == 0) {
		return 0;
	}
	//build Trie Tree
	TrieNode root = buildTrie(dict, len);
	//generate pos map index : time: o(len of target)
	this.arrs = new int[target.length()][26];
	//pre-process target word
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

	int maxLen = 0;
	helper (root, 0, 0, maxLen);
	return maxLen;

}
public void helper (TrieNode root, int start, int len, int maxLen) {
	if (root == null || start == -1) {
		return;
	}
	if (root.isWord) {
		maxLen = Math.max(maxLen, len);
	}
	for (char c = 'a'; c <= 'z'; c++) {
		helper (root.children[c - 'a'], arrs[start][c], len + 1, maxLen);
	}
}
public TreeNode buildTrie (List<String> dict, int maxDepth) {
	TreeNode result = new Node(-1);
	TreeNode node = result;
	for (String word : dict) {
		if (word.length() > maxDepth) {
			continue;
		}
		for (char c : word.toCharArray()) {
			if (node.children[c - 'a'] == null) {
				node.children[c - 'a'] = new TrieNode(c);
			}
			node = node.children[c - 'a'];
		}
		node.isWord = true;
	}
	return result;
}

