int sum = 0;
	List<Node> result = new ArrayList<>();
	public List<Node> getPath (Node root) {
		if (root == null) {
			return result;
		}
		List<Node> list = new ArrayList<>();
		helper (root, 0, list);
		return result;
	}
	public void helper (Node root, int curSum, List<Node> list) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			if (curSum + root.val > sum) {
				sum = curSum + root.val;
				result = new ArrayList<>(list);
				result.add(root);
				return;
			}
			return;
		}
		list.add(root);
		helper(root.left, curSum + root.val, list);
		helper(root.right, curSum + root.val, list);
		list.remove(list.size() - 1);
	}
