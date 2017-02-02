private class Node {
    Node pre;
    Node next;
    int key;
    int val;
    public Node (int key, int val) {
        this.key = key;
        this.val = val;
        this.pre = null;
        this.next = null;
    }
}

public class LRUCache {
    
    private int capacity;
    private HashMap<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.pre = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
//remove current
        Node cur = map.get(key);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
// move cur to tail
        move_to_tail(cur);
        return map.get(key).val;
    }
    
    public void set(int key, int value) {
        if (get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        if (map.size() == capacity) {
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        Node insert = new Node(key, value);
        map.put(key, insert);
        move_to_tail(insert);
    }
    private void move_to_tail(Node current) {
        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
    }
}
