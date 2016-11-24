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
    public String name;
    public List<String> email;
    Contact(String name, List<String> email) {
        this.name = name;
        this.email = email;
    }
}
class UnionFind {
    int[] parents;
    public UnionFind(int n) {
        parents = new int[n];
        for (int i = 0; i < n; i++) parents[i] = i;
    }
    public void union(int n1, int n2) {
        int r1 = find(n1);
        int r2 = find(n2);
        if (r1 != r2) {
		parents[r1] = r2;
	}
    }
    public int find(int node) {
        if (parents[node] == node) {
		return node;
	}
        parents[node] = find(parents[node]);
        return parents[node];
    }    
    public boolean isConnected(int n1, int n2) {
        return find(n1) == find(n2);
    }
}

public List<List<String>> groupContact (List<Contact> input) {

    Map<String, List<Integer>> map = new HashMap<>(); 

    int n = input.size();

    for (int i = 0; i < n; i++) {
	for (String e : input.get(i).email) {
	    List<Integer> list;
	    if (!map.containsKey(e)) {
		list = new ArrayList<>();
		list.add(i);
	    } else {
		list = map.get(e);
		list.add(i);
	    }
	    map.put(e, list);
	}
    }

    UnionFind uf = new UnionFind(n);

    for (List<Integer> list : map.values()) {
	for (int i = 0; i < list.size() - 1; i++) {
	    uf.union(list.get(i), list.get(i + 1));
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
		list = groups.get(cur);
		list.add(i);
	    }
	    groups.put(cur, list);
    }

    List<List<String>> result = new ArrayList<>();
    for (List<Integer> val : groups.values()) {
	List<String> temp = new ArrayList<>();
	for (int pos : val) {
		temp.add(input.get(pos).name);
	}
	result.add(new ArrayList<>(temp));
    }

    return result;
}


public static void main (String[] args) {
		
		practise sol = new practise();
		
		List<Contact> input = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add("aaa@gmail.com");
        list.add("bbb@gmail.com");
        String name = "c1";
       Contact c1 = new Contact(name, list);
        
        List<String> list2 = new ArrayList<>();
        list2.add("bbb@gmail.com");
        String name2 = "c2";
       
        Contact c2 = new Contact(name2, list2); 
        
        List<String> list3 = new ArrayList<>();
        list3.add("aaa@gmail.com");
        String name3 = "c3";
       
        Contact c3 = new Contact(name3, list3); 
        
        
        List<String> list4 = new ArrayList<>();
        list4.add("ddd@gmail.com");
        String name4 = "c4";
       
        Contact c4 = new Contact(name4, list4);
        
        List<String> list5 = new ArrayList<>();
        list5.add("ccc@gmail.com");
        list5.add("ddd@gmail.com");
        String name5 = "c5";
       
        Contact c5 = new Contact(name5, list5);
        
        input.add(c1);
        input.add(c2);
        input.add(c3);
        input.add(c4);
        input.add(c5);
        
        
        sol.groupContact(input);
	
	}
