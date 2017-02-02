public class WordDictionary {
    
    public class TrieNode {
        boolean isWord;
        TrieNode[] children;
        TrieNode() {
            this.isWord = false;
            this.children = new TrieNode[26];
        }
    }
    // Adds a word into the data structure.
    TrieNode root = new TrieNode();
    
    public void addWord(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.children[index] == null) {
                node.children[index] = new TrieNode();
                node.children[index].isWord = false;   
            }
            node = node.children[index];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode node = root;
        return helper (word, 0, node);
    }
    
    public boolean helper (String word, int index, TrieNode node) {
        if (index >= word.length())
            return node.isWord;
        char c = word.charAt(index);
        if (c == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && helper(word, index + 1, node.children[i]))
                    return true;
            } 
            return false;
        } else {
            return (node.children[c - 'a'] != null && helper(word, index + 1, node.children[c - 'a'])); 
        }
 
    }
}
