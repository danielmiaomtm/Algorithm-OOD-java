/*
找一颗树里所有subtree一样的node pair.



就是给你一棵树，比如
       1
    /      \
   2       2
/    \     /  \ 
3    3   3   3

你把subtree一样TreeNode* pair全部找出来
[2,2]的substree都是一样的
leaf nodes都是3，所有个6种[3,3]的组合
还有可能数是这样的
          2
       /     \
      3       2
     / \     /  \
   1    2  3   3
              / \
             1   2


*/

public List<TreeNode> nodePairs (TreeNode root) {
	List<List<TreeNode>> result = new ArrayList<>();
	if (root == null) {
		return result;
	}
	helper(root, result);
}
public void helper (TreeNode root, List<List<TreeNode>> result) {
	if (root == null) {
		return;
	}
	compare(root.left, root.right, result);
	helper(root.left, result);
	helper(root.right, result);
	
}
public void compare (TreeNode left, TreeNode right, List<List<TreeNode>> result) {
	if (left == null || right == null) {
		return;
	}
	if (isSame(left, right)) {
		result.add(new ArrayList<TreeNode>(Arrays.asList(left, right)));
	}
	compare(left, right.left, result);
	compare (left, right.right, result);
	compare(left.left, right, result);
	compare(left.right, right, result);
}

public boolean isSame (TreeNode r1, TreeNode r2) {
	if (r1 == null && r2 == null) {
		return true;
	} else if (r1 == null || r2 == null) {
		return false;
	} else {
		if (r1.val != r2.val) {
			return false;
		}
	}
	return helper(r1.left, r2.left) && helper(r1.right, r2.right);
}
