/*
              1
           2    3
          4 5  6 7
           8  9
output : 1, 2, 4, 8, 9, 7, 3
*/	
  
  
  public static void main(String[] args) throws Exception {
		//System.out.println(romanToInteger("XCV"));
		thred sol = new thred();
		
		
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.right = new TreeNode(5);
		root.left.left.right.left = new TreeNode(6);
		root.left.left.right.left.right = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.left.right.right = new TreeNode(-1);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(5);
		root.right.right.left = new TreeNode(-2);
		
		
		//sol.printBoundary(root);
		List<Integer> result = sol.boundaryTraverse(root);
		System.out.println(Arrays.toString(result.toArray()));
		
		//System.out.println(Arrays.toString(nums));
		
	}

	
	public List<Integer> boundaryTraverse (TreeNode root) {
		List<Integer> result = new ArrayList<>();
		
		result.add(root.val);
		
		getLeft(root.left, result);
		
		getMiddle(root, result);
		
		List<Integer> rightList = new ArrayList<>();
		getRight (root.right, rightList);
		Collections.reverse(rightList);
		
		result.addAll(rightList);

		return result;
	}
	public void getLeft (TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		
		result.add(root.val);
		if (root.left != null){
			getLeft(root.left, result);
		} else if (root.right != null){
			getLeft(root.right, result);
		}
		
	}
	public void getRight (TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			return;
		}
		result.add(root.val);
		if (root.right != null) {
			getRight(root.right, result);
		} else if (root.left != null) {
			getRight(root.left, result);
		}
	}
	public void getMiddle (TreeNode root, List<Integer> result) {
		if (root == null) {
			return;
		}
		getMiddle(root.left, result);
		
		if (root.left == null && root.right == null) {
			result.add(root.val);
			return;
		}
		getMiddle(root.right, result);
	}
