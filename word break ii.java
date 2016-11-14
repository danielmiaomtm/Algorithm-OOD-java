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
                int start = Math.max(0, i - maxWord);
                for (int j = start; j < i; j++) {
                    if (dp[j] && wordDict.contains(s.substring(j, i))) {
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
        ArrayList<String> [] pos = new ArrayList[s.length()+1];
        pos[0]=new ArrayList<String>();
        int maxLen = 0;
        for (String word : wordDict) {
            if (word.length() > maxLen) {
                maxLen = word.length();
            }
        }
        for(int i=0; i<s.length(); i++){
            if(pos[i]!=null){
                for(int j=i+1; j<=s.length() && i + maxLen >= j; j++){
                    String sub = s.substring(i,j);
                    if(wordDict.contains(sub)){
                        if(pos[j]==null){
                            ArrayList<String> list = new ArrayList<String>();
                            list.add(sub);
                            pos[j]=list;
                        }else{
                            pos[j].add(sub);
                        }

                    }
                }
            }
        }

        if(pos[s.length()]==null){
            return new ArrayList<String>();
        }else{
            ArrayList<String> result = new ArrayList<String>();
            dfs(pos, result, "", s.length());
            return result;
        }
    }

    public void dfs(ArrayList<String> [] pos, ArrayList<String> result, String curr, int i){
        if(i==0){
            result.add(curr.trim());
            return;
        }

        for(String s: pos[i]){
            String combined = s + " "+ curr;
            dfs(pos, result, combined, i-s.length());
        }

    }
