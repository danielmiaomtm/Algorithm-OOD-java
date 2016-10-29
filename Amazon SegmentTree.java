class SegmentTreeNode {
	SegmentTreeNode left;
	SegmentTreeNode right;
	int max;
	int start;
	int end;
	public SegmentTreeNode (int start, int end, int max) {
		this.start = start;
		this.end = end;
		this.max = max;
		this.left = null;
		this.right = null;
	}
}
/*
For array [1, 4, 2, 3], the corresponding Segment Tree is:

                  [0, 3, max=4]
                 /             \
          [0,1,max=4]        [2,3,max=3]
          /         \        /         \
   [0,0,max=1] [1,1,max=4] [2,2,max=2], [3,3,max=3]
*/
// Build SegmentTree
public SegmentTreeNode build(int[] nums) {

	return buildTree (nums, 0, nums.length - 1);

}
public SegmentTreeNode buildTree(int[] nums, int start, int end) {
	if (start > end) {
		return null;
	}
	SegmentTreeNode root = new SegmentTreeNode(start, end, Integer.MIN_VALUE);
	if (start != end) {
		int mid = start + (end - start) / 2;
		root.left = buildTree(nums, start, mid);
		root.right = buildTree(nums, mid + 1, end);
		root.max = Math.max(root.left.max, root.right.max);
	} else {
		root.max = nums[end];
	}
	return root;
}
