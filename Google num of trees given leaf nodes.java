/*	
然后问了 full binary tree （每个node 要么有两个child要么没有）的问题，求给定leaf node数量，生成所有可能的树的结构。
 */ 
  public List<Node> generateFullBinaryTree(int n) { 
		List<Node> res = new ArrayList<>(); 
		if (n == 0) {
			res.add(null); 
			return res; 
			} 
		if (n == 1) { 
			res.add(new Node());
			return res; 
		} 
		for (int i = 1; i < n; i++) { 
			List<Node> leftNodes = generateFullBinaryTree(i); 
			List<Node> rightNodes = generateFullBinaryTree(n - i); 
			for (Node left : leftNodes) { 
				for (Node right : rightNodes) { 
					Node root = new Node(); 
					root.left = left; 
					root.right = rright; 
					res.add(root); 
				} 
			} 
		} 
		return res; 
	}
