/*
Check whether a binary tree is contained in another binary tree, child tree structure should be considered

parent        child

   1            3
  / \          / \
 2   3        4   5
    / \
   4   5
  /
 6
 */
 
 public class Solution {
  
  public boolean isContained(TreeNode parent, TreeNode child) {
    // empty tree cannot contain any tree
    if (parent == null)
      return false;
    
    // empty tree can be contained by other tree
    if (child == null)
      return true;
    
    // if we found a match node, we can do the comparison from here
    if (parent.val == child.val && matchTree(parent, child))
      return true;
    
    // otherwise, we continue to search the child's root node
    return isContained(parent.left, child) || isContained(parent.right, child);
  }
  
  public boolean matchTree(TreeNode t1, TreeNode t2) {
    if (t2 == null)
      return true;
    
    if (t1 == null)
      return false;
    
    if (t1.val != t2.val)
      return false;
    
    return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
  }
  
}
