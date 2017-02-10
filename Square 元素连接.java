import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {  

  
  public static void main(String[] args) {

    Solution sol = new Solution();
    int[] nums = new int[]{1,1,1,3,4,5,4,2,2,4,5};
    // List<Integer> result = sol.searchRnage(nums, -1, 5);
    // System.out.println(Arrays.toString(result.toArray()));
  
    
    // {from , to}
    /*
                A
               / \
              B   C
             / \ / \
            D   E   F
          
    */
    String[][] directory = new String[][]{{"A", "B"},{"A","C"},{"B","D"},{"B","E"}, {"C", "F"}, {"C", "E"}, {"E", "A"}};
    
    //System.out.println(sol.isConnected(directory, new String[]{"F", "D"}));
    System.out.println(sol.hasCycle(directory));
  }
  
  
//判断是否有环
  public boolean hasCycle (String[][] directory) {
    Map<String, List<String>> map = new HashMap<>();
    for (String[] dir : directory) {
      map.putIfAbsent(dir[0], new ArrayList<>());
      map.get(dir[0]).add(dir[1]);
    }
    
    Set<String> visited = new HashSet<>();
    for (String from : map.keySet()) {
      
      System.out.println("from  " + from + "~~~~~~~");
      
      if (helper(map, visited, from)) {
        return true;
      }
      
    }
    return false;
  }
         
  public boolean helper (Map<String, List<String>> map, Set<String> visited, String from) {
    if (!map.containsKey(from) || map.get(from).size() == 0) {
       
        return false;
    }
       
    boolean result = false;
    visited.add(from);
    for (String to : map.get(from)) {
      if (visited.contains(to)) {
          return true;
      }
      visited.add(from);
      
      result |= helper(map, visited, to);
      visited.remove(from);
    }
    
    return result;
      
  }
  
  
  
  //判断两点是否连接
  // input : [from, to]
  public boolean isConnected(String[][] directory, String[] input) {
    Map<String, List<String>> map = new HashMap<>();
    for (String[] dir : directory) {
      map.putIfAbsent(dir[0], new ArrayList<>());
      map.get(dir[0]).add(dir[1]);
    }
    
    return isConnected(input[0], input[1], map);
  }
  public boolean isConnected (String from, String to, Map<String, List<String>> map) {
    if (!map.containsKey(from) || map.get(from).size() == 0) {
        return false;
    }
    List<String> list = map.get(from);
    for (String str : list) {
      if (str.equals(to)) {
          return true;
      }
      if (isConnected(str, to, map)) {
        return true;
      }
    }
    return false;
  }
  
}
