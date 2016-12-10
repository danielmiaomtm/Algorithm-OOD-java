/*
There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you.
You receive a list of words from the dictionary, where words are sorted lexicographically by the rules of this new language. 
Derive the order of letters in this language.

For example,
Given the following words in dictionary,

[
  "wrt",
  "wrf",
  "er",
  "ett",
  "rftt"
]
The correct order is: "wertf".

[
"wrtf",
"wrt"
]
return "" because the first one has more chars than second one
*/

public class Solution {
    public String alienOrder(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
        Map<Character, Integer> indegree = new HashMap<Character, Integer>();
        StringBuilder order = new StringBuilder();
        for(String word : words){
            for(char c : word.toCharArray()){
                graph.put(c, new HashSet<Character>());
                indegree.put(c, 0);
            }
        }
        
        Set<String> edges = new HashSet<String>();
        for(int i = 0; i < words.length - 1; i++){
        
            String word1 = words[i];
            String word2 = words[i + 1];
            for(int j = 0; j < word1.length() && j < word2.length(); j++){
                char from = word1.charAt(j);
                char to = word2.charAt(j);
                
                if(from == to) {
                    if(j + 1 <= word1.length() - 1 && j + 1 > word2.length() - 1) return "";
                    else continue;
                }
                // 如果这两个字母构成的边还没有使用过，则
                if(!edges.contains(from + "" + to)){
                    Set<Character> set = graph.get(from);
                    set.add(to);
                    graph.put(from, set);
                    indegree.put(to, indegree.get(to) + 1);
                    // 记录这条边已经处理过了
                    edges.add(from + "" + to);
                } 
                break;
                
            }
        }
        // 拓扑排序的最后一步，根据计数器值广度优先搜索
        Queue<Character> queue = new LinkedList<Character>();
        // 将有向图的根，即计数器为0的节点加入队列中
        for(Character key : indegree.keySet()){
            if(indegree.get(key) == 0){
                queue.offer(key);
            }
        }
        // 搜索
        while(!queue.isEmpty()){
            Character curr = queue.poll();
            // 将队头节点加入结果中
            order.append(curr);
            Set<Character> set = graph.get(curr);
            if(set != null){
                // 对所有该节点指向的节点，更新其计数器，-1
                for(Character c : set){
                    Integer val = indegree.get(c);
                    val--;
                    // 如果计数器归零，则加入队列中待处理
                    if(val == 0){
                        queue.offer(c);
                    }
                    indegree.put(c, val);
                }
            }
        }
        // 如果大小相等说明无环
        return order.length() == indegree.size() ? order.toString() : "";
    }
}
