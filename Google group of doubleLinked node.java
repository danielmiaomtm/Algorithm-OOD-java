/*
还有给一个list of double linked list，求连在一起的list 的团数

就是给一个 List<DoubleLinkedNode>
像这样: <-1<-->2<-->3->     <- 4<-->5 ->  <-6->
这样就有3个group的连在一起的node

*/

public int getNumOfNodes (DoubleLinkedNode root, List<DoubleLinkedNode> input) {
		Set<DoubleLinkedNode> set = new HashSet<>();
		while (root != null) {
			set.add(root);
			root = root.right;
		}
		Set<DoubleLinkedNode> inputSet = new HashSet<>();
		for (DoubleLinkedNode node : input) {
			inputSet.add(node);
		}

		int result = 0;
		
			for (DoubleLinkedNode node : input) {
				//left
				if (set.contains(node) && inputSet.contains(node)) {
					result++;
					//left
					DoubleLinkedNode temp = node;
					while (temp.left != null && inputSet.contains(temp.left)) {
						inputSet.remove(temp.left);
						temp = temp.left;
					}
					temp = node;
					while (temp.right != null && inputSet.contains(temp.right)) {
						inputSet.remove(temp.right);
						temp = temp.right;
					}
				}
				
				//right
			}
		
		return result;
	}
