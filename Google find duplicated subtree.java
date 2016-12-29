/*
给一棵binary tree, 找出这个tree里有多少棵一样的subtree
[Solution]
思路是用string来表示一棵tree，并存在Set里用来检测duplicates。那么某个subtree的表示方法就是
String curr = dfs(root.left) + root.val + dfs(root.right)
*/



class Solution {
  int cnt = 0;
  public int duplicatedSubtree(TreeNode root) {
    if (root == null) {
      return 0;
    }

    Set<String> trees = new HashSet<>();
    dfs(root, trees);
    return cnt;

  }

  private String dfs(TreeNode root, Set<String> trees) {

    if (root == null) {
      return "#";
    }

    String left = dfs(root.left, trees);
    String right = dfs(root.right, trees);

    String curr = left + root.val + right;

    if (trees.contains(curr)) {
      cnt++;
    } else {
      trees.add(curr);
    }

    return curr;
  }

}
