/*
Given a binary array, find the maximum number of consecutive 1s in this array if you can flip at most one 0.

Example 1:
Input: [1,0,1,1,0]
Output: 4
Explanation: Flip the first zero will get the the maximum number of consecutive 1s.
    After flipping, the maximum number of consecutive 1s is 4.
Note:

The input array will only contain 0 and 1.
The length of input array is a positive integer and will not exceed 10,000
Follow up:
What if the input numbers come in one by one as an infinite stream? In other words,
you can't store all numbers coming from the stream as it's too large to hold in memory. Could you solve it efficiently?
*/

//O(n) O(n)
public int findMaxConsecutiveOnes(int[] nums) {
    int[] arrs = new int[nums.length];
    int maxLen = 0;
    List<Integer> zeroPos = new ArrayList<>();
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            zeroPos.add(i);
            arrs[i] = 0;
            maxLen = 0;
        } else {
            maxLen++;
            arrs[i] = maxLen;
        }
    }
    if (zeroPos.size() == 0) {
        return maxLen;
    }
    int result = 0;
    for (int pos : zeroPos) {
        int left = pos == 0 ? 0 : arrs[pos - 1];
        int right = getLen(arrs, pos);
        result = Math.max(result, left + right + 1);
    }
    return result;
}
public int getLen (int[] arrs, int pos) {
    int len = 0;
    for (int i = pos + 1; i < arrs.length; i++) {
        if (arrs[i] == 0) {
            break;
        } else {
            len++;
        }
    }
    return len;
}




//O(1) 

public int findMaxConsecutiveOnes(int[] nums) {
    int maxLen = 1;
    int start = 0;
    int index = 0;
    int nextStart = 0;
    boolean findZero = false;

    while (index < nums.length) {
        while (index < nums.length && (nums[index] == 1 || !findZero)) {
            if (nums[index] == 0) {
                findZero = true;
                nextStart = index + 1;
            }
            index++;
        }
        maxLen = Math.max(maxLen, index - start);
        start = nextStart;
        findZero = false;
    }
    return maxLen;
}
