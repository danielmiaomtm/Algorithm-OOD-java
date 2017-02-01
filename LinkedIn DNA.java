public List<String> findRepeatedDnaSequences(String s) {
    
    Set<Integer> words = new HashSet<>();
    Set<Integer> doubleWord = new HashSet<>();
    List<String> result = new ArrayList<>();
    
    char[] map = new char[26];
    //map['A' - 'A'] = 0;
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;

    for(int i = 0; i < s.length() - 9; i++) {
        int word = 0;
        for(int j = i; j < i + 10; j++) {
            word <<= 2;
            word |= map[s.charAt(j) - 'A'];
        }
        if(!words.add(word)) {
            if (doubleWord.add(word)) {
                result.add(s.substring(i, i + 10));
            }
        } 
    }
    return result;
}
