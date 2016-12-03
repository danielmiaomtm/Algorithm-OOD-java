/*
Given a non-empty binary search tree and a target value, find the value in the BST that is closest to the target.

Note:
Given target value is a floating point.
You are guaranteed to have only one unique value in the BST that is closest to the target.
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    
    int result;
    double diff;
    
    public int closestValue(TreeNode root, double target) {
        if (root == null) {
            return 0;
        }
        diff = Double.MAX_VALUE;
        result = root.val;
        helper(root, target);
        return result;
    }
    public void helper (TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (Math.abs(target - root.val) < diff) {
            diff = Math.abs(target - root.val);
            result = root.val;
        }
        if (root.val < target) {
            helper(root.right, target);
        } else if (root.val > target) {
            helper(root.left, target);
        } else {
            diff = 0;
            result = root.val;
        }
    }
}
