//实现hashTable
    public int hashCode (char[] key, int hash_size) {
      long hashCode = 0;
      long baseV = 1;
      for (int i = key.length - 1; i >= 0; i--) {
        hashCode += key[i] * baseV;
        baseV = baseV * 33;
      }

      return (int) (hashCode % hash_size);
    }
    public ListNode[] rehashing (ListNode[] hashTable) {
      if (hashTable == null || hashTable.length == 0) {
        return null;
      }
      ListNode[] result = new ListNode[hashTable.length * 2];
      for (int i = 0; i < hashTable.length; i++) {
        while (hashTable[i] != null) {
          int index = (hashTable[i].val % result.length + result.length) % result.length;
          ListNode temp = result[index];
          if (temp == null) {
            temp = new ListNode(hashTable[i].val);
          } else {
            while (temp.next != null) {
              temp = temp.next;
            }
            temp.next = new ListNode(hashTable[i].val);
          }
        }
        hashTable[i] = hashTable[i].next;
      }
    }
