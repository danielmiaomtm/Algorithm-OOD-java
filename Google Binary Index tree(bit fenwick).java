/*
We have an array arr[0 . . . n-1]. We should be able to
1 Find the sum of first i elements.
2 Change value of a specified element of the array arr[i] = x where 0 <= i <= n-1.
*/


public int[] createBIT (int[] input) {
	int[] BITree = new int[input.length + 1];
	for (int i = 0; i < input.length; i++) {
		int index = i + 1;
		while (index <= input.length) {
			BITree[index] += input[i];
      //get the next index
			index += index & (-index);
		}
	}
	return BITree;
}
//want the sum 0 - index,
public int getSum (int[] BITree, int index) {
	int sum = 0;
	index++;
	while (index > 0) {
		sum += BITree[index];
    //get the partent index
		index -= index & (-index);
	}
	return sum;
}
