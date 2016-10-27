/*
LCphone number combination那道题的变种，因为还有一个dictionary，只返回在dictionary里的words
*/



class TrieNode {
	TrieNode[] children;
	int val;
	String word;
	TrieNode (int val) {
		this.word = "";
		this.val = val;
		this.children = new TrieNode[26];
	}
}
String[] map = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
public List<String> letterCombinations (String digits, HashSet<String> words) {
	List<String> result = new ArrayList<>();
	if (digits == null || digits.length() == 0) {
		return result;
	}
	TrieNode root = new TrieNode();
	for (String word : words) {
		addWord(word, root);
	}
	buildTrie (root);

	Queue<String> q = new LinkedList<>;
	Queue<TrieNode> qT = new LinkedList<>();
	q.offer("");

	for (int i = 0; i < digits.length(); i++) {
		char c = digits.charAt(i);
		int size = q.size();
		for (int i = 0; i < size; i++) {
			String curStr = q.poll();
			TrieNode curTrie = qT.poll();
			for (int j = 0; j < map[c - '0'].length(); j++) {
				int index = map[c - '0'].charAt(j) - 'a';
				if (curTrie.children[index] != null) {
					qT.offer(curTrie.children[index]);
					q.offer(temp + map[c - '0'].charAt(j));
				}
			}
		}
	}
	while (q.size() > 0) {
		word.add(q.poll());
	}
	return word;
}
public void buildTrie (String word, TrieNode root) {
	for (char c : word.toCharArray()) {
		if (root.children[c - '0'] == null) {
			root.children[c - '0'] = new TrieNode();
		}
		root = root.children[c - '0'];
	}
	root.word = word;
}
