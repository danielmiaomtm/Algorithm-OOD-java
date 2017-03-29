/*
一个未排序整数数组，有正负数，重新排列使负数排在正数前面，并且要求不改变原来的正负数之间相对顺序，
比如： input: 1,7,-5,9,-12,15 ans: -5,-12,1,7,9,15 要求时间复杂度O(n),空间O(1)。
*/

public static void main (String[] args) {
    int[] numbers = new int[]{5,6,7,-1,-2,-3};
		sol.oddEven(numbers);
		System.out.println(Arrays.toString(numbers));
	  //[-1, -2, -3, 5, 6, 7]
  }
	
	
	public void oddEven(int[] nums) {
		int left = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] < 0) {
				if (left == i) {
					left++;
				} else {
					int temp = nums[left];
					nums[left] = nums[i]; 
					nums[i] = temp;
					left++;
					swap(nums, left, i - 1);
					swap(nums, left, i);
				}
				
			}
		}
	}
	public void swap (int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}
