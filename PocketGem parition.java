/*
定义和strStr有关，如果A是B的substr或者B是A的substr，A和B就在同一个result set里

{a,b} -> {{a}, {b}}
{a, ap, beaf, bat} -> {{a , ap, beaf, bat}} ：因为a和ap一起，a和beaf一起，a和bat一起，所以全部一起
{a, aaa, b, bba} -> {{a, aaa, b, bba}} ： 因为a和aaa一起，b和bba一起，bba和a一起，所以全部一起
*/


class Solution {
  public static void main(String[] args) {
    
    Solution sol = new Solution();
    
    List<String> input = new ArrayList<>();
    
    input.add("a");
    input.add("ap");
    input.add("c");
    input.add("b");
    
    List<List<String>> result = sol.groupStr(input);
    
    for (List<String> l : result) {
      System.out.println(Arrays.toString(l.toArray()));
    }
    
  }
    
  public List<List<String>> groupStr (List<String> input) {
    int[] nums = new int[input.size()];
    for (int i = 0; i < nums.length; i++) {
      nums[i] = i;
    }
    
    for (int i = 0; i < input.size(); i++) {
      for (int j = i + 1; j < input.size(); j++) {
        if (isSubStr(input.get(i), input.get(j))) {
            union(nums, i, j);
            // System.out.println(input.get(i) + " + "  + input.get(j));
            // System.out.println(Arrays.toString(nums));
        }
      }
       
    }  
    
    Map<Integer, List<String>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      List<String> list;
      if (!map.containsKey(nums[i])) {
          list = new ArrayList<>();
      } else {
        list = map.get(nums[i]);
      }
      list.add(input.get(i));
      map.put(nums[i], list);
    }
    
    List<List<String>> result = new ArrayList<>();
   
    for (List<String> list : map.values()) {
      result.add(new ArrayList<>(list));
    }
    
    return result;
  
  }
  
  
  public void union (int[] nums, int num1, int num2) {
    int f1 = find(nums, num1);
    int f2 = find(nums, num2);
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] == f1) {
        nums[i] = f2;
      }
    }
  }
  
  public int find (int[] nums, int n) {
    if (nums[n] == n) {
      return n;
    }
    int temp = find(nums, nums[n]);
    nums[n] = temp;
    return temp;
  }
  
  
  //str2 is longer
  public boolean isSubStr (String str1, String str2) {
    if (str1 == null || str2 == null || str1.equals(str2)) {
      return true;
    }
    if (str1.length() > str2.length()) {
      return isSubStr(str2, str1);
    }
    
    for (int i = 0; i <= str2.length() - str1.length(); i++) {
      if (str1.equals(str2.substring(i, i + str1.length()))) {
        return true;
      }
    }
    return false;
  }
  
  
}
