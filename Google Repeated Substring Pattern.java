/*
Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. 
You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.

Example 1:
Input: "abab"

Output: True

Explanation: It's the substring "ab" twice.
Example 2:
Input: "aba"

Output: False
Example 3:
Input: "abcabcabcabc"

Output: True

Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
*/


public boolean repeatedSubstringPattern(String str) {
  if (str.length() <= 1) {
    return false;
    }
    int len = str.length();
      for (int i = len / 2; i >= 1; i--) {
        if (len % i == 0) {
          String subStr = str.substring(0, i);
          int j;
          for (j = 1; j < len / i; j++) {
            String cur = str.substring(subStr.length() * j, subStr.length() * (j + 1));
                    if (!subStr.equals(cur)) {
                      break;
                    }
                }
                if (j == len / i) {
                  return true;
                }
            }
    }
    return false;
}
