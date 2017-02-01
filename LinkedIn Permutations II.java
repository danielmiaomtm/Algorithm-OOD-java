//less Than Time(n!)

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<Integer>();

        Arrays.sort(nums);
        helper(new boolean[nums.length], result, list, nums, 0);
        return result;        
    }
    public void helper(boolean[] visited, List<List<Integer>> result, List<Integer> list, int[] nums, int index) {
        if(index == nums.length) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++) {
            if (visited[i] || (i != 0 && nums[i] == nums[i - 1]) && !visited[i - 1]){
                continue;
            } else {
               
                    visited[i] = true;
                    list.add(nums[i]);
                    
                    helper(visited, result, list, nums, index + 1);
                    
                    list.remove(list.size() - 1);  
                    visited[i] = false;
                    
            }
            
        }
        
    }
}
