/*
popMax if duplicates, pop nearest one from top
1,4,2,3,5,4,3  
popMax 
1,4,2,3,4,3
popMax
1,4,2,3,3
popMax
1,2,3,3

*/

class DLLNode{
	DLLNode pre;
	DLLNode next;
	int val;
	int index;
	DLLNode (int val, int index) {
		this.val = val;
		this.pre = null
		this.next = null;
		this.index = index;
	}
}

class maxStack {
	DDLNode head;
	int index;
	PriorityQueue<DDLNode> heap;
	maxStack () {
		this.index = 0;
		this.head = null;
		this.heap = new PriorityQueue<>(new Comparator<DLLNode> () {
			public int compare (DDLNode n1, DDLNode n2) {
				if (n1.val == n2.val) {
					// index decending
					return n2.index - n1.index;
				}
				// decending
				return n2.val - n1.val;
			}
		});
	}
	public void insert (int num) {
		if (head == null) {
			head = new DDLNode(num, index);
		} else {
			DDLNode node = new DDLNode(num, index);
			head.next = node;
			node.pre = head;
			head = node;
		}
		index++;
		heap.offer(head);
	}

	public int peekMax () {
		if (head == null) {
			return -1;
		}
	}
	public int popMax () {
		if (head == null) {
			return -1;
		}
		DDLNode max = heap.poll();
		index--;
		if (heap.isEmpty()) {
			head = null;
			return max.val;
		}
		max.pre.next = max.next;
		max.next.pre = max.pre;

	}
	public int pop() {
		if (head == null) {
			return -1;
		}
		int result = head.val;
		DDLNode node = head.pre;

		heap.remove(head);
		index--;

		if (node == null) {
			head = null;
			return result;
		}
		head = node;
		head.next = null;
		return result;
	}
}

