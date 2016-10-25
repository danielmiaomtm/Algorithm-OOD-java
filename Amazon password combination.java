/*
就是给你一个map {'a' '@'} {'s' '$'} {'e' '3'} ... 然后给你一个用户输入的passwd 让你帮用户推荐一下保密性更强的passwd 
给出所有的结果  例如 用户输入pass  你返回 {pass， p@ss， pa$s, pa$$, p@$$... } 所有的结果
*/
input: pass
output : [pass, pas$, pa$s, pa$$, p@ss, p@s$, p@$s, p@$$]



	
	public List<String> comb (String pwd, Map<Character, Character> map) {
		List<String> list = new ArrayList<>();
		if (pwd == null || pwd.length() == 0) {
			return list;
		}
		if (pwd.length() == 1) {
			char c = pwd.charAt(0);
			list.add("" + c);
			if (map.containsKey(c)) {
				list.add("" + map.get(c));
			}  

			return list;
		}
		List<String> left = new ArrayList<>();
		char c = pwd.charAt(0);
		left.add("" + c);
		if (map.containsKey(c)) {
			left.add("" + map.get(c));
		}  
		
		List<String> right = comb(pwd.substring(1, pwd.length()), map);
		
		for (int i = 0; i < left.size(); i++) {
			for (int j = 0; j < right.size(); j++) {
				list.add(left.get(i) + right.get(j) + "");
			}
		}

		return list;
	}
  
  
  
public static void main (String[] args) {
		practise sol = new practise();
		Map<Character, Character> m = new HashMap<>();
		m.put('a', '@');
		m.put('s', '$');
		List<String> result = sol.comb("pass", m);
		System.out.println(Arrays.toString(result.toArray()));
	}
	
