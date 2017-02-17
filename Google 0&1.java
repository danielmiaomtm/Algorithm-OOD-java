	/*
  有字符串都为0&1组成，给m，n分别代表0和1的个数，然后可以表示最多几个数？
  比如input : ["10", "0", "1"] m = 1, n = 1 
      output :2
  
  idea,先排序，然后再一个个检查过去，优化的是如果totalLen > m + n那直接return，不需要再继续找下去
  */
  
  
int maxCount = 0;
List<String> ll = new ArrayList<>();

public int findMax (int m, int n, String[] inputs) {
	Arrays.sort(inputs, new Comparator<String>() {
		public int compare (String str1, String str2) {
			return str1.length() - str2.length();
		}
	});
	List<String> result = new ArrayList<>();
	boolean[] visited = new boolean[inputs.length];
	helper(result, visited, m, n, inputs, 0, 0);
	System.out.println(Arrays.toString(ll.toArray()));
	return maxCount;
}
public void helper (List<String> result, boolean[] visited, int m, int n, String[] inputs, int count, int totalLen) {


	for (int i = 0; i < inputs.length; i++) {
		if (visited[i]) {
			continue;
		}
		int zero = 0;
		int ones = 0;
		for (int j = 0; j < inputs[i].length(); j++) {
			char c = inputs[i].charAt(j);
			if (c == '1') {
				ones++;
			} else {
				zero++;
			}
		}
		if (m - zero < 0 || n - ones < 0) {
			continue;
		}
		if (count + 1 > maxCount) {
			maxCount = count + 1;
			ll.clear();
			result.add(inputs[i]);
			ll.addAll(new ArrayList<>(result));
			result.remove(result.size() - 1);
		}


		maxCount = Math.max(maxCount, count + 1);
		visited[i] = true;
		result.add(inputs[i]);
		helper(result, visited, m - zero, n - ones, inputs, count + 1, totalLen + inputs[i].length());
		visited[i] = false;
		result.remove(result.size() - 1);
	}
}






//dp

public int findMaxForm (int m, int n, String[] strs) {

	int[][] dp = new int[m + 1][n + 1];

	for (String s : strs) {
		int[] cost = count(s);
		for (int i = m; i >= cost[0]; i--) {
			for (int j = n; j >= cost[1]; j--) {
				dp[i][j] = Math.max(dp[i][j], dp[i - cost[0]][j - cost[1]] + 1);
			}
		}

	}
	return dp[m][n];
}

public int[] count (String str) {
	int[] cost = new int[2];
	for (int i = 0; i < str.length(); i++) {
		cost[str.charAt(i) - '0']++;
	}
	return cost;
}
