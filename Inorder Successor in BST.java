public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
	TreeNode node = root;
	Stack<TreeNode> stack = new Stack<>();

	while (node != p) {
		stack.push(node.val);
		if (node.val < p.val) {
			node = node.right;
		} else {
			node = node.left;
		}
	}
	if (node.right != null) {
		node = node.right;
	
		while (node.left != null) {
			node = node.left;
		}
		return node;
	} else {
		while (!stack.isEmpty() && stack.peek().val < node.val) {
			stack.pop();
		}
		return stack.isEmpty() ? null : stack.pop();
	}

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
