class IntersectionOfList {
    public ListNode intersection(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cycle1 = detectCycle(head1);
        ListNode cycle2 = detectCycle(head2);
        // one has cycle but another one does not, then no intersection
        if ((cycle1 == null && cycle2 != null) || (cycle1 != null && cycle2 == null)) {
            return null;
        }
        // if both no cirlce, then cycle is null and we check the length to the end
        // else we check the length before circle start point
        int len1 = checkLength(head1, cycle1);
        int len2 = checkLength(head2, cycle2);
        // check if before circle start point there is intersection
        while (len1 > len2) {
            head1 = head1.next;
            len1--;
        }
        while (len2 > len1) {
            head2 = head2.next;
            len2--;
        }
        for (int i = 0; i < len1; i++) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        // if both no circle, then no intersection for now
        if (cycle1 == null && cycle2 == null) {
            return null;
        }
        // check if the intersection is in the circle
        if (cycle1 == cycle2) {
            return cycle1;
        }
        ListNode mover = cycle1.next;
        while (mover != cycle1) {
            if (mover == cycle2) {
                return mover;
            }
            mover = mover.next;
        }
        return null;

    }

    private int checkLength(ListNode head, ListNode end) {
        int len = 0;
        while (head != end) {
            head = head.next;
            len++;
        }
        return len;
    }

// when fast and slow meet in the circle
// the distance of head to the begin of cirle is A,
// the meet point to the begin of the cirle is B,
// N means the length of the cirle, we have A + B + N(slow take) = 2A + 2B(fast take)
// thus N = A + B, so the slow will take A steps to reach the begin of cirle again
// we can use another mover from head to move one step each time, so they will meet at the begin of the cirle
    private ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slower = head;
                while (slow != slower) {
                    slow = slow.next;
                    slower = slower.next;
                }
                return slow;
            }
        }
        return null;
    }
}
