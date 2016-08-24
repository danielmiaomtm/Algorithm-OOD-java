/*
e.g. Between=>b5n,friend=>f4d
Follow-up: implement
Bool checkduplicate(string [] dict, string word)
E.g. {feed }, feed => false;{door }, deer =>true;{dare}, deer => false
如果dict里有word 和input word的abbreviation 一样，则return true注意就是查的词 一定在dict里。
*/

class TrieNode{
    TrieNode[] children;
    int val;
    TrieNode(int val) {
        this.val = val;
        this.children = new TrieNode[36];
    }
}

class myCode {
  public static void main (String[] args) {
        myCode solution = new myCode();
        String[] strs = new String[]{"fiid", "fe", "edt"};
        boolean result = solution.checkduplicate(strs, "f2fd");
        System.out.println(result);
  }
  TrieNode root;
    public boolean  checkduplicate (String[] dict, String word) {
        TrieNode node = new TrieNode(-1);
        root = buildTrieTree (dict, node);
        return find (root, word);
    }
    public boolean find (TrieNode root, String word) {
        String str = abb(word);
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int cur;
            if ('0' <= c && c <= '9') {
                cur = c - '0' + 25;

            } else {
                cur = c - 'a';
            }

            if (root.children[cur] == null) {
                return false;
            } 
            root = root.children[cur];
        }
        return true;
    }
    public TrieNode buildTrieTree (String[] dict, TrieNode node) {
        for (int i = 0; i < dict.length; i++) {
            TrieNode root = node;
            String str = abb(dict[i]);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                int cur;
                if ('0' <= c && c <= '9') {
                    cur = c - '0' + 25;
                } else {
                    cur = c - 'a';
                }
                if (root.children[cur] == null) {
                    root.children[cur] = new TrieNode(c);
                }
                root = root.children[cur];
            }

        }
        return node;
    }

    public String abb(String str) {
        if (str.length() <= 2) {
            return str;
        }
        String result = "";
        result += str.charAt(0);
        result += str.length() - 2;
        result += str.charAt(str.length() - 1);
        return result;
    }

}
