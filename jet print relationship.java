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
	

		//frindList helper funciton
		public static Map<String, Set<String>> IdToFriendsMap (String[] employeeInput, String[] friendsInput) {
			Map<String, Set<String>> map = new HashMap<>();

			for (String emp : employeeInput) {
				String[] temp = emp.split("\\s+");
				Set<String> set = new HashSet<>();
				map.put(temp[0], set);		
			}

			for (String friends : friendsInput) {
				String[] fri = friends.split("\\s+");			
				map.get(fri[0]).add(fri[1]);
				map.get(fri[1]).add(fri[0]);							
			}
			return map;
		}

		//找出每个人有多少好友 
		//find friends list: [3: (1,5), 2: (1,4), 1: (3,2), 5: (3), 4: (2)]	
		public static List<String> findFriendsList (String[] employeeInput, String[] friendsInput) {

			List<String> result = new ArrayList<>();
			Map<String, Set<String>> IdToFriendsMap = IdToFriendsMap(employeeInput, friendsInput);
		
			for (String emp : IdToFriendsMap.keySet()) {
				String temp = emp + ": (";

				if (IdToFriendsMap.get(emp).size() == 0) {
					temp += "null";
				} else {
					for (String e : IdToFriendsMap.get(emp)) {
						temp += e + ",";
					}
					temp = temp.substring(0, temp.length() - 1);
				}
				temp += ")";
				result.add(temp);
			}
			return result;
		}




	
	
	//find the number of employee in each department whoes friends are in other departments [Eng: 0 of 2, HR: 1 of 2, Design: 1 of 1]
		public static List<String> depDetail (String[] employeeInput, String[] friendsInput) {
			List<String> result = new ArrayList<>();
			//fiend the friendList key : id, val, set of department
			Map<String, Set<String>> IdToFriendsMap = IdToFriendsMap(employeeInput, friendsInput);;	
			// key : id, val : department
			Map<String, String> idToDepMap = new HashMap<>();
			//key:department, val: list of id
			Map<String, List<String>> depToIdsMap = new HashMap<>();
			
			for (String emp : employeeInput) {
				String[] temp = emp.split("\\s+");
				//set idToDepMap
				idToDepMap.put(temp[0], temp[2]);
				// set depToIdMap
				List<String> list;
				if (!depToIdsMap.containsKey(temp[2])) {
					list = new ArrayList<>();
				} else {
					list = depToIdsMap.get(temp[2]);
				}
				list.add(temp[0]);
				depToIdsMap.put(temp[2], list);
			} 
			
			// iterate depToIdMap and find the number of employee whoes friends are in other departments
			for (String department :depToIdsMap.keySet()) {
				
				//employee whoes friends are in other dpeartments
				int count = 0;
				for (String employee : depToIdsMap.get(department)) {
					if (IdToFriendsMap.get(employee).size() == 0) {
						break;
					}
					for (String friend: IdToFriendsMap.get(employee)) {
						
						if (!idToDepMap.get(friend).equals(department)) {
							count++;
							break;
						}
					}				
				}
				String temp = department + ": " + count + " of " + String.valueOf(depToIdsMap.get(department).size());
				result.add(temp);
			}
			
			return result;
		}





	//输出是否所有employee都在一个社交圈
	public static boolean isAllConnected (String[] employeeInput, String[] friendsInput) {
		
		//start from a node and check if all empoyees can be visited;
		Map<String, Set<String>> IdToFriendsMap = IdToFriendsMap(employeeInput, friendsInput);
		Map<String, Boolean> visited = new HashMap<>();
		String empId = "";
		for (String key : IdToFriendsMap.keySet()) {
			if (empId.length() == 0) {
				empId = key;
			}
			visited.put(key, false);
		}

		helper(visited, empId, IdToFriendsMap);
		
		for (String empolyee : visited.keySet()) {
			if (!visited.get(empolyee)) {
				return false;
			}
		}

		return true;
	}

	public static void helper (Map<String, Boolean> visited, String empId, Map<String, Set<String>> friendsMap) {
		Set<String> friendsList = friendsMap.get(empId);
		visited.put(empId, true);
				
		for (String friendId : friendsList) {
			
			if (friendsMap.get(friendId).size() > 0 && !visited.get(friendId)) {
				visited.put(friendId, true);
				helper(visited, friendId, friendsMap);
			}
		}
	}	







	
}

