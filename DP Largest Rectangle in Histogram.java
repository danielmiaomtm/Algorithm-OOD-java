/*
Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, 
find the area of largest rectangle in the histogram.

histogram

Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

Given height = [2,1,5,6,2,3],
return 10.
*/


  public int largestRectangleArea(int[] height) {
        // write your code here
        if (height.length == 0 || height == null) {
            return 0;
        }
        if (height.length == 1) {
            return height[0];
        }
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        
        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
