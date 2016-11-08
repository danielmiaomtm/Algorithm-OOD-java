  public class Solution {

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

      private int capacity;
      private HashMap<Integer, Node> map = new HashMap<>();
      private Node head = new Node(-1, -1);
      private Node tail = new Node(-1, -1);

      public Solution(int capacity) {
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
  
  
  //  LinkedHashMap
  import java.util.LinkedHashMap;
  import java.util.Map;
  public class LRUCache {
      private Map<Integer, Integer> map;
      private int capacity;
      public LRUCache(int capacity) {
          this.capacity = capacity;
          map = new LinkedHashMap<Integer, Integer>(capacity + 1);
      }

      public int get(int key) {
          Integer val = map.get(key);
          if (val == null) return -1;
          map.remove(key);
          map.put(key, val);
          return val;
      }

      public void set(int key, int value) {
          map.remove(key);
          map.put(key, value);
          if (map.size() > capacity)
              map.remove(map.entrySet().iterator().next().getKey());
      }
  }
