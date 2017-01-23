/*
Two elements of a binary search tree (BST) are swapped by mistake.
Recover the tree without changing its structure.
Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
*/

//space is not constant 

public class Solution {
    
    TreeNode first = null;
    TreeNode second = null;
    TreeNode pre = null;
    public void recoverTree(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	
        helper(root);
        
    	if (second != null && first != null) {
    		swap(first, second);
    	}
    	
    }
    public void helper (TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	helper(root.left);
    	if (pre != null) {
    		if (root.val <= pre.val) {
    			if (first == null) {
    				first = pre;
    			}
    			second = root;
    		}
    	}
    	pre = root;
    	helper(root.right);
    }
    public void swap (TreeNode n1, TreeNode n2) {
    	int temp = n1.val;
    	n1.val = n2.val;
    	n2.val = temp;
    }
}



// space is constant

public class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode current = root;
        TreeNode prev = null;
        TreeNode node1 = null;
        TreeNode node2 = null;
        while (current != null) {
            if (current.left == null) {
                if (prev != null) {
                    if (prev.val >= current.val) {
                        if (node1 == null)
                            node1 = prev;
                        node2 = current;
                    }
                }
                prev = current;
                current = current.right;
            } else {
                TreeNode t = current.left;
                while (t.right != null && t.right != current)
                    t = t.right;
                if (t.right == null) {
                    t.right = current;
                    current = current.left;
                } else {
                    t.right = null;
                    if (prev != null) {
                        if (prev.val >= current.val) {
                            if (node1 == null)
                                node1 = prev;
                            node2 = current;
                        }
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        int tmp = node1.val;
        node1.val = node2.val;
        node2.val = tmp;
    }
}
