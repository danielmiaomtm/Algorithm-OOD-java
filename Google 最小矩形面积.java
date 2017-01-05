/*找出最小的矩形面积，通过两个点，然后确定另外两个点，然后更新最小面积
*/
public int maxArea (List<int[]> positions) {
	if (positions == null || positions.size() < 4) {
		return 0;
	}
	int maxArea = 0;
	Set<String> set = new HashSet<>();
	Set<String> visited = new HashSet<>();
	for (int[] pos : positions) {
		set.add(new String(pos[0] + pos[1] + ""));
	}

	for (int i = 0; i < positions.length - 1; i++) {
		int x1 = positions.get(i)[0];
		int y1 = positions.get(i)[1];
		for (int j = i + 1; j < positions.length; j++) {
			int x2 = positions.get(j)[0];
			int y2 = positions.get(j)[1];
			//memorized visited positions
			if (visited.contains(x1 + y2) && visited.contains(x2 + y1)) {
				continue;
			} else {
				if (set.contains(x1 + y2) && set.contains(y2 + x1)) {
					visited.add(x1 + y1 + x2 + y2);
					visited.add(x1 + y2 + x2 + y1);
					visited.add(x2 + y2 + x1 + y1);
					visited.add(x2 + y1 + x1 + y2);
					maxArea = Math.max(maxArea, (int)Math.abs(x1, x2) * Math.abs(y1, y2));
				} else {
					continue;
				}
			}
		}
	}
	return maxArea;
}
