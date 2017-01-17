/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5
*/

public ListNode reverseKGroup(ListNode head, int k){
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next= head;
        ListNode start = dummy;
        ListNode next = dummy;
        ListNode cur = dummy;
        int i = 1;
        while(cur != null) {
            if (i % k == 0) {
                start = helper (start, cur.next);
                cur = start.next;
            } else {
                cur = cur.next;
            }
            i++;
        }

        return dummy.next;
        }
        public ListNode void helper (TreeNode start, TreeNode end) {
        TreeNode cur = start.next;
        TreeNode next = cur.next;
        while (end != next) {
            cur.next = next.next;
            next.next = start.next;
            start.next = next;
            next = cur.next;
        }
        return cur;
}
