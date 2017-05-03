public boolean isIsomorphic(String s, String t) {
        
       HashMap<Character, Character> map = new HashMap<>();
       HashSet<Character> set = new HashSet<>();
      
       for (int i = 0; i < s.length(); i++) {
           char sc = s.charAt(i), tc = t.charAt(i);
           if (map.containsKey(sc)) {
               if (tc != map.get(sc)) {
                   return false;
               }
           } else {
               map.put(sc, tc);
               if (!set.add(tc)) {
                   return false;
               }
           }
       }
       
       return true;
    }










List<String> words = new ArrayList<>();
words.add("aaaa");
words.add("eeee");
words.add("ffff");
words.add("abba");
words.add("effe");
words.add("fcdf");
words.add("atfa");
words.add("erge");
words.add("fwed");
List<List<String>> rst = sol.groupStr(words);

for (List<String> list : rst)
        System.out.println(Arrays.toString(list.toArray()));
		

/*
[abba, effe]
[fcdf, atfa, erge]
[fwed]
[aaaa, eeee, ffff]
*/



public List<List<String>> groupStr (List<String> words) {
        Map<String, List<String>> map = new HashMap<>();
        for (String word : words) {
                String temp = trans(word);
                List<String> list;
                if (!map.containsKey(temp)) {
                        list = new ArrayList<>();
                        list.add(word);
                        map.put(temp, list);
                } else {
                        map.get(temp).add(word);
                }
        }
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
                result.add(new ArrayList<>(list));
        }
        return result;
}
public String trans (String str) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                List<Integer> list;
                if (map.containsKey(c)) {
                        list = map.get(c);
                        list.add(i);
                        map.put(c, list);
                } else {
                        list = new ArrayList<>();
                        list.add(i);
                        map.put(c, list);
                }
        }
        int counter = 1;
        int[] chars = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
                if (!map.containsKey(str.charAt(i))) {
                        continue;
                }
                List<Integer> list = map.get(str.charAt(i));
                map.remove(str.charAt(i));

                for (int j = 0; j < list.size(); j++) {
                        chars[j] = list.get(j);
                }
                counter++;
        }

        return Arrays.toString(chars);
}
	
