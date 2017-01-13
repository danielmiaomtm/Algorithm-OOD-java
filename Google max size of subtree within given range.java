/*
Problem 2: 给定一个二叉搜索树，输出最大的subtree的size，使得subtree中的所有元素都在[A, B]范围内。
*/


public int maxSubTree (TreeNode root, int start, int end) {
  if (root == null || (root.val < start || root.val > end)) {
    return 0;
  }
  int maxSize = 0;
  helper(root, start, end, maxSize);
  return maxSize;
}
public int helper (TreeNode root, int start, int end, int maxSize) {
  if (root == null) {
    return 0;
  }
  int left = helper(root.left, start, end, maxSize);
  if (root.left != null && left == 0) {
    return 0;
  }
  int right = helper(root.right, start, end, maxSize);
  if (root.right != null && right == 0) {
    return 0;
  }
  
  if (root.val >= start && root.val <= end) {
    maxSize = Math.max(left + right + 1, maxSize);
    return maxSize
  } else {
    return 0;
  }
  
  
}
