/*
Find the length of the longest substring T of a given string (consists of lowercase letters only) such that every character 
in T appears no less than k times.

Example 1:

Input:
s = "aaabb", k = 3

Output:
3

The longest substring is "aaa", as 'a' is repeated 3 times.
Example 2:

Input:
s = "ababbc", k = 2

Output:
5

The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/


  public int longestSubstring(String s, int k) {
        int n = s.length();
        if(n < k) {
          return 0;
        }
        int counter[] = new int[26];
        boolean valid[] = new boolean[26];
        char ss[] = s.toCharArray();
        //统计每个字符的长度
        for(int i = 0; i < n; i++) { 
            counter[ss[i] - 'a']++;
        }
        //检查当前字符串是否是完全满足的
        boolean fullValid = true;
        //判断每个字符的出现条件是否合适，即，要么不出现，要么出现了不少于k
        for(int i = 0; i < 26; i++){
            if(counter[i] > 0 && counter[i] < k){
                valid[i] = false;
                fullValid = false;
            } else {
                valid[i] = true;
            }
        }
        if(fullValid) {
          return s.length();
        }
        int max = 0;
        int lastStart=0;
        //把不符合要求的断开，然后依次检查 取最大
        for(int i = 0; i < n; i++){
            if(!valid[ss[i] - 'a']){
                max = Math.max(max, longestSubstring(s.substring(lastStart, i), k));
                lastStart = i + 1;
            }
        }
        max = Math.max(max,longestSubstring(s.substring(lastStart, n), k));
        return max;
    }
