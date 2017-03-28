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
	
	
//find the number of employee in each department whoes friends are in other departments [Eng: 0 of 2, HR: 1 of 2, Design: 1 of 1]
	public static List<String> otherDep (String[] employeeInput, String[] friendsInput) {
		List<String> result = new ArrayList<>();
		//fiend the friendList key : id, val, set of department
		Map<String, Set<String>> friendsMap = new HashMap<>();	
		// key : id, val : department
		Map<String, String> idToDepMap = new HashMap<>();
		//key:department, val: list of id
		Map<String, List<String>> depToIdMap = new HashMap<>();
		
		for (String emp : employeeInput) {
			//set friendsMap
			String[] temp = emp.split(",");
			Set<String> set = new HashSet<>();
			friendsMap.put(temp[0], set);
			//set idToDepMap
			idToDepMap.put(temp[0], temp[2]);
			// set depToIdMap
			List<String> list;
			if (!depToIdMap.containsKey(temp[2])) {
				list = new ArrayList<>();
			} else {
				list = depToIdMap.get(temp[2]);
			}
			list.add(temp[0]);
			depToIdMap.put(temp[2], list);
		} 
		
		for (String friends : friendsInput) {
			String[] temp = friends.split(",");
			friendsMap.get(temp[0]).add(temp[1]);
			friendsMap.get(temp[1]).add(temp[0]);
		}
		
		for (String key : depToIdMap.keySet()) {
			System.out.println("id " + key);
			System.out.println(Arrays.toString(depToIdMap.get(key).toArray()));	
		}
		
		// iterate depToIdMap and find the number of employee whoes friends are in other departments
		for (String department :depToIdMap.keySet()) {
			String temp = department + ": ";
			//employee whoes friends are in other dpeartments
			int count = 0;
			for (String employee : depToIdMap.get(department)) {
				if (friendsMap.get(employee).size() == 0) {
					break;
				}
				for (String friend: friendsMap.get(employee)) {
					
					if (!idToDepMap.get(friend).equals(department)) {
						count++;
						break;
					}
				}				
			}
			temp += count + " of " + String.valueOf(depToIdMap.get(department).size());
			result.add(temp);
		}
		
		return result;
	}

	
	
	//find friends list: [3:1,4, 2:1,4, 1:3,2, 5:null, 4:3,2]	
	public static List<String> findFriend (String[] employeeInput, String[] friendsInput) {

		List<String> result = new ArrayList<>();
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
		for (String emp : friendsMap.keySet()) {
			String temp = emp + ":";

			if (friendsMap.get(emp).size() == 0) {
				temp += "null";
				result.add(temp);
			} else {
				for (String e : friendsMap.get(emp)) {
					temp += e + ",";
				}
				result.add(temp.substring(0, temp.length() - 1));
			}
		}
		return result;
	}
	
	
	
	
}

