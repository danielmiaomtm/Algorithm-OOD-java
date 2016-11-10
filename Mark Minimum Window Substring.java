/*
Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

*/


public class Solution {
    public String minWindow(String s, String t) {
        int[] tHash = new int[256];
        for (char c : t.toCharArray()) {
            tHash[c]++;
        }
        
        int[] sHash = new int[256];
        int left = 0;
        int min = Integer.MAX_VALUE;
        int count = 0;
        String result = "";
        
        for (int right = 0 ; right < s.length(); right++) {
            char c = s.charAt(right);
            
            if (++sHash[c] <= tHash[c]) {
                count++;
            }
            
            if (count == t.length()) {
                while (left < right && sHash[s.charAt(left)] > tHash[s.charAt(left)]) {
                    sHash[s.charAt(left)]--;
                    left++;
                }
                
                if (right - left + 1 < min) {
                    min = right - left + 1;
                    result = s.substring(left, right + 1);
                }
                
                sHash[s.charAt(left)]--;
                count--;
                left++;
            }
            
        }
        return result;
    }
}
