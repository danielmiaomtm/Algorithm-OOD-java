/*
input String[]   [boss, employee]
String[][] input = new String[][]{{"AA", "BB"}, {"AA", "CC"}, {"AA", "DD"}, {"CC", "EE"}};


output:
AA
 BB
 CC
  EE
 DD


*/


public void bs(String[][] input) {
		//store all into hashmap
		HashMap<String, List<String>> map = new HashMap<>();
		Set<String> employees = new HashSet<>();
		for (String[] in : input) {
			String boss = in[0];
			String emp = in[1];
			employees.add(boss);
			employees.add(emp);
			
			if (!map.containsKey(boss)) {
				map.put(boss, new ArrayList<String>());
			}
			List<String> list = map.get(boss);
			list.add(emp);
			map.put(boss, list);
			if (!map.containsKey(emp)) {
				map.put(emp, new ArrayList<String>());
			}
		}
    // find the boss
    for (List<String> list : map.values()) {
			for (String emp : list)
				if (employees.contains(emp)) {
					employees.remove(emp);
				}
		}
    
		String boss = employees.iterator().next();
		
		//start from boss, and then print all the employee
		System.out.println(boss);
		Set<String> visited = new HashSet<>();
		visited.add(boss);
		helper(map, boss, visited, 0);
	}
	
	public void helper (Map<String, List<String>> map, String boss, Set<String> visited, int index) {
		
		if (map.get(boss).size() == 0) {
			return;
		}
		for (String employee : map.get(boss)) {
			index++;
			if (visited.contains(employee)) {
				continue;
			}
			visited.add(employee);
			String temp = "";
			for (int i = 0; i < index; i++) {
				temp += " ";
			}
			System.out.println(temp + employee);
			helper(map, employee, visited, index);
			index--;
		}
	}
