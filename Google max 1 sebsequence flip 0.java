/*
第一题 给一个stream, 都是1 或 0，求全为1的subsequence 的最长长度。 写了不到10分钟，有个case 没有handle， 他指出来我改了
Follow up， 如果可以flip 一个 0， 这样的最长连续1的长度是什么？ 
*/

public int maxSeq (int[] input) {
  if (input == null || input.length == 0) return 0;
  int maxLen = Integer.MIN_VALUE;
  int curLen = 0;
  int spareLen = 0;
  boolean zero = false;
  for (int i = 0; i < input.length; ++i) {
    if (input[i] == 1) {
       spareLen++;
      } else {
       maxLen = Math.max ( maxLen, curLen + spareLen + 1);
       curLen = spareLen;
       spareLen = 0;
      }
  }
  maxLen = Math.max (maxLen,zero ? curLen + spareLen + 1 : curLen);
  return maxLen;
}
