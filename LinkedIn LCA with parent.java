// get the lowest common ancenstor with parent node, first get the height, then set nodes in the same height, and then backtrack to the 
//common parent;
  
  public newTreeNode LCA (newTreeNode root, newTreeNode t1, newTreeNode t2) {
		int h1 = getHeight(root, t1);
		int h2 = getHeight(root, t2);
		if (h1 == -1 || h2 == -1) {
			return null;
		}
		int diff = Math.abs(h1 - h2);
		if (h1 > h2) {
			for (int i = 0; i < diff; i++) {
				t1 = t1.parent;
			}
		} else {
			for (int i = 0; i < diff; i++) {
				t2 = t2.parent;
			}
		}
		
		newTreeNode parent = null;
		while (h1 != 1) {
			t1 = t1.parent;
			h1--;
		}
		return t1;
	}
	public int getHeight(newTreeNode root, newTreeNode target) {
		
		return helper(root, target, 0);
	}
	public int helper(newTreeNode root, newTreeNode target, int level) {
		if (root == null) {
			return -1;
		}
		if (root == target) {
			return level;
		}
		return Math.max(helper(root.left, target, level + 1),helper(root.right, target, level + 1));
	}
