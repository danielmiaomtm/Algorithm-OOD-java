class node {
	int maxSum;
	int top;
	int bottom;
	int left;
	int right;
	node () {
		this.maxSum = Integer.MIN_VALUE;
		this.top = 0;
		this.bottom = 0;
		this.left = 0;
		this.right = 0;
	}
}
public node maxSubSumMatrix (int[][] matrix) {
	node result = new node();
  // narrow the left,right boundary, and update the maxSum 
	for (int i = 0; i < matrix[0].length; i++) {
		int[] curSum = new int[matrix.length];
		for (int j = i; j < matrix[0].length; j++) {
			for (int k = 0; k < matrix.length; k++) {
				curSum[k] = matrix[i][k];
			}
			int[] helper = maxSubSum(nums);
			if (helper[0] > node.maxSum) {
				result.maxSum = helper[0]
				result.left = i;
				result.right = j;
				result.top = helper[1];
				result.bottom = helper[2];
			}
		}
	}
	return result;
}

// find the maxSubSum from each col, also find the top and bottom boundary
public int[] maxSubSum (int[] nums) {

	int maxVal = 0;
	int top = -1;
	int down = -1;
	int newStart = 0;
	int curSum = 0;

	for (int i = 0; i < nums.length; i++) {
		curSum += nums[i];
		if (curSum > maxVal) {
			maxVal = curSum;
			top = newStart;
			down = i;
		}
		if (curSum < 0) {
			curSum = 0;
			newStart = i + 1;
		}
	}
	//maxVal, top, down
	int[] result = new int[]{maxVal, top, down}
	return result;
}
