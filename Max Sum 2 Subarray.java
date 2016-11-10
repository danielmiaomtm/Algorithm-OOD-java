/*
给定一个整数数组，找出两个不重叠子数组使得它们的和最大。

每个子数组的数字在数组中的位置应该是连续的。

返回最大的和。

样例

给出数组[1, 3, -1, 2, -1, 2]，这两个子数组分别为[1, 3]和[2, -1, 2]或者[1, 3, -1, 2]和[2]，它们的最大和都是7
注意

子数组最少包含一个数
挑战

要求时间复杂度为O(n)
*/


public int maxTwoSubArrays(ArrayList<Integer> nums) {
        if (nums == null)
            return 0;
        int len = nums.size(), currSum = 0;
        int[] left = new int[len];
        for (int i = 0; i < len - 1; i++) {
            int sum = currSum + nums.get(i);
            if (i == 0)
                left[i + 1] = sum;
            else
                left[i + 1] = sum > left[i]? sum: left[i];
            currSum = sum <= 0? 0: sum;
        }
        currSum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = len - 1; i > 0; i--) {
            int sum = currSum + nums.get(i);
            if (sum + left[i] > max)
                max = sum + left[i];
            currSum = sum <= 0? 0: sum;
        }
        return max;
    }
