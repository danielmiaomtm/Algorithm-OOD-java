/*
You are a professional robber planning to rob houses along a street. 
Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that 
adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were 
broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
money you can rob tonight without alerting the police.
*/

public int rob(int[] nums) {
    if (nums.length == 0) {
        return 0;
    }
    if (nums.length == 1) {
        return nums[0];
    }
    int now  = 0;
    int last = 0;

    for (int i = 0; i < nums.length; i++) {
        int temp = last;
        last = now;
        now  = Math.max(now,nums[i] + temp);
    }
    return now;
}

/*
After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will
not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house 
is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of 
money you can rob tonight without alerting the police.
*/

public int rob(int[] nums) {
    if (nums.length == 1) {
        return nums[0];
    }
    int len = nums.length;
    return Math.max(helper(nums, 0, len - 2), helper(nums, 1, len - 1));
}
public int helper (int[] nums, int start, int end) {
    int include = 0;
    int exclude = 0;
    for (int j = start; j <= end; j++) {
        int i = include;
        int e = exclude;
        include = e + nums[j];
        exclude = Math.max(e, i);
    }
    return Math.max(include, exclude);
}



/*
The houses form a binary tree. If the root is robbed, its left and right can not be robbed.

Analysis

Traverse down the tree recursively. We can use an array to keep 2 values: the maximum money
when a root is selected and the maximum value when a root if NOT selected.
*/



public int rob(TreeNode root) {
    if(root == null)
        return 0;
 
    int[] result = helper(root);
    return Math.max(result[0], result[1]);
}
 
public int[] helper(TreeNode root){
    if(root == null){
        int[] result = {0, 0};
        return result;
    }
 
    int[] result = new int[2];
    int[] left = helper(root.left);
    int[] right = helper (root.right);
 
    // result[0] is when root is selected, result[1] is when not. 
    result[0] = root.val + left[1] + right[1];
    result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
 
    return result;
}
