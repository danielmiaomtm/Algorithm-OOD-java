	/*
  有字符串都为0&1组成，给m，n分别代表0和1的个数，然后可以表示最多几个数？
  比如input : ["10", "0", "1"] m = 1, n = 1 
      output :2
  
  idea,先排序，然后再一个个检查过去，优化的是如果totalLen > m + n那直接return，不需要再继续找下去
  */
  
  
  int maxCount = 0;
	public int findMax (int m, int n, String[] inputs) {
		Arrays.sort(inputs, new Comparator<String>() {
			public int compare (String str1, String str2) {
				return str1.length() - str2.length();
			}
		});
		
		helper(m, n, inputs, 0, 0, 0);
		
		return maxCount;
	}
	public void helper (int m, int n, String[] inputs, int count, int totalLen, int index) {
		
		if (totalLen > m + n) {
			return;
		}
		for (int i = index; i < inputs.length; i++) {
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
			maxCount = Math.max(maxCount, count + 1);
			helper(m - zero, n - ones, inputs, count + 1, totalLen + inputs[i].length(), i + 1);
		}
	}

