// add one of linkedlist without modify the list and use o(n) time and O(1) space.

//idea: find the last val less than 9, then just update the val from the first node, two scan of list;


  public ListNode addOne (ListNode head) {
		if (head == null) {
			return null;
		}
		//find the last one less than 9
		ListNode dummy = new ListNode(1);
		dummy.next = head;
		ListNode node = dummy.next;
		ListNode first = null, second = null;
		while (node.next != null) {
			if (node.val < 9) {
				first = node;
			}
			node = node.next;
		}

		if (node.val < 9) {
			node.val = node.val + 1;
			return dummy.next;
		} else {
			//999
			if (first == null) {
				node = dummy.next;
				while (node != null) {
					node.val = 0;
					node = node.next;
				}
				return dummy;
			//789	
			}else {
				node = first;
				while (node != null) {
					if (node == first) {
						node.val = node.val + 1;
					} else {
						node.val = 0;
					}				
					node = node.next;
				}
			}
		}

		return dummy.next;
	}
