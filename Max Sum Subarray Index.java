/*
给定一个整数数组，请找出一个连续子数组，使得该子数组的和最大。输出答案时，请分别返回第一个数字和最后一个数字的值。
（如果两个相同的答案，请返回其中任意一个）

样例

给定 [-3, 1, 3, -3, 4], 返回[1,4].
*/

  public List<Integer> maximumSubArray (int[] nums) {
		List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        int[] arr = new int[nums.length];
        arr[0]= nums[0];
        int max = nums[0];
        int[] range = new int[2];
        range[0] = 0;
        range[1] = 0;

        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[i - 1] + nums[i]) {
                start = i;
                arr[i] = nums[i];
                if (nums[i] > max) {
                    range[0] = start;
                    range[1] = i;
                }
                max = arr[i];
            } else {
                arr[i] = nums[i] + arr[i - 1];
                if (arr[i] > max) {
                    range[0] = start;
                    range[1] = i;
                }
                max = arr[i];
            }
        }
        
        for (int i = range[0]; i <= range[1]; i++) {
            result.add(nums[i]);
        }
        return result;
    }
