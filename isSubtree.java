
public boolean isSubtree (TreeNode root, TreeNode target) {

    if (root == null) {
      return false;
    }
    if (target == null) {
      return true;
    }

    if (isSame(root, target)) {
      return true;
    }
    return helper (root.left, target) || helper(root.right, target);
  }
  public boolean isSame (TreeNode root, TreeNode target) {
    if (root == null && target == null) {
      return true;
    }
    if (root == null || target == null) {
      return false;
    }
    if (root.val != target.val) {
      return false;
    }
    return isSame (root.left, target.left) && isSame (root.right, target.right);
  }
