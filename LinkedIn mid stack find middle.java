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

//我的方法
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
public midStack {
	DLLNode head;
	DLLNode middle;
	int size;
	midStack () {
		this.head = null;
		this.middle = null;
		this.size == 0
	}
 
 
	public void insert (int target) {
		if (head == null) {
			head = new DLLNode(target);
			middle = head;
		} else {
			DLLNode node = new DLLNode(target);
			head.next = node;
			node.pre = head;
			head = node;
			// when size is odd, middle shift to next
			if (size % 2 == 0) {
				middle = middle.next;
			}
   			size++;
		}
	}
	
 
public int pop () {
     if (head == null) {
      return -1;
     }
     int result = head.val;
     DLLNode pre = head.pre;
     //only one node exists
     if (pre == null) {
      head = null;
      middle = null;
      return result;
     } 
     // when size is odd, middle shift to left
     head = pre;
     head.next = null;
     if (size % 2 != 0) {
      middle = middle.pre;
     }
     size--;
     return result;
}
 
 
 public int findMid () {
     if (middle == nul) {
      return -1;
     }
     return middle.val;
 }
 
 
public int popMid () {
     if (middle == null) {
      return -1;
     }
     // if only one node exists
     int result = middle.val;
     if (middle.pre == null && middle.next == null) {
      head = null;
      middle = null;
      return result;
     }

     middle.pre.next = middle.next;
     middle.next.pre = middle.pre;
     //奇数左移，偶数右移
     if (size % 2 != 0) {
      middle = middle.pre;
     } else {
      middle = middle.next;
     }
     size--;
     return result;
    }

}















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

