public ListNode merge(List<ListNode> listOfLists) {
        
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;
        PriorityQueue<ListNode> heap = new PriorityQueue<>(11, new Comparator<ListNode>({
            public int compare (ListNoe l1, ListNode l2) {
                return l1.val - l2.val;
            }
        }));
        
        for (ListNode node : listOfLists) {
            if (node != null) {
                heap.offer(node);
            }
        }
        
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            if (min.next != null) {
                heap.offer(min.next);
            }
            result.next = min;
        }

        return dummy.next;
    }
