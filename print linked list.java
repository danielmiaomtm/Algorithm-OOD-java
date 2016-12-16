/*
print linkedlist without modifying the tree and with constant space use.
*/


//using pointer 
public void printReverse (TreeNode root, int len) {
		if (len == 0) {
			return;
		}
		while (len > 0) {
			TreeNode node = root;
			int temp = len;
			while (temp > 1) {
				node = node.next;
				temp--;
			}
			System.out.println(node.val);
			len--;
		}
	}

//recusively 

	public void printReverse (TreeNode root) {
		if (root == null) {
			return;
		}
		printReverse(root.next);
		System.out.println(root.val);
		
	}
