
// BST from preorder 
public int preStart = 0;
public TreeNode constructTree(int[] preorder, int min, int max) {
	if (preStart > preorder.length) {
		return null;
	}
	int cur = preorder[preStart++];
	TreeNode root = null;
	if (min < cur && cur < max) {
		root = new TreeNode(cur);
		if (preStart < preorder.length) {
			root.left = constructTree(preordr, min, cur);
			root.right = constructTree(preorder, cur, max);
		}
	}
	return root;
}



//BST from PostOrder
int postStart = postOrder.length - 1;
public TreeNode constructTreeUtil(int postOrder[], int min, int max) {
    // Base case
    if (postIndex < 0) {
        return null;
    }
    TreeNode root = null;
    // If current element of post[] is in range, then
    // only it is part of current subtree
    int cur = postOrder[postStart--];
    if (min < cur && cur < max) {
        // Allocate memory for root of this subtree and decrement
        // *postIndex
        root = new TreeNode(cur);
        if (postStart > 0) {
            // All nodes which are in range {key..max} will go in 
            // right subtree, and first such node will be root of right
            // subtree
            root.right = constructTreeUtil(postOrder, cur, max);

            // Contruct the subtree under root
            // All nodes which are in range {min .. key} will go in left
            // subtree, and first such node will be root of left subtree.
            root.left = constructTreeUtil(postOrder, min, cur);
        }
    }
    return root;
}
