// no duplicates Insert Delete GetRandom o(1)
public class RandomizedSet {

    // val-pos
    Map<Integer, Integer> map1;
    //pos - val
	Map<Integer, Integer> map2;
	Random rand;
 	public RandomizedSet() {
 		this.map1 = new HashMap<>();
 		this.map2 = new HashMap<>();
 		this.rand = new Random(System.currentTimeMillis());
	}
	public boolean insert(int val) {
		if (map1.containsKey(val)) {
			return false;
		}
		map1.put(val, map1.size());
		map2.put(map2.size(), val);
		return true;
	}
	public boolean remove(int val) {
		if (!map1.containsKey(val)) {
			return false;
		}
		int index = map1.get(val);
		
		map1.remove(val);
		map2.remove(index);
		
		if (map1.size() == 0 || map1.size() == index) {
			return true;
		}

		int nextInt = map2.get(map2.size());
		map1.put(nextInt, index);
		map2.remove(map2.size());
		map2.put(index, nextInt);
		
		return true;
	}
	public int getRandom () {
		if (map1.size() == 0) {
			return -1;
		}
		if (map1.size() == 1) {
			return map2.get(0);
		}
		return map2.get(new Random().nextInt(map1.size()));
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
 
 
 
 
 
 
 
 
 
 
 // with duplicateds 
 
 public class RandomizedCollection {
    HashMap<Integer, Set<Integer>> valMap;
    HashMap<Integer, Integer> posMap;
    Random r;
 
    /** Initialize your data structure here. */
    public RandomizedCollection() {
            valMap = new HashMap<Integer, Set<Integer>>();
            posMap = new HashMap<Integer, Integer>();
            r = new Random();
    }
 
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        //add to map2
        int size2 = posMap.size();
        posMap.put(size2, val);
 
        if(valMap.containsKey(val)){
            valMap.get(val).add(size2);
            return false;
        }else{
            Set<Integer> set = new HashSet<Integer>();
            set.add(size2);
            valMap.put(val, set);
            return true;
        }
    }
 
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(valMap.containsKey(val)){
            Set<Integer> set = valMap.get(val);
            int toRemove = set.iterator().next();
 
 
            //remove from set of valMap
            set.remove(toRemove);
 
            if(set.size()==0){
                valMap.remove(val);
            }
 
            if(toRemove == posMap.size() - 1){
                posMap.remove(toRemove);
                return true;
            }
        
            posMap.remove(toRemove);
            int size2 = posMap.size();
            
            int key = posMap.get(size2);
 
            Set<Integer> setChange = valMap.get(key);
            setChange.remove(size2);
            setChange.add(toRemove);
            
            posMap.remove(size2);
 
            posMap.put(toRemove, key);
 
            return true;
        }
 
        return false;
    }
 
    /** Get a random element from the collection. */
    public int getRandom() {
        if(posMap.size() == 0)
            return -1;
 
         if(posMap.size() == 1){
            return posMap.get(0);    
        }    
 
        return posMap.get(r.nextInt(posMap.size())); // nextInt() returns a random number in [0, n).
    }
}
