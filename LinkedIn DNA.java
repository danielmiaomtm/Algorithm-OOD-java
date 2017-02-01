public List<String> findRepeatedDnaSequences(String s) {
        Set<Integer> words = new HashSet<>();
        Set<String> visited = new HashSet<>();
        
        //base 4 integer 4^10 
        char[] map = new char[26];
        map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        
        int num = 0;
        for(int i = 0; i < s.length(); i++) {
            
            if (i > 9) {
                // 2 : 9 -> 4 -> 18
                num -=  map[s.charAt(i - 10) - 'A'] << 18;
            }
            num = num << 2 | map[s.charAt(i) - 'A'];
            
            if (i >= 9 && !words.add(num)) {
                visited.add(s.substring(i - 9, i + 1));
            }
            
        }

        return new ArrayList<>(visited);
    }
