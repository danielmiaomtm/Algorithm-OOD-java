import java.util.*;


public class MyHash<K, V> {
	
	static class Node<K, V> {
		K key;
		V value;
		Node<K, V> next;
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public ArrayList<Node<K, V>> buffer;
	public int maxSize;
	public int curSize;
	
	public MyHash(int maxSize) {
		this.buffer = new ArrayList<>(maxSize);
		for (int i = 0 ; i < maxSize; i++) {
			buffer.add(null);
		}
		this.maxSize = maxSize;
		this.curSize = 0;
	}
	
	public MyHash() {
		this.buffer = new ArrayList<>(100);
		for (int i = 0 ; i < 100; i++) {
			buffer.add(null);
		}
		this.maxSize = 100;
		this.curSize = 0;
	}
	
	public void put(K key, V value) {
		int code = key.hashCode();
		int hashKey = code % maxSize;
		Node<K, V> newNode = new Node<>(key, value);
		if (buffer.get(hashKey) == null) {
			buffer.set(hashKey, newNode);
		} else {
			Node<K, V> head = buffer.get(hashKey);
			Node<K, V> cur = head;
			Node<K, V> pre = null;
 			while (cur != null && !cur.key.equals(key)) {
 				pre = cur;
				cur = cur.next;
			}
 			if (cur == null) {
 				pre.next = newNode;
 			} else {
 				pre.next = newNode;
 				newNode.next = cur.next;
 			}
		}
		curSize++;
	}
	
	public V get(K key) {
		int hashKey = key.hashCode() % maxSize;
		if (buffer.get(hashKey) == null) {
			return null;
		} else {
			Node<K, V> cur = buffer.get(hashKey);
 			while (cur != null && !cur.key.equals(key)) {
				cur = cur.next;
			}
 			return cur.value;
		}
	}
	
	public static void main(String[] args) {
		MyHash<Integer, String> map = new MyHash<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "c");
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
	}
}
