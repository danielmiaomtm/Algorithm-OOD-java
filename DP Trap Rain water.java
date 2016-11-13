/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, 
compute how much water it is able to trap after raining.

Trapping Rain Water

Have you met this question in a real interview? Yes
Example
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

*/

public int trapRainWater(int[] heights) {
        // look from right to left
        if (heights.length <= 2 || heights == null) {
            return 0;
        }
        //first go through from left to right, and get the max from left
        int[] temp = new int[heights];
        int max = heights[0];
        for (int i = 1; i < heights.length; i++) {
            temp[i] = Math.max(max, heights[i - 1]);
        }
        //go through from right to left, get the water
        int result = 0;
        max = heights[heights.length - 1];
        for (int i = heights.length - 2; i > 0; i--) {
            int left = temp[i];
            int right = max;
            int water = Math.min(left, right);
            if (water > heights[i]) {
                result += water - heights[i];
            }
            if (max < heights[i]) {
                max = heights[i];
            }
        }
        return result;
    }
