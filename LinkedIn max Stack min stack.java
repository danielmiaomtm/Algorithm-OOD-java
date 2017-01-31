/*
maxStack using doubleLinkedList peekMax(), popMax();
pop peek peekMax popMax, popMax要求O(1) 
*/

class Elem{
    public int value;
    public Elem max;
    public Elem next;
    public Elem pre;
 
    public Elem(int value){
        this.value = value;
        this.max = null;
        this.next = null;
        this.pre = null;
    }
}
 
public class MaxStack {
    public Elem head;
 	public Elem max;
    /** initialize your data structure here. */
    public MinStack() {
 		this.head = null;
    	this.max = null;
    }
 
    public void push(int x) {
        if (head == null){
            head = new Elem(x);
            max = head;
        }else{
            Elem node = new Elem(x));
            node.pre = head;
            head.next = node;
            if (node.val >= max.val) {
                node.max = node;
                max = node;
            } else {
                
            }
        }
 
    }
 
    public int popMax() {
        if (head.next == null) {
        	return -1;
        }
 		Elem max = head.next.max;
 		max.next.pre = max.pre;
 		max.pre.next = max.next;
 		return max.val;
    }
 
    public int peekMax() {
        if (head.next == null) {
        	return -1;
        }
        return head.next.max.val;
    }
 
    
}




/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
   */ 
class Elem{
    public int value;
    public int min;
    public Elem next;
 
    public Elem(int value, int min){
        this.value = value;
        this.min = min;
    }
}
 
public class MinStack {
    public Elem top;
 
    /** initialize your data structure here. */
    public MinStack() {
 
    }
 
    public void push(int x) {
        if(top == null){
            top = new Elem(x, x);
        }else{
            Elem e = new Elem(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }
 
    }
 
    public void pop() {
        if(top == null)
            return;
        Elem temp = top.next;
        top.next = null;
        top = temp;
 
    }
 
    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }
 
    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
}
