/*
ournament tree 找secMin;

Tournament tree 的定义是parent 是孩子node的最小值， 如下例 return 3

                2
              /  \
            2     7
             \   / \
             2   7  8
            / \
           3   2 
        1.先走到底，如果是leaf返回，如果是null返回最大值，
        2.left,right 返回的时候看返回值是不是和最小值，是的话就将值设为最大值
        3.最后返回left,right最小值
        
*/

//Method 1
public static int secMin(TreeNode root) {
      if (root == null || (root.left == null && root.right == null)) {
              return -1;
      }
      int left = -1, right = -1;
      if (root.left.val == root.val) {
              left = secMin(root.left);
      } else {
              left = root.left.val;
      }
      if (root.right.val == root.val) {
              right = secMin(root.right);
      } else {
              right = root.right.val;
      }
      if (left == -1 || right == -1) {
              return left == -1 ? right : left;
      }
      return Math.min(left, right);
  }





//Method 2
public int secondMin (tournamentTree root) {
  if (root == null || (root.left == null && root.right == null) || root.left == null || root.right == null) {
    return -1;
  }
  int result = helper(root, root.val);
  //如果全部都是最小值那就返回-1，找不到
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

    return Math.min(left, right);
}
