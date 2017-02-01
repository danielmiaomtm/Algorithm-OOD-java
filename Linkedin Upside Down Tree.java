/*
Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node that shares the same parent node) or empty, 
flip it upside down and turn it into a tree where the original right nodes turned into left leaf nodes. Return the new root.

For example:
Given a binary tree {1,2,3,4,5},
    1
   / \
  2   3
 / \
4   5
return the root of the binary tree [4,5,2,#,#,3,1].
   4
  / \
 5   2
    / \
   3   1  
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/

// first goes to left, set root
// set left-> parent.right, right -> parent
// root is root.right

//recursion

/*
        2
   null   3     return 2;
*/
public class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null || (root.left == null && root.right == null)) {
            return root;
        }
        TreeNode newRoot = upsideDownBinaryTree(root.left);
        
        root.left.left = root.right;
        root.left.right = root;
        //clean the root;
        root.left = null;
        root.right = null;
        
        return newRoot;
    }
    
}



//iteration
public TreeNode upsideDownBinaryTree(TreeNode root) {
    TreeNode node = root, parent = null, right = null;  
    while (node != null) {  
        TreeNode left = node.left;  
        node.left = right;  
        right = node.right;  
        node.right = parent;  
        parent = node;  
        node = left;  
    }  
    return parent;  
}

