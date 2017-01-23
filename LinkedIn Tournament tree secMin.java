/*
ournament tree 找secMin;. visit 1point3acres.com for more.

Tournament tree 的定义是parent 是孩子node的最小值， 如下例 return 5

                2
              /  \
            2     7
          /  \    | \
        5    2    8  7

*/



public int secondMin (tournamentTree root) {
  if (root == null || (root.left == null && root.right == null) || root.left == null || root.right == null) {
    return -1;
  }
  int result = helper(root, root.val);
  return result == Integer.MAX_VALUE ? -1 : result;
  }

public int helper (tournamentTree root, int minVal) {
    if (root == null) {
      return Integer.MAX_VALUE;
  }
  if (root.left == null && root.right == null) {
    return root.val;
  }
  int left = helper(root.left, minVal);
  int right = helper(root.right, minVal);

  if (left == minVal) {
    left = Integer.MAX_VALUE;
  }
  if (right == minVal) {
    right = Integer.MAX_VALUE;
  }

  if (left == minVal) {
    return right;
  } else if (right == minVal) {
    return left;
  } else {
    return Math.min(left, right);
  }

}
