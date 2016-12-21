/*
给定二叉树 和一个function shouldbeerased(node n). 可以询问节点n是否删除， 然后问删除所有shouldbeerased的节点后，剩余tree的集合，
每个tree给个根节点。

              1
            2   3
          4  2 2  5
                    2
                   3 
output:
[1, 4, 3]

*/


public List<Integer> printNodes (TreeNode root, int target) {
		List<Integer> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		helper(result, root, target, true);
		return result;
	}
	public void helper (List<Integer> result, TreeNode root, int target, boolean appeared) {
		
		if (root == null) {
			return; 
		}
		
		if (root.val == target) {
			helper(result, root.left, target, true);
			helper(result, root.right, target, true);
		} else {
			if (appeared) 
				result.add(root.val);

			helper(result, root.left, target, false);
			helper(result, root.right, target, false);
		}
	}
  
  	public static void main (String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, MalformedURLException, IOException {
	
		
      IBG sol = new IBG();


      TreeNode root = new TreeNode(1);
      root.left = new TreeNode(2);
      root.right = new TreeNode(3);
      root.left.left = new TreeNode(4);
      root.left.right = new TreeNode(2);
      root.right = new TreeNode(3);
      root.right.left = new TreeNode(2);
      root.right.right = new TreeNode(5);
      root.right.right.right = new TreeNode(2);
      root.right.right.right.left = new TreeNode(3);


      int target = 2;
      System.out.println(Arrays.toString(sol.printNodes(root, target).toArray()));
	}
