public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums.length < k) {
            return -1;
        }
        return helper(k - 1, nums, 0, nums.length - 1);
        
    }
    public int helper (int k, int[] nums, int left, int right) {
        int orgL = left;
        int orgR = right;
        int pivot = nums[left + (right - left) / 2];

        while (left <= right) {
            if (nums[left] > pivot) {
                left++;
            } else if (nums[right] < pivot) {
                right--;
            } else {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
                right--;
            }
        }
        
        if (orgL < right && k <= right) {
            helper(k, nums, orgL, right);
        } else if (left < orgR && left <= k) {
            helper(k, nums, left, orgR);
        } 
        return nums[k];
        
        
    }
