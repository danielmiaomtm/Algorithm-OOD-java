public TreeNode delete(TreeNode root, int key) {
    if (root == null) {
      return null;
    } else if (key < root.key) {
      root.left = delete(root.left, key);
      return root;
    } else if (key > root.key) {
      root.right = delete(root.right, key);
      return root;
    } else {
      if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.right;
      } else if (root.right.left == null) {
        root.right.left = root.left;
        return root.right;
      } else {
        TreeNode newRoot = deleteSmallest(root.right);
        newRoot.left = root.left;
        newRoot.right = root.right;
        return newRoot;
      }
    }
  }

  private TreeNode deleteSmallest(TreeNode root) {
    while (root.left.left != null) {
      root = root.left;
    }
    TreeNode smallest = root.left;
    root.left = root.left.right;
    return smallest;
  }
}
