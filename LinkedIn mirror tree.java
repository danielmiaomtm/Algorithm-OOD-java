/*
        1              1
      2   3          3   2
     4 5 6 7        7 6 5 4


*/

public TreeNode mirrorTree(TreeNode root) {
  if (root == null || (root.left == null && root.right == null)) {
    return root;
  }
  TreeNode left = mirrorTree(root.left);
  TreeNode right = mirrorTree(root.right);
  TreeNode temp = left;
  root.left = right;
  root.right = temp;
  return root;
}
