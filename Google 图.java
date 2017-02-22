/*
要实现一个class造一个房子，房子有很多结构，每个结构都有dependencies，例如house: wall, window, door，然后wall：concrete之类的。
简单的说就是 X: A B C, Y: D E F, Z: X Y. 要实现两个函数，第一个是添加dependencies, 貌似叫addRule(string name, list<string> dependencies); 
比如把（X，{A, B, C})添加进去。第二个是 list<string> getRules(); 把之前添加进去的以以下顺序放到一个list里面返回： A B C X D E F Y Z。
其实就是个图的深度优先搜索.

[A, B, C, X, D, E, F, Y, Z]
idea：hashmap

*／
  
  
  	public static void main(String[] args) throws Exception{
		
		final practise sol = new practise();

		sol.addRule("X", new ArrayList<>(Arrays.asList("A", "B", "C")));
		sol.addRule("Y", new ArrayList<>(Arrays.asList("D", "E", "F")));
		sol.addRule("Z", new ArrayList<>(Arrays.asList("X", "Y")));
		
		List<String> result = sol.getRules();
		System.out.println(Arrays.toString(result.toArray()));
		
		
	}
  
  
  Map<String, List<String>> graph = new HashMap<>();
	Map<String, Integer> indegree = new HashMap<>();

	public void addRule(String name, List<String> dependencies) {
		if (!graph.containsKey(name)) {
			List<String> list = new ArrayList<>();
			graph.put(name, list);
		}
			graph.get(name).addAll(dependencies);
		
		
		for (String dep : dependencies) {
			if (!indegree.containsKey(dep)) {
				indegree.put(dep, 1);
			} else {
				indegree.put(dep, indegree.get(dep) + 1);
			}
			
		}
		if (!indegree.containsKey(name)) {
			indegree.put(name, 0);
		}

	}
	public List<String> getRules () {
		List<String> result = new ArrayList<>();
		
		for (String key : indegree.keySet()) {
			if (indegree.get(key) == 0) {
				helper(result, key);
				result.add(key);
			}
		}
		return result;
	}
	public void helper (List<String> result, String next) {

		if (!graph.containsKey(next)) {
			return;
		}
		for (String n : graph.get(next)) {			
			helper(result, n);
			result.add(n);
		}
		
	
