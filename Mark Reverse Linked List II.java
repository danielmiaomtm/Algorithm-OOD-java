/*
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
*/


  public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 1; i < m ;i++) {
            pre = pre.next;
        }
        ListNode first = pre.next;
        
        ListNode curNode = first; 
        ListNode next = first.next;
       
        for (int i = m; i < n; i++) {
            ListNode temp = next.next;
            next.next = curNode;
            curNode = next;
            next = temp;
        }
        
        pre.next = curNode;
        first.next = next;
        
        return dummy.next;
    }
