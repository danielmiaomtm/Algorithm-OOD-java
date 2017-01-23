/*
Please go to the link and read the explanation
http://www.geeksforgeeks.org/design-a-stack-with-find-middle-operation/

How to implement a stack which will support following operations in O(1) time complexity?
1) push() which adds an element to the top of stack.
2) pop() which removes an element from top of stack.
3) findMiddle() which will return middle element of the stack.
4) deleteMiddle() which will delete the middle element.
Push and pop are standard stack operations.


 input :
 1,2,3,4,5
 output:
 5,4,3,2,1

*/
package LinkedList;

import java.util.List;

class DLLNode {
  DLLNode left;
  DLLNode right;
  int val;
}

public class StackToFindMiddle {

        DLLNode head;
        DLLNode middle;
        int size = 0;
        public void push(int val) {
                size++;
                if(head == null) {
                        head = new DLLNode(val);
                        middle = head;
                }else {
                        DLLNode node = new DLLNode(val);
                        node.right = head;
                        head.left = node;
                        head=node;
                        // if even, middle should move to left
                        if(size % 2 == 0) {
                                middle = middle.left;
                        }
                }
        }

        public int pop() {
                if(head == null) {
                        return -1;
                }
                size--;
                int result = head.val;
                // there is only one elelment, reset the head and middle
                if(size == 0) {
                        head = null;
                        middle = null;
                } else {
                        head = head.right;
                        head.left = null;
                        if(size % 2 == 1) {
                                middle = middle.right;
                        }
                }
                return result;
        }

        public int findMiddle() {
                return middle.val;
        }


        public void deleteMiddle() {
                size--;
                if(middle.left != null) {
                        middle.left.right=middle.right;
                }
                if(middle.right != null) {
                        middle.right.left=middle.left;
                }
                if(size%2 == 1) {
                        middle=middle.right;
                }else {
                        middle=middle.left;
                }
        }
}
