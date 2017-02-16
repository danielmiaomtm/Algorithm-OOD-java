/*Given a screen with a given width, height and supported min/max font size, determine the max font a given string can be 
displayed in. Word or character can’t be broken. Imagine a method getWidth(char c, int fontSize) and 
getHeight(int fontSize) are given


    二分搜[minFont, maxFont]这个范围
找到mid，把string里的都按mid font放到screen中，放不下，往左，放下，往右
*/



class Solution {

	int width;
	int height;
	List<Integer> fonts;
	Solution (int width, int height, List<Integer> fonts) {
		this.width = width;
		this.height = height;
		this.fonts = fonts;
	}
	public int getWidth (char c, int fontSize) {

	}
	public int getHeight (int fontSize) {

	}
	public int canFitInt (String input) {
		if (input == null || input.length() == 0) {
			return fonts.get(fonts.size() - 1);
		}
		int left = 0, right = fonts.size() - 1;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (helper(input, mid)) {
				left = mid;
			} else {
				right = mid;
			}
		}
		if (helper(input, right)) {
			return right;
		}
		if (helper(input, left)) {
			return left;
		}
		return -1;
	}

	public boolean helper (String input, int fontSize) {
		int start = 0;
		int curHeight = 0;
		int curWidth = 0;
		for (int i = 0; i < input.length(); i++) {
			// add space 
			while (i < input.length() && input.charAt(i) == ' ') {
				int charSize = getWidth(' ', fontSize);
				if (curWidth + charSize > width) {
					curHeight += getHeight(fontSize);
					if (curHeight > height) {
						return false;
					}
					curWidth = charSize;
				} else {
					curWidth += charSize;
				}
			}
			// add word
			int wordLen = 0;
			while (i < input.length() && input.charAt(i) != ' ') {
				wordLen += getWidth(input.charAt(i), fontSize);
			}
			if (wordLen > width) {
				return false;
			}

			// if cannot fint in one line, and then new a line
			if (curWidth + wordLen > width) {
				curHeight += getHeight(fontSize);
				if (curHeight > height) {
					return false;
				}
				curWidth = wordLen;
			} else {
				curWidth += wordLen;

			}
			
		}
		return true;
	}
}
