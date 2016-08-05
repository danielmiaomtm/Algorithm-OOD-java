public String alienOrder(String[] words) {
	Map<Character, Set<Character>> graph = new HashMap<>();
	Map<Character, Integer> indegree = new HashMap<>();
	
	StringBuilder sb = new StringBuilder();
	
	init(words, graph, indegree);
	buildGraph(words, graph, indegree);
	topologicalSort(sb, graph, indegree);
	
	return sb.length() == indegree.size() ? sb.toString() : "";
}
public void init(String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {
	for (String word : words) {
		for (int i = 0; i < word.length(); i++) {
			char cur = word.charAt(i);
			if (graph.get(cur) == null) {
				graph.put(cur, new HashSet<Character>());
			}
			if (indegree.get(cur) == null) {
				indegree.put(cur, 0);
			}
		}
	}
}

public void buildGraph (String[] words, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree) {

	Set<String> edges = new HashSet<>();

	for(int i = 0; i < words.length - 1; i++) {
		String word1 = words[i];
		String word2 = words[i + 1];

		for (int j = 0; j < words1.length() && j < word2.length(); j++) {
			char from = word1.charAt(i);	
			char to = word2.charAt(j);
			if (from == to) {
				continue;
			} 

			if (!edges.contains(from + "" + to) {
				Set<Character> set = graph.get(from);
				set.add(to);
				graph.put(from, set);
				Integer toIn = indegree.get(to);
				toIn++;
				indegree.put(to, toIn);
				edges.add(from + "" + to);
				break;
			}

		}

	}
}

private void topologicalSort(StringBuilder sb, Map<Character, Set<Character>> graph, Map<Character, Integer> indegree){
	Queue<Character> queue = new LinkedList<.();
	for (Character c : indegree.keySet()) {
		if (indegree.get(c) == 0) {
			queue.offer(c);
		}
	}

	while (!queue.isEmpty()) {
		Character cur = queue.poll();
		sb.append(cur);
		Set<Character> set = graph.get(cur);
		if (set != null) {
			for (Character c : set) {
				Integer val = indegree.get(c);
				val--;
				if (val == 0) {
					queue.offer(c);
				}
				indegree.put(c, val);
			}
		}
	}
