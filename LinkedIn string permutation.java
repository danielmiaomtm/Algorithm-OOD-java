/*
with constant space
首先排序，然后从右到左找到第一个递减的，标记i，然后在i的右边找到比char[i]最接近大的,标记r,然后swap(i, r)，之后再从i+1位置开始生序排列.

all
lal
lla

*/
public List<String> strPermuation (String input) {
		List<String> result = new ArrayList<>();
		if (input == null || input.length() == 0) {
			return result;
		}
		
		char[] chars = input.toCharArray();
		Arrays.sort(chars);

		while (true) {
			
			
			result.add(new String(chars));
			int i;
			for (i = chars.length - 2; i >= 0; i--) {
				if (chars[i] < chars[i + 1]) {
					break;
				}
			}
			if (i == -1) {
				break;
			}
			int nextLarger = findNextLarger(chars, chars[i], i + 1, chars.length - 1);
			swap(chars, i, nextLarger);
			Arrays.sort(chars, i + 1, chars.length - 1);
		}
		return result;
	}
	public int findNextLarger (char[] chars, char pre, int left, int right) {
		int result = left;
		for (int i = left + 1; i <= right; i++) {
			if (chars[i] > pre && chars[i] < chars[result]) {
				result = i;
			}
		}
		return result;
	}
	public void swap (char[] chars, int left, int right) {
		char temp = chars[left];
		chars[left] = chars[right];
		chars[right] = temp;
	}
