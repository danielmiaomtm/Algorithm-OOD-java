
//lgn time
public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if(root==null)
	return null;

    TreeNode next = null;
    TreeNode c = root;
    while(c!=null && c.val!=p.val){
	if(c.val > p.val){
	    next = c;
	    c = c.left;
	}else{
	    c= c.right;
	}
    }

    if(c==null)        
	return null;

    if(c.right==null)
	return next;

    c = c.right;
    while(c.left!=null)
	c = c.left;

    return c;
}



//Normal tree

public int inorderSuccessor(TreeNode root, TreeNode p) {

        // 
        if (p.right != null) {
            TreeNode cur = p.right;
            while (cur.left != null) {
                cur = cur.left;
            }
            return cur.val;
        } else {
            Stack<TreeNode> stack = new Stack<>();
            TreeNode node = root;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }

            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                if (cur.right != null && cur != p) {
                    TreeNode temp = cur.right;
                    if (temp == p) {
                        return stack.peek() == null ? -100 : stack.peek().val;
                    }
                    while (temp != null) {
                        stack.push(temp);
                        temp = temp.left;
                    }

                } else if (cur == p) {
                    return stack.peek() == null ? -100 : stack.peek().val;
                }
            }

        }

        return -100;
    }
