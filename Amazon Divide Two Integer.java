/*
Divide two integers without using multiplication, division and mod operator.

If it is overflow, return MAX_INT.
lg(n) time

*/


public class Solution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean sign = false;
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            sign = true;
        } 
        
        long pDividend = Math.abs((long)dividend);
        long pDivisor = Math.abs((long)divisor);
        
        int result = 0;
        while (pDividend >= pDivisor) {
            int numShift = 0;
            while (pDividend >= (pDivisor << numShift)) {
                numShift++;
            }
            result += 1 << (numShift - 1);
            pDividend -= (pDivisor << (numShift - 1));
        }
        return sign ? result : result * (-1);
    }
}
