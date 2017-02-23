public void swap (Node node) {
	Node head = node;
	Node large = null, small = null;
	while (head != null) {
		if (large == null && small == null) {
			large = head;
		} else {

			if (head.val >= large.val) {
				small = large;
				large = head;
			} else {
				if (small == null) {
					small = head;
				} else {
					if (small.val < head.val) {
						small = head;
					}
				}
				
			}
		}
		head = head.next;
	}

	if (large == null || small == null) {
		return;
	}

	
	
	
	Node t1 = null, t2 = null, pre1 = null, pre2 = null;
	Node dummy = new Node(0);
	dummy.next = node;
	head = dummy;
	while (head.next != null) {
		if (head.next == large || head.next == small) {
			if (t1 == null) {
				pre1 = head;
				t1 = head.next;
			} else if (t2 == null) {
				pre2 = head;
				t2 = head.next;
			} else {
				break;
			}
		}
		head = head.next;
	}
	
	if (t1.next == t2) {
		pre1.next = t2;
		t1.next = t2.next;
		t2.next = t1;
	} else {
		pre1.next = t2;
		Node temp = t2.next;
		t2.next = t1.next;
		pre2.next = t1;
		t1.next = temp;
	}
	
	node = dummy.next;
	
}
