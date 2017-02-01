/*Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Show Company Tags
Show Tags
Show Similar Problems

*/

public int search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return -1;
    }

    int left = 0;
    int right = nums.length - 1;
    while (left + 1 < right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[left] < nums[mid]) {
            if (nums[left] <= target && target <= nums[mid]) {
                right = mid;
            } else {
                left = mid;
            }
        } else {

            if (nums[mid] <= target && target <= nums[right]) {
                left = mid;
            } else {
                right = mid;
            }
        } 
    }
    if (nums[left] == target) {
        return left;
    }
    if (nums[right] == target) {
        return right;
    }
    return -1;

}


/* if there are duplicates
只需要举出能够最坏情况的数据是 [1,1,1,1... 1] 里有一个0即可。
O(n)情况
*/
// if there are duplicates
public boolean search(int[] nums, int target) {
    if (nums == null || nums.length == 0) {
        return false;
    }
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[left] < nums[mid]) {
            if (target < nums[mid] && target >= nums[left] ) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        } else if (nums[mid] < nums[left]){
            if (target > nums[mid] && target < nums[left]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        } else {
            left++;
        }
    }
    return false;

}
