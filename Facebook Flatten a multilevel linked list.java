/*
input:
    1 -> 2 -> 3 -> 4
    |         |
    5 ->7     9
              |
              10
              
 output:
 
    1 -> 2 -> 3 -> 4 -> 5 -> 9 -> 10             
*/





void flattenList(Node node) {

    /*Base case*/
    if (node == null) {
        return;
    }

    Node tmp = null;

    /* Find tail node of first level linked list */
    Node tail = node;
    while (tail.next != null) {
        tail = tail.next;
    }

    // One by one traverse through all nodes of first level
    // linked list till we reach the tail node
    Node cur = node;
    while (cur != tail) {

        // If current node has a child
        if (cur.child != null) {

            // then append the child at the end of current list
            tail.next = cur.child;

            // and update the tail to new last node
            tmp = cur.child;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tail = tmp;
        }

        // Change current node
        cur = cur.next;
    }
}
