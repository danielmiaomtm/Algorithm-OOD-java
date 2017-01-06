/*
Given a screen with a given width, height and supported min/max font size, determine the max font a given string can be displayed in. 
Word or character can’t be broken. Imagine a method getWidth(char c, int fontSize) and getHeight(int fontSize) are given
*/

public int (String input, int min, int max, int width, int height) {
	int left = min;
	int right = max;
	while (left + 1 < right) {
		int mid = left + (right - left) / 2;
		if (canFitWord(mid)) {
			left = mid;
		} else {
			 right = mid;
		}
	}
	if (canFitWord(chars, width, height, right)) {
		return right;
	}
	if (canFitWord(chars, width, height, left)) {
		return left;
	}
	return 0;
}
public boolean canFitWord (char[] chars, int width, int height, int fontSize) {
	int lineHeight = getHeight(fontSize);
	int rowNum = height / lineHeight;

	int w = 0;
	int[] info = new int[n];
	for (int i = 0; i < chars.length; i++) {
		info[i][0] = getWidth(chars[i])
		w += info[i][0];
	}
	//beyond the limited screen area
	if (w > width * rowNum) {
		return false;
	}

	int leftHeight = height;
	int leftWidth = width;
	int start = 0;
	
	w = 0;
	h = 0;
	for (int i = 0; i < chars.length; i++) {
		if (chars[i] == ' ') {
			//go to next new line
			if (w > leftWidth) {
				//if the word is beyond the width, return;
				if (w > width) {
					return false;
				}
				leftWidth = width - w;
				rowNum--;
				//if there is no more new rows for words, return;
				if (rowNum < 0) {
					return false;
				}
			} else {
				leftWidth -= w;
			}
		} else {
			w += info[i];
		}
	}
	return true;
}

// API to get the width of char
public int getWidth (char c, int fontSize) {

}
// API to get the height of certain font size
public int getHeight (int fontSize) {

}
