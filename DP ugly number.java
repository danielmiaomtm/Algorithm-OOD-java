/*
设计一个算法，找出只含素因子3，5，7 的第 k 大的数。
符合条件的数如：3，5，7，9，15......

样例
如果k=4， 返回 9
挑战

要求时间复杂度为O(nlogn)或者O(n)
*/

  public long kthPrimeNumber(int k) {
        long[] uglyNumbers = new long[k + 1];
        int indexFor3 = 0, indexFor5 = 0, indexFor7 = 0; //multiplier index
        uglyNumbers[0] = 1;
        for (int i = 1; i <= k; i++) {
            uglyNumbers[i] = Math.min(Math.min(3 * uglyNumbers[indexFor3], 5 * uglyNumbers[indexFor5]), 7 * uglyNumbers[indexFor7]);
            if (uglyNumbers[i] == 3 * uglyNumbers[indexFor3]) {
                indexFor3++;
            }
            if (uglyNumbers[i] == 5 * uglyNumbers[indexFor5]) {
                indexFor5++;
            }
            if (uglyNumbers[i] == 7 * uglyNumbers[indexFor7]) {
                indexFor7++;
            }
        }
        return uglyNumbers[k];
    }
    
    
/*
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most numbers are not ugly. 
Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of merging from three sorted lists: L1, L2, and L3.
Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).

*/


  public int nthUglyNumber(int n) {
        int[] uglyNumber = new int[n];
        int[] index = new int[3]; // respectively for 2,3,5
        int[] factor = {2, 3, 5}; // respectively for 2,3,5
        uglyNumber[0] = 1;
        for(int i = 1; i < n; i++){
            int min = Math.min(Math.min(factor[0], factor[1]), factor[2]);
            uglyNumber[i] = min;
            if(min == factor[0]) factor[0] = 2 * uglyNumber[++index[0]];
            if(min == factor[1]) factor[1] = 3 * uglyNumber[++index[1]];
            if(min == factor[2]) factor[2] = 5 * uglyNumber[++index[2]];            
        }
        return uglyNumber[n - 1];
    }


