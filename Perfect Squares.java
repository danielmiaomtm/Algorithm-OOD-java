/*
Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

*/

public class Solution {
    public int numSquares(int n) {
       
        int[] arrs = new int[n + 1];
        Arrays.fill(arrs, Integer.MAX_VALUE);
// set the square num to 1
        for (int i = 0; i * i <= n; i++) {
            arrs[i * i] = 1;
        }
        
        for (int i = 0; i <= n; i++) {
            for (int j = 0; i + j * j <= n; j++) {
                arrs[i + j * j] = Math.min(arrs[i] + 1, arrs[i + j * j]);
            }
        }
        return arrs[n];
    }
}
