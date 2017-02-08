    public class Solution {
        public int ladderLength(String start, String end, Set<String> dict) {
            if (start.equals(end)) {
                return 2;
            }

            int length1 = 1;
            int length2 = 1;
            HashSet<String> used1 = new HashSet<String>();
            HashSet<String> used2 = new HashSet<String>();
            used1.add(start);
            used2.add(end);
            Queue<String> q1 = new LinkedList<String>();
            Queue<String> q2 = new LinkedList<String>();
            q1.offer(start);
            q2.offer(end);

            while (!q1.isEmpty() && !q2.isEmpty()) {
                int size1 = q1.size();
                while (size1-- > 0) {
                    String curr = q1.poll();
                    ArrayList<String> trans = transform(curr);
                    for (String s : trans) {
                        if (used2.contains(s)) {
                            return length1 + length2;
                        }
                        if (dict.contains(s) && !used1.contains(s)) {
                            q1.offer(s);
                            used1.add(s);
                        }
                    }
                }
                length1++;

                int size2 = q2.size();
                while (size2-- > 0) {
                    String curr = q2.poll();
                    ArrayList<String> trans = transform(curr);
                    for (String s : trans) {
                        if (used1.contains(s)) {
                            return length1 + length2;
                        }
                        if (dict.contains(s) && !used2.contains(s)) {
                            q2.offer(s);
                            used2.add(s);
                        }
                    }
                }
                length2++;
            }

            return 0;
        }

        private ArrayList<String> transform(String str) {
            ArrayList<String> trans = new ArrayList<String>();
            char[] arr = str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c != str.charAt(i)) {
                        arr[i] = c;
                        trans.add(new String(arr));
                    }
                }
                arr[i] = str.charAt(i);
            }
            return trans;
        }
    }












public void dfs(List<List<String>> res, List<String> cur, Map<String, Integer> distMap, Set<String> wordList, String word, String des) {
        if (word.equals(des)) {
            List<String> list = new ArrayList<String>(cur);
            list.add(des);
            Collections.reverse(list);
            res.add(list);
            return;
        }
        
        cur.add(word);
        for (int i = 0; i < word.length(); i++) {
            char[] chars = word.toCharArray();
            for (char c = 'a'; c <= 'z'; c++) {
                chars[i] = c;
                String nextWord = new String(chars);

                // 不仅字典中含有，两字符串也是要在路径的相邻位置即距离差1
                if (distMap.containsKey(nextWord) && distMap.get(nextWord) == distMap.get(word) - 1) {
                    dfs(res, cur, distMap, wordList, nextWord, des);
                }
            }
        }
        cur.remove(cur.size() - 1);
    }
    
    // 用Word Ladder I的方法把候选字符串及其距离存入map，缩小DFS范围。
    public void getDistance(String beginWord, String endWord, Set<String> wordList, Map<String, Integer> distMap) {
        distMap.put(beginWord, 1);
        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        
        while (!q.isEmpty()) {
            String word = q.remove();
            for (int j = 0; j < word.length(); j++) {
                char[] chars = word.toCharArray();
                for (char c = 'a';  c <= 'z'; c++) {
                    chars[j] = c;
                    String nextWord = new String(chars);
                    if (nextWord.equals(endWord)) {
                        distMap.put(nextWord, distMap.get(word) + 1);
                        return;
                    }
                    if (wordList.contains(nextWord) && !distMap.containsKey(nextWord)) {
                        distMap.put(nextWord, distMap.get(word) + 1);
                        q.add(nextWord);
                    }
                }
            }
        }
    }
}





//用trie优化
struct TrieNode{
    unordered_map<char, TrieNode*> children;
};

class Solution {
public:
    int ladderLength(string beginWord, string endWord, unordered_set<string>& wordList) {
        if(beginWord == endWord) return 2;
        unordered_set<string> visited;
        queue<string> que;
        int len = 1;
        que.push(beginWord);
        visited.insert(beginWord);
        TrieNode *root = buildTrie(wordList);
        
        while(!que.empty()){
            int size = que.size();
            for(int i = 0; i < size; ++i){
                string curWord = que.front();
                que.pop();
                TrieNode *curNode = root;
                for(int j = 0; j < curWord.size(); ++j){
                    char c = curWord[j];
                    if(curNode->children.count(c) == 0) break;
                    for(auto p : curNode->children){
                        char newChar = p.first;
                        if(newChar == c) continue;
                        curWord[j] = newChar;
                        if(curWord == endWord) return len + 1;
                        if(!visited.count(curWord) && wordList.count(curWord)){
                            visited.insert(curWord);
                            que.push(curWord);
                        }
                    }
                    curWord[j] = c;
                    curNode = curNode->children[c];
                }
            }
            ++len;
        }
        
        return 0;
    }
private:
    TrieNode* buildTrie(unordered_set<string> &wordList){
        TrieNode *root = new TrieNode();
        for(string word : wordList){
            TrieNode *cur = root;
            for(char c : word){
                if(cur->children.count(c) == 0){
                    cur->children[c] = new TrieNode();
                }
                cur = cur->children[c];
            }
        }
        
        return root;
    }
};
