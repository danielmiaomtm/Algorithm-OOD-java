public int maxSubArray(int[] nums) {

  int max = Integer.MIN_VALUE;
  int sum = 0;
  for (int i = 0; i < nums.length; i++) {
      sum += nums[i];
      max = Math.max(sum, max);
      if (sum < 0) {
          sum = 0;
      }

  }
  return max;
}

public int maxProduct(int[] nums) {
    int[] max = new int[nums.length];
    int[] min = new int[nums.length];

    min[0] = max[0] = nums[0];
    int result = nums[0];

    for (int i = 1; i < nums.length; i++) {
        min[i] = max[i] = nums[i];
        if (nums[i] > 0) {
            max[i] = Math.max(max[i], max[i - 1] * nums[i]);
            min[i] = Math.min(min[i], min[i - 1] * nums[i]);
        } else if(nums[i] < 0) {
            max[i] = Math.max(max[i], min[i - 1] * nums[i]);
            min[i] = Math.min(min[i], max[i - 1] * nums[i]);
        }
        result = Math.max(result, max[i]);
    }
    return result;
}
