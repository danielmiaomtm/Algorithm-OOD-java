/*
 pattern中有star，每个star能且只能匹配一个字母。给定一个字典，找出所有match的words. 
 比如给定字典{”ABC“，”ACD“， “AE”， “ATC”} pattern是”A*C"，那么返回“ABC” 和“ATC”，分析了trie和brute force的效率。
*/

class TrieNode {
    TrieNode[] next;
    String word;
    int val;
    TrieNode(int val) {
        this.val = val;
        this.next = new TrieNode[26];
    }
}

public class Solution {
    
    public static void main(String[] args) {
      practise sol = new Solution();

      String[] words = new String[]{"abc","acd","ae","atc", "a"};
    
      List<String> list = sol.findWords("***", words);

      System.out.println(Arrays.toString(list.toArray()));
    }
    
    public List<String> findWords(String str, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        dfs(res, str, 0, root);
        return res;
    }
    
    public void dfs(List<String> result, String str, int index, TrieNode root) {
    	
        if (index == str.length()&& root.word != null) {
          result.add(new String(root.word));
          return;
        } else if (index >= str.length() || root == null) {
        	return;
        }
        
        char c = str.charAt(index);
        
        if (c == '*') {
          for (int i = 0; i < 26; i++) {
        	  if (root.next[i] != null) {
        		  dfs(result, str, index + 1, root.next[i]);
        	  }
          }
        } else {
          if (root.next[c - 'a'] != null) {
            dfs(result, str, index + 1, root.next[c - 'a']);
          }
        }
        
    }
    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode(-1);
        for(String w : words) {
            TrieNode p = root;
            for(char c : w.toCharArray()) {
                int i = c - 'a';
                if(p.next[i] == null) {
                    p.next[i] = new TrieNode(i);
                }
                p = p.next[i];
           }
           p.word = w;
        }
        return root;
    }
}
