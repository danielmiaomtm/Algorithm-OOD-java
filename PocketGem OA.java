	
		public String[] find_words(String[] boggle_board, String list_path) {
			List<String> list = new ArrayList<>();
			String thisLine = null;
			try {
				BufferedReader br = new BufferedReader(new FileReader(list_path));
				while ((thisLine = br.readLine()) != null) {
					list.add(thisLine);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
			TrieNode root = new TrieNode();
			// store all the words into trie tree
			buildTrie(root, list);
			
			List<String> temp = new ArrayList<>();
			for (int i = 0; i < boggle_board.length; i++) {
				for (int j = 0; j < boggle_board[0].length(); j++) {
					helper(root, i, j, boggle_board, temp);
				}
			}
			Collections.sort(temp, new Comparator<String>() {
				public int compare (String str1, String str2) {
					return str1.compareTo(str2);
				}
			});
			String[] result = new String[temp.size()];
			
			return temp.toArray(result);
		}
		
		public void helper (TrieNode root, int row, int col, String[] boggle_board, List<String> temp) {
			int[][] dirs = new int[][]{{0, 0}, {0, 1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, -1}, {-1, 1}};
			TrieNode node = root;
			char c = boggle_board[row].charAt(col);
			if (node.children[c - '\0'] == null) {
				return;
			}
			node = node.children[c - '\0'];
			if (node.word != null) {
				temp.add(node.word);
				node.word = null;
			}
			for (int i = 0; i < dirs.length; i++) {
				int x = row + dirs[i][0];
				int y = col + dirs[i][1];
				if (x >= 0 && x < boggle_board.length && y >= 0 && y < boggle_board[0].length()) {
					helper(node, x, y, boggle_board, temp);
				}
			}
			
		}
		
		public void buildTrie (TrieNode root, List<String> list) {
			
			for (String word : list) {
				TrieNode node = root;
				for (char c : word.toCharArray()) {
					if (node.children[c - '\0'] == null) {
						node.children[c - '\0'] = new TrieNode();
					}
					node = node.children[c - '\0'];
				}
				node.word = word;
			}
			
		}
	
