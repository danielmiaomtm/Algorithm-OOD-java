/*
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. 
Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:

1 ≤ n ≤ 1000
1 ≤ m ≤ min(50, n)
Examples:

Input:
nums = [7,2,5,10,8]
m = 2

Output:
18

Explanation:
There are four ways to split nums into two subarrays.
The best way is to split it into [7,2,5] and [10,8],
where the largest sum among the two subarrays is only 18.
Hide Company Tags
*/




public class Solution {
    public int splitArray(int[] nums, int m) {
        long sum = 0;
        int max = 0;
        for(int num: nums){
            max = Math.max(max, num);
            sum += num;
        }
        return (int)helper(nums, m, sum, max);
    }
    
    private long helper(int[] nums, int m, long high, long low){
      
        while(low + 1 < high){
            // System.out.println("low  " + low);
            // System.out.println("high  " + high);
            long mid = low + (high - low) / 2;
            // System.out.println("mid  " + mid);
            if(valid(nums, m, mid)){
                high = mid;
            }else{
                low = mid;
            }
        }
        if (valid(nums, m, low)) {
            return low;
        }
        return high;
    }
    
    private boolean valid(int[] nums, int m, long max){
        int cur = 0;
        int count = 1;
        for(int num: nums){
            cur += num;
            if(cur > max){
                cur = num;
                count++;
                if(count > m){
                    return false;
                }
            }
        }
        return true;
    }
}
