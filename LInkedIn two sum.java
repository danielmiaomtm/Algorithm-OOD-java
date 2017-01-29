
/*
O(1) add, O(n) find
*/


public class TwoSum {
    private HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

    public void add(int number) {
        map.put(number, map.containsKey(number) ? map.get(number) + 1 : 1);
    }

    public boolean find(int value) {
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int i = entry.getKey();
            int j = value - i;
            if ((i == j && entry.getValue() > 1) || (i != j && map.containsKey(j))) {
                return true;
            }
        }
        return false;
    }
}



/*
O(n) add, O(1) find
*/
public class TwoSum {
    Set<Integer> sum;
    Set<Integer> num;

    TwoSum(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }
    // Add the number to an internal data structure.
  public void add(int number) {
      if(num.contains(number)){
          sum.add(number * 2);
      }else{
          Iterator<Integer> iter = num.iterator();
          while(iter.hasNext()){
              sum.add(iter.next() + number);
          }
          num.add(number);
      }
  }

    // Find if there exists any pair of numbers which sum is equal to the value.
  public boolean find(int value) {
      return sum.contains(value);
  }
}
