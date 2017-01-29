//valid word square
public boolean validWordSquare(List<String> words) {
    if (words == null || words.size() == 0) {
        return true;
    }
    int rowNum = words.size();
    for (int i = 0; i < words.size(); i++) {
        for (int j = 0; j < words.get(i).length(); j++) {
            if (j >= rowNum || words.get(j).length() <= i || words.get(j).charAt(i) != words.get(i).charAt(j)) {
                return false;
            }
        }
    }
    return true;
}






/*
For example, the word sequence ["ball","area","lead","lady"] forms a word square because each word reads the same both horizontally 
and vertically.

b a l l
a r e a
l e a d
l a d y
*/


public class Solution {
    public class TrieNode {
        TrieNode[] children;
        String word;
        TrieNode () {
            this.children = new TrieNode[26];
            this.word = "";
        }
    }
    public List<List<String>> wordSquares(String[] words) {
        List<List<String>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }
        TrieNode root = new TrieNode();
        addWord (root, words);
        
        int colNum = words[0].length();
        TrieNode[] rows = new TrieNode[colNum];
        for (int i = 0; i < colNum; i++) {
            rows[i] = root;
        }
        helper(0, 0, colNum, rows, result);
        return result;
    }
    public void helper (int row, int col, int len, TrieNode[] rows, List<List<String>> result) {
        // last char, add into result
        if ((col == row) && (row == len)) {
            List<String> list = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                list.add(new String(rows[i].word));
            }
            result.add(new ArrayList<>(list));
        } else {
            //from left to right, and then go down to the next row
            if (col < len) {
                // left to right first
                TrieNode pre_row = rows[row];
                TrieNode pre_col = rows[col];
                for (int i = 0; i < 26; i++) {
                    //find all the possible next char
                    if ((rows[row].children[i] != null) && (rows[col].children[i] != null)) {
                        rows[row] = rows[row].children[i];
                        if (col != row) {
                            rows[col] = rows[col].children[i];
                        }
                        helper(row, col + 1, len, rows, result);
                        rows[row] = pre_row;
                        if (col != row) {
                            rows[col] = pre_col;
                        }
                    }
                }
            } else {
                //reach the end of col, go to the next row
                helper(row + 1, row + 1, len, rows, result);
            }
        }
        
    }
    public void addWord (TrieNode root, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }    
                node = node.children[c - 'a'];
            }
            node.word += word;
        }
    }
}
