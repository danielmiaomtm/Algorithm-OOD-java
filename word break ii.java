/*
Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one 
or more dictionary words.

For example, given
s = "leetcode",
dict = ["leet", "code"].

Return true because "leetcode" can be segmented as "leet code".
*/

    public class Solution {
        public boolean wordBreak(String s, Set<String> wordDict) {
            int maxWord = getMax(wordDict);
            int len = s.length();
            boolean[] dp = new boolean[len + 1];
            dp[0] = true;
            for (int i = 1; i <= len; i ++) {
                int start = Math.max(1, i - maxWord);
                for (int j = start; j <= i; j++) {
                    if (dp[j - 1] && wordDict.contains(s.substring(j - 1, i))) {
                        dp[i] = true; 
                        break;
                    }
                }
            }
            return dp[len];
        }

        private int getMax(Set<String> wordDict) {
            int max = 0;
            for (String str : wordDict) {
                max = Math.max(max, str.length());
            }
            return max;
        }
    }

/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/    
    
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        HashMap<String, List<String>> map = new HashMap<>();
        return helper (s, wordDict, map);
    }
    public List<String> helper (String s, Set<String> wordDict, HashMap<String, List<String>> map) {
        if (map.containsKey(s)) {
            return map.get(s);
        }
        List<String> result = new ArrayList<>();
        if (s.length() <= 0) {
            return result;
        }
        
        
        for (int i = 1; i <= s.length(); i++) {
            String subFix = s.substring(0, i);
            if (wordDict.contains(subFix)) {
                if (i == s.length()) {
                    result.add(subFix);
                } else {
                    String preFix = s.substring(i);
                    List<String> temp = helper (preFix, wordDict, map);
                    for (String str : temp) {
                        str = subFix + " " + str;
                        result.add(str);
                    }
                }
            }
        }
        map.put(s, result);
        return result;
    }
