/*
binary tree里面最长的path node的数量
        0
     1      2
  3    4  
          5  
  TreeNode root = new TreeNode(0);
  root.left = new TreeNode(1);
  root.right = new TreeNode(2);
  root.left.left = new TreeNode(3);
  root.left.right = new TreeNode(4);
  root.left.right.right = new TreeNode(5);
  
 return 5 might include root path

*/

  int max;
  public int lenOfNodes (TreeNode root) {
    if (root == null) {
      return 0;
    }
    max = 1;
    helper(root.val);
    return max;
  }
  public int helper(TreeNode root) {
    if (root == null) {
      return 0;
    }
    int left = helper(root.left);
    int right = helper(root.right);

    int temp = Math.max(left, right) + 1;
    max = Math.max(max, Math.max(temp, left + right + 1));
    return temp;
  }
