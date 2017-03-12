／*
设计一个Map, get() 和 set() function, 每个set同时还set一个expiration time, get 的时候如果expire了就返回null， 这个用普通hashmap就能解决. 鍥磋鎴戜滑@1point 3 acres
follow up 加一个clean function，clean所有expire的entry，我就加了一个heap解决，到这里大概30分钟不到
他说他准备的问题问完了，然后我们又强行聊到40分钟挂电话了
*／

class Node {
	int key;
	int val;
	long exp;
	Node (int key, int val, long exp) {
		this.key = key;
		this.val = val;
		this.exp = exp;
	}
}

class ExperationMap {
	Map<Integer, Node> map;
	TreeMap<Long, Set<Integer>> expMap;
	ExperationMap () {
		this.map = new HashMap<>();
		this.expMap = new TreeMap<>();
	}

	public Integer get(int key) {
		if (!map.containsKey(key)) {
			return null;
		} else {
			Node cur = map.get(key);
			if (cur.exp < curTime) {
				map.remove(key);
				Set<Integer> list = expMap.get(cur.exp);
				list.remove(key);
				return null;
			}
			return map.get(key).val;
		}
	}
	public void set (int key, int val, long exp) {
		if (!map.containsKey(key)) {
			map.put(key, new Node(key, val, exp));
			Set<Integer> temp;
			if (!expMap.containsKey(key)) {
				temp = new HashSet<>();
			} else {
				temp = expMap.get(exp);
			}
			temp.add(key);
			expMap.put(exp, temp);
		} else {
			Node preNode = map.get(key);
			map.get(key).val = val;
			map.get(key).exp = exp;

			expMap.get(preNode.exp).remove(preNode.key);
			
			Set<Integer> temp;
			if (!expMap.containsKey(key)) {
				temp = new HashSet<>();
			} else {
				temp = expMap.get(exp);
			}
			temp.add(key);
			expMap.put(exp, temp);
		
		}
	}
}

public void clean (long exp) {
	List<Long> list = expMap.lower(exp);
	if (list.size() == 0) {
		return;
	}
	for (long expTime : list) {
		//remove in map
		Set<Integer> keys = expMap.get(expTime);
		for (int key : keys) {
			if (map.containsKey(key)) {
				map.remove(key);
			}
		}
		//remove in the expMap
		expMap.remove(expTime);
	}

}
