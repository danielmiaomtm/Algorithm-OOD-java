    public calss HashTableEntyr <K, V> {
      private K key;
      private V value;
      private int hash;
      private HashTableEnty<K, V> next;

    }
    public class HashMap<K, V> {
      HashTableEnty[] tab;
      public HashMap() {
        tab = new HashTableEnty[default_size];
      }
      public V get (Object key) {
        int hash = key.hashCode();
        HashTableEnty<K, V> cur = tab[hash];
        while (cur != null && cur.key != key) {
          cur = cur.next;
        }
        return cur == null ? null : cur.val;
      }
      public void put (K, V) {
        int hash = K.hashCode();
        if (tab[hash].K == K) {
          HashTableEnty<K, V> cur = new HashTableEnty<K, V>();
        }
      }
    }
