/*
generic tree。 每個node 有自己的id， parent id， 和 value。 給一個array of tree node。 求出每個node 的subtree 和。
*/

Map<TreeNode, Integer> map = new HashMap<>();

public List<Integer> printSum (TreeNode[] nodes) {
	List<Integer> result = new ArrayList<>();
	if (nodes == null || nodes.length == 0) {
		return result;
	}
	helper(result, nodes, nodes[0], node[0].val);

	return map;
}
public void helper (TreeNode[] nodes, TreeNode node, int val) {
	if (node == root) {
		return;
	}
	if (map.containsKey(node)) {
		continue;
	}
	for (TreeNode parent : node.parent) {
		if (!map.containsKey(parent)) {
			map.put(parent, parent.val);
		} else {
			int curVal = map.get(parent);
			map.put(parent, curVal + parent.val);
		}
		helper(nodes, parent, parent.val);
	}
} 
