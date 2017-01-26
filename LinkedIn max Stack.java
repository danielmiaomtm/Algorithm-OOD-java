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
