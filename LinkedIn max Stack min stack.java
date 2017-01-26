/*
maxStack using doubleLinkedList peekMax(), popMax();
*/

class Elem{
    public int value;
    public Elem max;
    public Elem next;
    public Elem pre;
 
    public Elem(int value, int min){
        this.value = value;
        this.max = min;
        this.next = null;
        this.pre = null;
    }
}
 
public class MinStack {
    public Elem head;
 	public Elem node;
    /** initialize your data structure here. */
    public MinStack() {
 		this.head = null;
    	this.node = head;
    }
 
    public void push(int x) {
        if (node == null){
            node = new Elem(x, x);
            node.max = head;
        }else{
            Elem e = new Elem(x, Math.max(x, node.min));
            node.max = x < node.min ? e : node;
            e.next = node;
            node.pre = e;
            node = e;
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
