/*
Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0
Return 6.
*/


    public class Solution {
        public int maximalRectangle(char[][] matrix) {
            if(matrix == null || matrix.length == 0 || matrix[0].length == 0){ 
                return 0;
            }
            int[] height = new int[matrix[0].length];
            for(int i = 0; i < matrix[0].length; i ++){
                if(matrix[0][i] == '1') {
                    height[i] = 1;
                }
            }
            int result = largestInLine(height);

            for(int i = 1; i < matrix.length; i ++){
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == '1') {
                        height[j] += 1;
                    } else {
                        height[j] = 0;
                    }
                }
                result = Math.max(result, largestInLine(height));
            }

            return result;
        }


        public int largestInLine (int[] heights) {
            if (heights.length == 0 || heights == null) {
                return 0;
            }
            if (heights.length == 0) {
                return heights[0];
            }
            int result = 0;
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i <= heights.length; i++) {
                int cur = (i == heights.length) ? -1 : heights[i]; 
                while (!stack.isEmpty() && cur <= heights[stack.peek()]) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    result = Math.max(result, h * w);
                }

                stack.push(i);
            }
            return result;
        }
    }
