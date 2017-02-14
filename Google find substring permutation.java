
//if str1: "abccdcc", str2 : "ccd"
//return [1,2,3] 只能有出现ccd的permutation substring

//用sliding window, 设置，i，j两个pointer，每一次都记录每一个char的次数，如果到了就更新
public List<Integer> findPermutaion (String str1, String str2) {
			int maxLen = str2.length();
			int[] chars = new int[26];
			List<Integer> result = new ArrayList<>();

			for (int i = 0; i < str2.length(); i++) {
				chars[str2.charAt(i) - 'a']++; 
			}
			int totalChar = maxLen;
			
			int j = 0;
			for (int i = 0; i <= str1.length() - maxLen; i++) {

				while (j - i <= maxLen - 1) {
					char c = str1.charAt(j);
					chars[c - 'a']--;
					if (chars[c - 'a'] >= 0) {
						totalChar--;
					}
					if (totalChar == 0) {
						result.add(i);
					}
					j++;
				}
				
				chars[str1.charAt(i) - 'a']++;
				if (chars[str1.charAt(i) - 'a'] > 0) {
					totalChar++;
				}
			}
			return result;
		}
