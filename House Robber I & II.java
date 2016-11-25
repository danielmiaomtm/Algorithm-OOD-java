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
