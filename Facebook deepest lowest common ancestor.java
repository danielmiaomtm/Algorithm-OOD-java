/*
多叉树，找最深节点的最低公共父节点
给一个tree，每个node 有很多children，找到所有最深的nodes 的common ancestor, 比如只有一个点最深，那返回他自己。
        1
      / | \
    2  3  4
   /.
  5              5最深，最低公共父节点是2， return 2.

        1
      / | \
    2  3  4
   / \
  5  6         5,6最深，最低公共父节点是2， return 2

        1
      / | \
    2  3  4
   /          \
  5           6   5,6最深，最低公共父节点是1， return 1
*/

int maxDepth = 1;
public TreeNode findCommonNode(TreeNode root) {
	//if max depth nodes == 1, than it is the last second node;
	// else find the lowest common ancestor
	List<List<TreeNode>> lists = new ArrayList<>();
	List<TreeNode> list = new ArrayList<>();
  //get the list
  
	helper (root, 1, list, lists);
	
  if (lists.size() == 1) {
		List<TreeNode> l = lists.get(0);
		return l.get(l.size() - 2);
	} 
  
	TreeNode result = null;
  TreeNode cur = null;
	int i = 0;
  
	while (i < maxDepth) {
    for (List<TreeNode> l : lists) {
      if (cur == null) {
        result = l.get(i);
      }
      if (cur != l.get(i)) {
        break;
      } 
    }
    result = cur;
    cur = null;
    i++;    
	}
  
	return result;

}


public void helepr (TreeNode root, int depth, List<TreeNode> list, List<List<TreeNode>> lists) {
	if (root.left == null && root.right == null) {
		if (depth == maxDepth) {
			lists.add(new ArrayList<>(list));
		} else if (depth > maxDepth) {
			maxDepth = depth;
			lists.clear();
			list.add(root);
			lists.add(new ArrayList<>(list));
			list.remove(list.size() - 1);
		}
		return;
	}
	for (TreeNode child : root.children) {
		list.add(child);
		helper (child, depth + 1, list, lists);
		list.remove(list.size() - 1);
	}
}
