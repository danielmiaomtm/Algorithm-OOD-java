/*

给一个数组， 给一个数字 k. 问能不能把数组里面的数字分到k个桶里面， 使得每个桶里面所有的数字和相同。

Given an integer array of N elements, the task is to divide this array into K non-empty subsets such that the sum of elements in every subset is same. All elements of this array should be part of exactly one partition.
Examples:

Input : arr = [2, 1, 4, 5, 6], K = 3
Output : Yes
we can divide above array into 3 parts with equal
sum as [[2, 4], [1, 5], [6]]

Input  : arr = [2, 1, 5, 5, 6], K = 3
Output : No
It is not possible to divide above array into 3
parts with equal sum
*/


	boolean result = false;
	public boolean canSplit (int[] nums, int k) {
	    if (nums == null || nums.length == 0 || k <= 1 ) {
	        return true;
	    }
	    
	    if (k > nums.length) {
	        return false;
	    }
	    int sum = 0;
	    for (int i = 0; i < nums.length; i++) {
	        sum += nums[i];
	    }
	    // if the sum of each array is integer
	    if (sum % k != 0) {
	        return false;
	    }
	    int target = sum / k;
	    boolean[] visited = new boolean[nums.length];
	    List<Integer> list = new ArrayList<>();
	    List<List<Integer>> ll = new ArrayList<>();
	    helper(nums, k, target, 0, 0, visited, list, ll);
	    for (List<Integer> l : ll) {
	    	System.out.println(Arrays.toString(l.toArray()));
	    }
	    return result;
	}

	public void helper (int[] nums, int k, int target, int numOfSum, int curSum, boolean[] visited, List<Integer> list, List<List<Integer>> ll) {
	    if (numOfSum == k && curSum == 0) {
	    	ll.add(new ArrayList<>(list));
	        result = true;
	        return;
	    }
	    	    
	    for (int i = 0; i < nums.length; i++) {
	        if (visited[i]) {
	            continue;
	        }
	        curSum += nums[i];
	        visited[i] = true;
	        list.add(nums[i]);
          
	        if (curSum < target ) {
	            helper(nums, k, target, numOfSum, curSum, visited, list, ll);
	        } else if (curSum == target) {
	            helper(nums, k, target, numOfSum + 1, 0, visited, list, ll);
	        }
          
	        list.remove(list.size() - 1);
	        curSum -= nums[i];
	        visited[i] = false;
	    }
	}
