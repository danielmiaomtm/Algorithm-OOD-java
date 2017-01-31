public TreeNode buildTree (List<Relation> input) {
	    // [left, right]
	    Map<TreeNode, TreeNode[]> map = new HashMap<>();
	    TreeNode root;
	   for (int i = 0; i < input.size(); i++) {
		   Relation cur = input.get(i);
	       if (cur.parent == null) {
	           root = new TreeNode(cur.child.val);
	       } else {
	           TreeNode parent = cur.parent;
	           TreeNode child = cur.child;
	           TreeNode[] temp;
	           if (map.containsKey(parent)) {
	               temp = map.get(parent);
	           } else {
	               temp = new TreeNode[2];
	           }
	           if (cur.isLeft) {
	               temp[0] = child;
	           } else {
	               temp[1] = child;
	           }
	           map.put(parent, temp);
	       }
	   } 
	   
	   return helper(node, map);
	   
	}

	public TreeNode helper (TreeNode root, Map<TreeNode, TreeNode[]> map) {
	    if (!map.containsKey(root)) {
	        return null;
	    }
	    TreeNode[] cur = map.get(root);
	    TreeNode node = new TreeNode(root.val);
	    TreeNode left = helper(cur[0], map);
	    TreeNode right = helper(cur[1], map);
	    
	     return node;   
	}
