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
    
    
    public class Solution {
    
    public List<String> res = new LinkedList<String>();
    
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> dp[] = new ArrayList[s.length()+1];
        dp[0] = new ArrayList<String>();
        for(int i = 0; i < s.length(); i++){
            // 只在单词的后一个字母开始寻找，否则跳过
            if(dp[i]==null) continue;
            // 看从当前字母开始能组成哪个在字典里的词
            for(String word : wordDict){
                int len = word.length();
                if(i + len > s.length()) continue;
                String sub = s.substring(i, i+len);
                if(word.equals(sub)){
                    if(dp[i + len] == null){
                        dp[i + len] = new ArrayList<String>();
                    }
                    dp[i + len].add(word);
                }
            }
        }
        // 如果数组末尾不存在单词，说明找不到分解方法
        if(dp[s.length()]!=null) backTrack(dp, s.length(), new ArrayList<String>());
        return res;
    }
    
    private void backTrack(List<String> dp[], int end, ArrayList<String> tmp){
        if(end <= 0){
            String path = tmp.get(tmp.size()-1);
            for(int i = tmp.size() - 2; i >= 0; i--){
                path += " " + tmp.get(i);
            }
            res.add(path);
            return;
        }
        for(String word : dp[end]){
            tmp.add(word);
            backTrack(dp, end - word.length(), tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
