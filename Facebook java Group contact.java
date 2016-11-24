/*
有这么一个class Contact，里面有一个string的name，
和一个vector 装着email address，是这个Contact有的address，
用一个list装着是因为一个人有可 能有多个email，现在给你vector，比如
{
    { "John", {"john@gmail.com"} },
    { "Mary", {"mary@gmail.com"} },
    { "John", {"john@yahoo.com"} },
    { "John", {"john@gmail.com", "john@yahoo.com", "john@hotmail.com"} },
    { "Bob",  {"bob@gmail.com"} }
}
*/

class Contact {
	String name;
	List<String> email;
	Contac() {
		this.name = "";
		this.email = new ArrayList<>();
	}
}
public List<List<Contact>> (List<Contact> input) {
	Map<String, List<Integer>> map = new HashMap<>(); 
	int n = input.size();
	for (int i = 0; i < n; i++) {
		for (String e : Contact.email) {
			List<Integer> list;
			if (!map.containsKey(e)) {
				list = new ArrayList<>();
				list.add(i);
			} else {
				list = map.get(e));
				list.add(i);
			}
			map.put(e, list);
		}
	}

	unionFind uf = new unionFind(n);

	for (List<Integer> list : map.keySet()) {
		for (int i = 0; i < list.size() - 1; i++) {
			uf.unionFind(list.get(i), list.get(i + 1));
		}
	}
	Map<Integer, List<Integer>> groups = new HashMap<>();
	for (int i = 0; i < n; i++) {
		List<Integer> list;
		int cur = uf.find(i);
			if (!groups.containsKey(cur)) {
				list = new ArrayList<>();
				list.add(i);
			} else {
				list = groups.get(cur));
				list.add(i);
			}
			groups.put(cur, list);
	}
	
	List<List<Contact>> result = new ArrayList<>();
	for (List<Integer> list : groups.keySet()) {
		List<Contact> r = new ArrayList<>();
		for (int i : list) {
			r.add(input.get(i));
		}
		result.add(r);
	}
	return result;
}

class unionFind {
	int[] parent;
	public unionFind (int num_node) {
		for (int i = 0; i < num_node; i++) {
			parent[i] = i;
		}
	}
	public int find (int num) {
		if (parent[num] == numm) {
			return num;
		}
		parent[num] = find(parent[num]);
		return parent[num];
	}
	public void union (int num1, int num2) {
		int n1 = find(num1);
        	int n2 = find(num2);
        	if (n1 != n2) {
			parents[n1] = n2;
		}
	}

}
