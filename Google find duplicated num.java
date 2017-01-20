/*
array, len=n, 其中所有数字都是[0, n-1]范围，里面有一个重复的数字（可能重复多次），找出这个重复的数字
*/


int solution(int nums){
   int len = nums.length;
   int res = -1;
   // add corresponding index with len
   for(int i = 0; i < len; i++){
      int correctIdx = nums[i] % len;
      nums[correctIdx] += len;
   }
   for(int i = 0; i < len; i++){
      if(nums[i]/len >= 2){
         res = i;
         break;
      }
   }
   return res;
}
