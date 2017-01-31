/*
Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum.

If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of 
abs(sum(Subset1) – sum(Subset2)) should be minimum.

Example:

Input:  arr[] = {1, 6, 11, 5} 
Output: 1
Explanation:
Subset1 = {1, 5, 6}, sum of Subset1 = 12 
Subset2 = {11}, sum of Subset2 = 11	
*/



int minDiff = Integer.MAX_VALUE;
	public int minDiff (int[] nums) {
	    int sum = 0;
	    for (int i = 0; i < nums.length; i++) {
	        sum += nums[i];
	    }
	    boolean[] visited = new boolean[nums.length];
	    helper(nums, 0, sum, visited);
	    return minDiff;
	}
	public void helper(int[] nums, int curSum, int sum, boolean[] visited) {
	    
	    minDiff = Math.min(minDiff, Math.abs(curSum - (sum - curSum)));
	    
	    for (int i = 0; i < nums.length; i++) {
	    	if (visited[i]) {
	    		continue;
	    	}
	        visited[i] = true;
	        helper(nums, curSum + nums[i], sum, visited);
	        visited[i] = false;        
	    }
	    
	}
