
// query many times 重复请求很多次
public class WordDistance {
    private Map<String, List<Integer>> map;
    // store all the pos to map
    public WordDistance(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for(int i = 0; i < words.length; i++) {
            List<Integer> list;
            if(map.containsKey(words[i])) {
                list = map.get(words[i]);
            } else {
                list = new ArrayList<Integer>();
            }
            list.add(i);    
            map.put(words[i], list);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int ret = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < list1.size() && j < list2.size()) {
            int index1 = list1.get(i), index2 = list2.get(j);
            ret = Math.min(ret, Math.abs(index1 - index2));
            
            if(index1 < index2) {
                i++;
            } else {
                j++;
            }
            
        }
        return ret;
    }
}


// if not same two words， 两个词不一样
public class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        if (words == null || words.length < 2) {
            return 0;
        }
        int left = -1, right = -1;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (word1.equals(words[i])) {
                left = i;
            } else if (word2.equals(words[i])) {
                right = i;
            } 
            if (left != -1 && right != -1) {
                minLen = Math.min(minLen, Math.abs(left - right));
            }
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}


// if two words could be same， 两个词可以一样
public int shortestWordDistance(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) {
            return 0;
        }
        boolean isSame = word1.equals(word2);
        
        int pre = -1;
        int minLen = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (isSame) {
                    if (pre >= 0) {
                        minLen = Math.min(minLen, i - pre);
                    }
                    pre = i;
                } else {
                    if (pre >= 0 && !words[i].equals(words[pre])) {
                        minLen = Math.min(minLen, i - pre);
                    }
                    pre = i;
                }
            }
        }
        return minLen;   
    }


public int shortestWordDistance(String[] words, String word1, String word2) {
        int idx1 = -1, idx2 = -1, distance = Integer.MAX_VALUE, turn = 0, inc = (word1.equals(word2) ? 1 : 0);
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1) && turn % 2 == 0){
                idx1 = i;
                if(idx2 != -1) distance = Math.min(distance, idx1 - idx2);
                turn += inc;
            } else if(words[i].equals(word2)){
                idx2 = i;
                if(idx1 != -1) distance = Math.min(distance, idx2 - idx1);
                turn += inc;
            }
        }
        return distance;
    }
