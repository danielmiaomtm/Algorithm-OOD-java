/*
给两个字符串，返回第一个在第二个里面discontinous matches的数量。discontinous matches的定义是 （所有匹配的character中没有任何两个是相邻的）
举例：
Input: “cat”, “catapult”
Output: 1
catapult => not good
catapult => not good
cactapult => good
*/	
  
  int result = 0;
	public int numOfdicount (String p, String str) {
		Map<Character, List<Integer>> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			List<Integer> list;
			if (!map.containsKey(str.charAt(i))) {
				list = new ArrayList<>();
				map.put(str.charAt(i), list);
			} else {
				list = map.get(str.charAt(i));
			}
			list.add(i);
		}

		helper(p, str, 0, -1, map);
		return result;
	}
	public void helper (String p, String str, int index, int preVal, Map<Character, List<Integer>> map) {
		if (index == p.length()) {
			result++;
			return;
		}
		char c = p.charAt(index);
		List<Integer> list = map.get(c);


		for (int i = 0; i < list.size(); i++) {
			if (preVal == -1) {
				helper(p, str, index + 1, list.get(i), map);
			} else if (preVal + 2 <= list.get(i)) {
				helper(p, str, index + 1, list.get(i), map);
			}			
		}

	}
