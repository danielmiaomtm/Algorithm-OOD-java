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
	DLLNode (int val) {
		this.val = val;
		this.pre = null
		this.next = null;
	}
}

class maxStack {
	DDLNode head;
	PriorityQueue<DDLNode> heap;
	maxStack () {
		this.head = null;
		this.heap = new PriorityQueue<>(11,new Comparator<DLLNode> () {
		@Override
		public int compare (DLLNode n1, DLLNode n2) {
//			if (n1.val == n2.val) {
//				// index decending
//				return n2.index - n1.index;
//			}
			// decending
			return n2.val - n1.val;
		}
	});
	}
	public void insert (int num) {
		if (head == null) {
			head = new DLLNode(num);
		} else {
			DLLNode node = new DLLNode(num);
			head.next = node;
			node.pre = head;
			head = node;
		}
		heap.offer(head);
	}

	public int peekMax () {
		if (head == null) {
			return -1;
		}
		return heap.peek().val;
	}
	public int popMax () {
		if (head == null) {
			return -1;
		}
		DLLNode max = heap.peek();
		if (heap.isEmpty()) {
			head = null;
			return max.val;
		}
		// if there is only one node
		if (heap.peek().next == null && heap.peek().pre == null) {
			head = null;
		} else if (heap.peek().next == null) {
			// max in the tail
			heap.peek().pre.next = null;
			head = heap.peek().pre;
		} else if (heap.peek().pre == null) {
			// max in the head
			heap.peek().next.pre = null;
		} else {
			heap.peek().pre.next = heap.peek().next;
			heap.peek().next.pre = heap.peek().pre;			
		}
		heap.poll();
		
		return max.val;
	}
	
	public int pop() {
		if (head == null) {
			return -1;
		}
		int result = head.val;
		DLLNode node = head.pre;

		heap.remove(head);

		if (node == null) {
			head = null;
			return result;
		}
		head = node;
		head.next = null;
		return result;
	}

}

