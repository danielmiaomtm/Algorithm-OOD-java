public static void main(String[] args) {

    Solution sol = new Solution();
    int[] nums = new int[]{1,1,1,3,4,5,4,2,2,4,5};
    List<Integer> result = sol.searchRnage(nums, -1, 5);
    System.out.println(Arrays.toString(result.toArray()));
  
  }
  public List<Integer> searchRnage (int[] nums, int start, int end) {
    Arrays.sort(nums);
    
    int left = binarySearch(nums, start, true);
    int right = binarySearch(nums, end, false);
    
    List<Integer> result = new ArrayList<>();
    
    left = left == -1 ? 0 : left;
    right = right == -1 ? nums.length - 1 : right;
    
    for (int i = left; i <= right; i++) {
          result.add(nums[i]);
    }
    
    return result;
  }
  public int binarySearch (int[] nums, int target, boolean left) {
    int start = 0, end = nums.length - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (nums[mid] < target) {
        start = mid;
      } else if (nums[mid] > target) {
        end = mid;
      } else {
        if (left) {
          end = mid;
        } else {
          start = mid;
        }
      }
    }
    
    if (left) {
      if (nums[start] == target) {
        return start;
      } 
      if (nums[end] == start){
        return end;
      }
    } else {
      if (nums[end] == target) {
        return end;
      }
      if (nums[start] == target) {
        return start;
      }
    }
    return -1;
  }
  
