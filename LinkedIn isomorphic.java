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
