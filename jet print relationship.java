String[] employeeInput = new String[]{"1,Alice,HR", "2,Bob,Engineer", "3,Daniel,Engineer","4,Chirley,Design","5,Bob,HR"};
		String[] friendsInput = new String[]{"1,2","1,3","2,4"};
		
		System.out.println("how many people in dep have other dep");
		Map<String, Integer> result = otherDep(employeeInput, friendsInput);
		for (String key : result.keySet()) {
			System.out.println(key);
			System.out.println(result.get(key));
		}
		System.out.println("friends list  ");
		Map<String, Set<String>> friendsList = findFriend(employeeInput, friendsInput);
		for (String key : friendsList.keySet()) {
			System.out.println("emp " + key);
			System.out.println(Arrays.toString(friendsList.get(key).toArray()));
		}
		System.out.println("isAllConnected ?  ");
		System.out.println(sol.isAllConnected(employeeInput, friendsInput));
	}
	
	
	//输出是否所有employee都在一个社交圈
	public static boolean isAllConnected (String[] employeeInput, String[] friendsInput) {
		
		//start from a node and check if all empoyees can be visited;
		Map<String, Set<String>> friendsMap = findFriend(employeeInput, friendsInput);
		Map<String, Boolean> visited = new HashMap<>();
		String emp = "";
		for (String key : friendsMap.keySet()) {
			if (emp.length() == 0) {
				emp = key;
			}
			visited.put(key, false);
		}

		helper(visited, emp, friendsMap);
		
		for (String empolyee : visited.keySet()) {
			if (!visited.get(empolyee)) {
				return false;
			}
		}

		return true;
	}


	public static void helper (Map<String, Boolean> visited, String emp, Map<String, Set<String>> friendsMap) {
		Set<String> friends = friendsMap.get(emp);
		visited.put(emp, true);
				
		for (String friend : friends) {
			
			if (friendsMap.get(friend).size() > 0 && !visited.get(friend)) {
				visited.put(emp, true);
				helper(visited, friend, friendsMap);
			}
		}
	}
	
	
	//
	public static Map<String, Integer> otherDep (String[] employeeInput, String[] friendsInput) {
		Map<String, Set<String>> friendsMap = findFriend(employeeInput, friendsInput);
		
		//key: department value: list of empolyee
		Map<String, Set<String>> depEmpMap = new HashMap<>();
		//key: id value:department
		Map<String, String> idToDep = new HashMap<>();
		// store <dep, List<id>>, friendList
		
		for (String emp : employeeInput) {
			String[] temp = emp.split(",");
			idToDep.put(temp[0], temp[2]);
			if (!depEmpMap.containsKey(temp[2])) {
				Set<String> set = new HashSet<>();
				set.add(temp[0]);
				depEmpMap.put(temp[2], set);
			} else {
				depEmpMap.get(temp[2]).add(temp[0]);
			}
		}
		
		Map<String, Integer> result = new HashMap<>();
		//iterate the depEmp map, and then check in the frindlist with department
		for (String dep : depEmpMap.keySet()) {
			int num = 0;	
			for (String emp : depEmpMap.get(dep)) {
				Set<String> frinds = friendsMap.get(emp);
				for (String friend : frinds) {
					if (!idToDep.get(friend).equals(dep)) {
						num++;
						break;
					}
				}
			}
			result.put(dep, num);
		}	
		return result;
	}

	
	
	// first question	
	public static Map<String, Set<String>> findFriend (String[] employeeInput, String[] friendsInput) {

		Map<String, Set<String>> friendsMap = new HashMap<>();

		for (String emp : employeeInput) {
			String[] temp = emp.split(",");
			Set<String> set = new HashSet<>();
			friendsMap.put(temp[0], set);
		}

		for (String friends : friendsInput) {
			String[] fri = friends.split(",");
			if (!friendsMap.get(fri[0]).contains(fri[1])) {
				friendsMap.get(fri[0]).add(fri[1]);
			}
			if (!friendsMap.get(fri[1]).contains(fri[0])) {
				friendsMap.get(fri[1]).add(fri[0]);
			}

		}

		return friendsMap;

	}
	
}

