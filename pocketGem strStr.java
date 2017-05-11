
//O(m * n)
public int strStr (String l, String s) {
	if (l == null || l.length() < s.length()) {
		return -1;
	}
	if (s == null || s.length() == 0) {
		return 0;
	}
	for (int i = 0; i <= l.length() - s.length(); i++) {
		if (l.substring(i, i + s.length()).equals(s)) {
			return i;
		}
	}
	return -1;
}
