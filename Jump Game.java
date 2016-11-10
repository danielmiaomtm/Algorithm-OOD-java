/*
Given an array of non-negative integers, you are initially positioned at the first index of the array.
Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example, given array A = [2,3,1,1,4], the minimum number of jumps to reach the last index is 2. 
(Jump 1 step from index 0 to 1, then 3 steps to the last index.)
*/ 
 
 public int jump(int[] nums) {
      if (nums == null || nums.length == 0)
        return 0;

      int lastReach = 0;
      int reach = 0;
      int step = 0;

      for (int i = 0; i <= reach && i < nums.length; i++) {
        //when last jump can not read current i, increase the step by 1
        if (i > lastReach) {
          step++;
          lastReach = reach;
        }
        //update the maximal jump 
        reach = Math.max(reach, nums[i] + i);
      }

      if (reach < nums.length - 1)
        return 0;

      return step;
    }
