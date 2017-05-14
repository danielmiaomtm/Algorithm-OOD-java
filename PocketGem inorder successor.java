//有parent
public TreeNode nextLargestBST (TreeNode node) {
	if (node == null) {
		return null;
	}
	if (node.right != null) {
		return getNext(node.right);
	}
	TreeNode parent = node.parent;
	while (parent != null && parent.val < node.val) {
		parent = parent.parent;
	}
	return parent;
}

//没有parent

public TreeNode nextLargestBSTII (TreeNode root, TreeNode node) {
	if (node == null) {
		return null;
	}
	if (node.right != null) {
		return getNext(node.right);
	}
	TreeNode temp = null;
	while (root != null) {
		if (root.val == node.val) {
			break;
		} else if (root.val < node.val) {
			root = root.right;
		} else {
			root = root.left;
			temp = root;
		}
	}
	return temp;
}




public TreeNode getNext (TreeNode node) {
	TreeNode root = node;
	while (root.left != null) {
		root = root.left;
	}
	return root;
}
