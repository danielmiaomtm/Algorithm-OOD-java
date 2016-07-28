    public int findKthLargest (int[] nums, int k) {
        if (nums.length == 0 || nums == null || k < 0) {
            return -1;
        }
        return helper (nums, k - 1, 0, nums.length - 1);
    }
    public int helper (int[] nums, int k, int left, int right) {
        int l = left;
        int r = right;
        
        int mid = l + (r - l) / 2;
        int pivot = nums[mid];
            
        while (left < right) {    
            
            if (nums[l] > pivot) {
                l++;
            } else if (nums[r] < pivot) {
                r--;
            } else {
                if (l <= r) {
                    int temp = nums[l];
                    nums[l] = nums[r];
                    nums[r] = temp;
                    l++;
                    r--;
                }
            }
        }
        
        if (left < r && k <= r) {
            helper (nums, k, left, r);
        }
        if (l < right && l <= k) {
            helper (nums, k, l, right);
        }
        
        return nums[k];
    }
