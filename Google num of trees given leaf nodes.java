	
  //给定leaf的数量，判断一共有几种树可以构造
  
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
		for (int i = 1; i < n; i += 1) { 
			List<Node> leftNodes = generateFullBinaryTree(i); 
			List<Node> rightNodes = generateFullBinaryTree(n - i); 
			for (Node l : leftNodes) { 
				for (Node r : rightNodes) { 
					Node root = new Node(); 
					root.left = l; 
					root.right = r; 
					res.add(root); 
				} 
			} 
		} 
		return res; 
	}
