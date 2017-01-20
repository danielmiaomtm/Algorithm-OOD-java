/*
  2.给string, 只包含{0,1,?}, ?可以代表0或者1, 输出所有的组合. 例如"10?", 输出"100", "101"
  
  input : "01?"
  list :  [01?, 0?1, 10?, 1?0, ?01, ?10]
  output : [010, 011, 001, 100, 101, 110]
*/

public List<String> combinations (String str) {

  List<String> list = new ArrayList<>();
  Set<String> visited = new HashSet<>();
  boolean[] pos = new boolean[str.length()];
  helper(str,list, "", visited, pos);
  System.out.println(Arrays.toString(list.toArray()));

  List<String> result = new ArrayList<>();
  visited = new HashSet<>();
  for (String curStr : list) {
    printStr (result, curStr, visited, "", 0);
}

  return result;
}
public void printStr (List<String> result, String curStr, Set<String> visited, String str, int index)  {
  if (str.length() == curStr.length()) {
    if (visited.contains(str))
        return;
    visited.add(str);
    result.add(new String(str));
    return;
  }
  if (index < curStr.length()) {
    char c = curStr.charAt(index); 
    if (c != '?') {
      printStr(result, curStr, visited, str + c + "", index + 1);
  } else {
    char[] temp = new char[] {'0', '1'};
    for (char t : temp) {
      printStr (result, curStr, visited, str + t + "", index + 1);
    }
  }
}

}

public void helper (String input, List<String> list, String str, Set<String> set, boolean[] pos) {
  if (str.length() == input.length()) {
    if (set.contains(str)) {
      return;
    } else {
      set.add(str);
      list.add(new String(str));
      return;
    }
  }
  for (int i = 0; i < input.length(); i++) {
    if (pos[i]) {
        continue;
    }
    pos[i] = true;
    helper(input, list, str + input.charAt(i) + "", set, pos);
    pos[i] = false;
  }
}
