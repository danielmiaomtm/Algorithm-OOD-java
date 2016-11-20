//reverse In-order traversal,
// O(n) Time, O(1) Space

  public TreeNode kthLargest(TreeNode root, int k) {
    if (root == null) {
      return null;
    }
    TreeNode result = null;
    helper(root, k, 0, result);
    return result;
  }
  public void helper (TreeNode root, int k, int count, TreeNode result) {
    if (root == null || c > k) {
      return;
    }
    //go right first
    helper (root.right, k, count, result);
    //update count
    count++;
    if (count == k) {
      result = root;
      return;
    }
    helper(root.left, k, count, result);
  }
