/*
Given n sorted arrays, find first k common elements in them. 
E.g. the common elements of {{1,3,5,7}, {3,4,5,6}, {3,5,6,8,9}, {2,3,4,5,11,18}} are 3 and 5.
*/

public int[] firstKCommonElements(int[][] arrays, int k) {
	int len = arrays.length;
	int[] pointers = new int[len];
	int[] result = new int[k];
	int index = 0;
	for (int i = 0; i < arrys[0].length; i++) {
		int pivot = arrays[0][i];
		int counter = 1;
		for (int j = 1; j < len; j++) {
			while (pointers[j] < arrays[j].length && pivot > arrays[j][pointers[j]]) {
				pointers[j]++;
			}
			if (pointers[j] == arrays[j].length || pivot != arrays[j][pointers[j]]) {
				break;
			}
			counter++;
		}
		if (counter == n) {
			result[index++] = pivot;
		}
		if (index == k) {
			return result;
		}
	}
	return result;
}
