Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

Example:
Given binary tree

          1
         / \
        2   3
       / \     
      4   5    
Returns [4, 5, 3], [2], [1].



public List<List<Integer>> findLeaves(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
          TreeMap<Integer, List<Integer>> map = new TreeMap<>();
          helper(map, root, 0);

          for (List<Integer> l : map.values()) {
            result.add(new ArrayList<>(l));
          }
          return result;
}
public int helper (TreeMap<Integer, List<Integer>> map, TreeNode root, int level) {
          if (root == null) {
            return 0;
          }
          int left = helper(map, root.left, level);
          int right = helper(map, root.right, level);
          int result = Math.max(left, right) + 1;
          if (!map.containsKey(result)) {
            map.put(result, new ArrayList<>());
          }
          List<Integer> list = map.get(result);
          list.add(root.val);
          map.put(result, list);

          return result;
}




//优化
public List<List<Integer>> findLeaves(TreeNode root) {
          List<List<Integer>> result = new ArrayList<>();
          helper(root, result);
          return result;
          }
          public int helper (TreeNode root, List<List<Integer>> result) {
          if (root == null) {
            return 0;
          }
          int level = Math.max(helper(root.left, result), helper(root.right, result)) + 1;
          if (result.size() < level) {
            result.add(new ArrayList<>());
          }

          result.get(level - 1).add(root.val);

          return level;
}
